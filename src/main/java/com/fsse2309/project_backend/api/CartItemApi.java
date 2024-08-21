package com.fsse2309.project_backend.api;

import com.fsse2309.project_backend.config.EnvConfig;
import com.fsse2309.project_backend.domainObject.CartItemDataOut;
import com.fsse2309.project_backend.dto.CartItemResponseDto;
import com.fsse2309.project_backend.service.CartItemService;
import com.fsse2309.project_backend.service.ProductService;
import com.fsse2309.project_backend.service.UserService;
import com.fsse2309.project_backend.utill.JwtUtill;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin({EnvConfig.devEnvBaseUrl,EnvConfig.prodBaseUrl,EnvConfig.devEnvBaseUrl1})
public class CartItemApi {
    private CartItemService cartItemService;
    private UserService userService;
    private ProductService productService;

    public CartItemApi(CartItemService cartItemService, UserService userService){
        this.cartItemService = cartItemService;
        this.userService = userService;
    }

    @PutMapping("/{pid}/{quantity}")
    public void addCartItem(JwtAuthenticationToken jwt,
                            @PathVariable int pid,
                            @PathVariable int quantity){
        cartItemService.addCartItem(
                pid,
                quantity,
                JwtUtill.getFirebaseUser(jwt)
        );
    }

    @GetMapping()
    public List<CartItemResponseDto> getCartItem(JwtAuthenticationToken jwt){
        List<CartItemResponseDto> cartItemResponseDtoList = new ArrayList<>();
        for (CartItemDataOut cartItemDataOut: cartItemService.getCartItem(JwtUtill.getFirebaseUser(jwt))){
            CartItemResponseDto cartItemResponseDto = new CartItemResponseDto(cartItemDataOut);
            cartItemResponseDtoList.add(cartItemResponseDto);
        }
        return cartItemResponseDtoList;
    }

    @PatchMapping("/{pid}/{quantity}")
    public CartItemResponseDto updateCartItem(JwtAuthenticationToken jwt,
                                              @PathVariable int pid,
                                              @PathVariable int quantity){
        CartItemDataOut cartItemDataOut = cartItemService.updateItem(pid,quantity,JwtUtill.getFirebaseUser(jwt));
        CartItemResponseDto cartItemResponseDto = new CartItemResponseDto(cartItemDataOut);
        return cartItemResponseDto;
    }

    @DeleteMapping ("/{pid}")
    public void deleteCartItem(JwtAuthenticationToken jwt,
                                      @PathVariable int pid){
        cartItemService.deleteItem(pid,JwtUtill.getFirebaseUser(jwt));
    }

}
