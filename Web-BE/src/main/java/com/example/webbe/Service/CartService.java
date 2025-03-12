package com.example.webbe.Service;

import com.example.webbe.DTO.ResponseDto;
import com.example.webbe.Entity.CartItem;
import com.example.webbe.Entity.Product;
import com.example.webbe.Repository.ProductRepository;
import com.example.webbe.exception.EnumCode;
import com.example.webbe.exception.ResponseBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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

    public void addToCart(String sessionId, String productId, int quantity) {
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


    public void mergeCart(String sessionId, String userId) {
        String sessionCartKey = "cart:" + sessionId;
        String userCartKey = "cart:" + userId;

        // Lấy giỏ hàng session
        Map<Object, Object> sessionCart = redisTemplate.opsForHash().entries(sessionCartKey);
        Map<Object, Object> userCart = redisTemplate.opsForHash().entries(userCartKey);

        // Hợp nhất giỏ hàng
        sessionCart.forEach((k, v) -> userCart.putIfAbsent(k, v));

        redisTemplate.opsForHash().putAll(userCartKey, userCart);

        redisTemplate.delete(sessionCartKey);
    }

    public void removeItem(String userId, String productId) {
        String key = CART_PREFIX + userId;
        redisTemplate.opsForHash().delete(key, productId);
    }

    public void clearCart(String userId) {
        String key = CART_PREFIX + userId;
        redisTemplate.delete(key);
    }
}

