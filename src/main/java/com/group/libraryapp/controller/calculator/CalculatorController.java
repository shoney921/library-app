package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    @GetMapping("/add/query")
    public int addMethod(@RequestParam int number1, @RequestParam int number2) {
        return number1 + number2;
    }

    @GetMapping("/add/body")
    public int addMethodBody(@RequestBody CalculatorAddRequest req) {
        return req.getNumber1() + req.getNumber2();
    }

    @PostMapping("/multiply/body")
    public int multiplyBody(@RequestBody CalculatorAddRequest request) {
        return request.getNumber1() * request.getNumber2();
    }
}
