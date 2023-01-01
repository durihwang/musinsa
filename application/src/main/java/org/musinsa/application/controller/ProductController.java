package org.musinsa.application.controller;

import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.musinsa.application.dto.FindProductRequestDto;
import org.musinsa.application.dto.FindProductResponseDto;
import org.musinsa.application.dto.ResponseDto;
import org.musinsa.application.dto.UpdateProductRequestDto;
import org.musinsa.application.service.ProductService;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "/product/{productName}")
    public ResponseDto<List<FindProductResponseDto>> findProduct(
        @PathVariable String productName,
        @RequestParam @Nullable String optionName) {

        return productService.getProduct(productName,
            optionName);
    }

    @PutMapping(value = "/product/increase")
    public void increaseProduct(@RequestBody @Valid UpdateProductRequestDto updateProductRequestDto) {

    }

    @PutMapping(value = "/product/decrease")
    public void decreaseProduct(@RequestBody @Valid UpdateProductRequestDto updateProductRequestDto) {

    }
}
