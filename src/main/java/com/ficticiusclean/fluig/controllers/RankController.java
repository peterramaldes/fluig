package com.ficticiusclean.fluig.controllers;

import com.ficticiusclean.fluig.controllers.dtos.VehicleDTO;
import com.ficticiusclean.fluig.services.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankController {

    @Autowired
    private RankService service;

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> rank(
            @RequestParam("price") BigDecimal price,
            @RequestParam("traveledCity") Double traveledCity,
            @RequestParam("traveledHighway") Double traveledHighway
    ) {
        return new ResponseEntity<>(service.rank(price, traveledCity, traveledHighway), HttpStatus.OK);
    }

}
