package com.example.webbe.Service;

import com.example.webbe.DTO.ResponseDto;
import com.example.webbe.Entity.CartItem;
import com.example.webbe.Entity.Product;
import com.example.webbe.Repository.ProductRepository;
import com.example.webbe.exception.EnumCode;
import com.example.webbe.exception.ResponseBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@AllArgsConstructor
@Service
public class CartService {
    private static final String CART_PREFIX = "cart:";
    private final ProductRepository productRepository;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public ResponseEntity<ResponseDto<Object>> addToCart(String sessionId, String productId, int quantity) {

        try{
            String key = "cart:" + sessionId;

            Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("ko có id"));

            Map<Object, Object> rawCart = redisTemplate.opsForHash().entries(key);
            Map<String, CartItem> cart = new HashMap<>();

            rawCart.forEach((k, v) -> {
                CartItem cartItem = objectMapper.convertValue(v, CartItem.class);
                cart.put((String) k, cartItem);
            });

            cart.compute(productId, (id, existingItem) -> {
                if (existingItem == null) {
                    return new CartItem(productId, product.getName(), product.getImage(), product.getPrice(), quantity, product.getPrice() * quantity);
                } else {
                    existingItem.setQuantity(existingItem.getQuantity() + quantity);
                    existingItem.setTotalPrice(existingItem.getPrice() * existingItem.getQuantity());
                    return existingItem;
                }
            });
            redisTemplate.opsForHash().put(key, productId, objectMapper.convertValue(cart.get(productId), Object.class));
            return ResponseBuilder.okResponse(EnumCode.ADD_CART_SUCCESSFULLY, null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseBuilder.failedResponse(EnumCode.ADD_CART_FAILED);
        }

    }

    public ResponseEntity<ResponseDto<Object>> getCart(String sessionId) {
        try{
            String key = "cart:" + sessionId;
            Map<Object, Object> rawCart = redisTemplate.opsForHash().entries(key);
            Map<String, CartItem> cart = new HashMap<>();
            rawCart.forEach((k, v) -> {
                CartItem cartItem = objectMapper.convertValue(v, CartItem.class);
                cart.put((String) k, cartItem);
            });

            return ResponseBuilder.okResponse(EnumCode.SUCCESSFULLY,cart);

        }catch (Exception e){
            e.printStackTrace();
            return ResponseBuilder.failedResponse(EnumCode.GET_CART_FAILED);
        }
    }


    public void mergeGuestCartToUserCart(String sessionId, String userId) {
        String guestCartKey = "cart:" + sessionId;
        String userCartKey = "cart:" + userId;

        Map<Object, Object> guestCartRaw = redisTemplate.opsForHash().entries(guestCartKey);
        Map<String, CartItem> guestCart = new HashMap<>();
        guestCartRaw.forEach((k, v) -> guestCart.put((String) k, objectMapper.convertValue(v, CartItem.class)));

        Map<Object, Object> userCartRaw = redisTemplate.opsForHash().entries(userCartKey);
        Map<String, CartItem> userCart = new HashMap<>();
        userCartRaw.forEach((k, v) -> userCart.put((String) k, objectMapper.convertValue(v, CartItem.class)));

        guestCart.forEach((productId, guestItem) -> {
            userCart.compute(productId, (id, existingItem) -> {
                if (existingItem == null) {
                    return guestItem;
                } else {
                    existingItem.setQuantity(existingItem.getQuantity() + guestItem.getQuantity());
                    existingItem.setTotalPrice(existingItem.getPrice() * existingItem.getQuantity());
                    return existingItem;
                }
            });
        });

        redisTemplate.delete(userCartKey);
        userCart.forEach((productId, cartItem) -> {
            redisTemplate.opsForHash().put(userCartKey, productId, objectMapper.convertValue(cartItem, Object.class));
        });

        redisTemplate.delete(guestCartKey);
    }


    public ResponseEntity<ResponseDto<Object>> removeItem(String userId, String productId) {
        try{
            String key = CART_PREFIX + userId;
            redisTemplate.opsForHash().delete(key, productId);
            return ResponseBuilder.okResponse(EnumCode.DELETE_SUC, null);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


    public ResponseEntity<ResponseDto<Object>> updateCart(String sessionId, String productId, int quantity) {
        try {
            String key = "cart:" + sessionId;

            Map<Object, Object> rawCart = redisTemplate.opsForHash().entries(key);
            Map<String, CartItem> cart = new HashMap<>();

            rawCart.forEach((k, v) -> {
                CartItem cartItem = objectMapper.convertValue(v, CartItem.class);
                cart.put((String) k, cartItem);
            });

            if (!cart.containsKey(productId)) {
                throw new RuntimeException("Sản phẩm không tồn tại trong giỏ hàng");
            }

            CartItem item = cart.get(productId);
            item.setQuantity(quantity);
            item.setTotalPrice(item.getPrice() * quantity);

            redisTemplate.opsForHash().put(key, productId, objectMapper.convertValue(item, Object.class));

            return ResponseBuilder.okResponse(EnumCode.SUCCESSFULLY, item);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBuilder.failedResponse(EnumCode.EDIT_CART_FAILED);
        }
    }

}

