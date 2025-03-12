package com.example.webbe.Controller;

import com.example.webbe.Entity.CartItem;
import com.example.webbe.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<?> addToCart(
            @CookieValue(name = "sessionId", required = false) String sessionId,
            @RequestParam String productId,
            @RequestParam(defaultValue ="1") int quantity) {

        if (sessionId == null) {
            return ResponseEntity.badRequest().body("sessionId không hợp lệ!");
        }

        cartService.addToCart(sessionId, productId, quantity);
        return ResponseEntity.ok("Thêm vào giỏ hàng thành công!");
    }

    @GetMapping("/view")
    public ResponseEntity<List<CartItem>> getCart(
            @CookieValue(name = "sessionId", required = false) String sessionId) {

        if (sessionId == null) {
            return ResponseEntity.badRequest().body(null);
        }

        Map<String, CartItem> cartMap = (Map<String, CartItem>) cartService.getCart(sessionId);
        List<CartItem> cartList = new ArrayList<>(cartMap.values());

        return ResponseEntity.ok(cartList);
    }

    @DeleteMapping("/remove")
    public String removeItem(@RequestParam String userId, @RequestParam String productId) {
        cartService.removeItem(userId, productId);
        return "Đã xóa sản phẩm khỏi giỏ hàng!";
    }

    @DeleteMapping("/clear")
    public String clearCart(@RequestParam String userId) {
        cartService.clearCart(userId);
        return "Giỏ hàng đã được xóa!";
    }

//    @GetMapping("/total/{userId}")
//    public double getTotalPrice(@PathVariable String userId) {
//        return cartService.getTotalPrice(userId);
//    }
}

