package org.musinsa.application.controller;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.musinsa.application.dto.FindProductRequestDto;
import org.musinsa.application.dto.FindProductResponseDto;
import org.musinsa.application.dto.ResponseDto;
import org.musinsa.application.service.ProductService;
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

    @GetMapping(value = "/product/{productName}/{optionName}")
    public FindProductResponseDto findProduct(
        @PathVariable String productName,
        @PathVariable String optionName) {

        ResponseDto<FindProductResponseDto> productDto = productService.getProduct(productName,
            optionName);
        return null;
    }

    @PutMapping(value = "/product/{productName}/{optionName}/increase/{quantity}")
    public void increaseProduct(@PathVariable String productName,
        @PathVariable String optionName,
        @PathVariable int quantity) {

    }

    @PutMapping(value = "/product/{productName}/{optionName}/decrease/{quantity}")
    public void decreaseProduct(@PathVariable String productName,
        @PathVariable String optionName,
        @PathVariable int quantity) {

    }
}
