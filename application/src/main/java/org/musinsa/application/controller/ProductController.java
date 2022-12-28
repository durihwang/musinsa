package org.musinsa.application.controller;

import javax.validation.Valid;
import org.musinsa.application.dto.FindProductRequestDto;
import org.musinsa.application.dto.FindProductResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping(value = "/product")
    public FindProductResponseDto findProduct(
        @RequestBody @Valid FindProductRequestDto findProductRequestDto) {

        return null;
    }

    @PutMapping(value = "/product/{productName}/{optionName}/{quantity}")
    public void updateProduct() {

    }
}
