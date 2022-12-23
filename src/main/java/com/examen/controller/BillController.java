package com.examen.controller;

import com.examen.entity.Bill;
import com.examen.entity.User;
import com.examen.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/a")
public class BillController {
    @Autowired
    private BillRepository billRepository;

    @GetMapping()
    public List<Bill> getBills(){
        return billRepository.findAll();
    }
}
