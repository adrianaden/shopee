package org.shopee.adrianaden.challenge.api.controller;


import org.shopee.adrianaden.challenge.api.dto.BillSummary;
import org.shopee.adrianaden.challenge.api.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bill")
@CrossOrigin
public class BillController {
    @Autowired
    private BillService billService;

    @GetMapping
    ResponseEntity<BillSummary> findAll() {
        return ResponseEntity.ok(billService.findAll());
    }
}
