package com.example.webbe.Controller;

import com.example.webbe.DTO.ResponseDto;
import com.example.webbe.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/home/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<ResponseDto<Object>> addToCart(
            @CookieValue(name = "sessionId", required = false) String sessionId,
            @RequestParam String productId,
            @RequestParam(defaultValue ="1") int quantity) {

        return cartService.addToCart(sessionId, productId, quantity);

    }

    @PatchMapping
    public ResponseEntity<ResponseDto<Object>> updateCart(
            @CookieValue(name = "sessionId", required = false) String sessionId,
            @RequestParam String productId,
            @RequestParam int quantity) {

        return cartService.updateCart(sessionId, productId, quantity);
    }

    @GetMapping
    public ResponseEntity<ResponseDto<Object>> getCart(
            @CookieValue(name = "sessionId", required = false) String sessionId) {

      return cartService.getCart(sessionId);
    }

    @DeleteMapping()
    public ResponseEntity<ResponseDto<Object>> removeItem(@RequestParam String userId, @RequestParam String productId) {
        return cartService.removeItem(userId, productId);
    }


}

