package com.bruno.silva.severosdelivery.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {




    @GetMapping("/")
    public String index(){
        return "Bem-Vindo ao sistema de pedidos da Severos Delivery";
    }

}

