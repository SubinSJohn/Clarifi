package com.subin.clarifi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subin.clarifi.entity.Transaction;
import com.subin.clarifi.service.TransactionService;

@RestController
@RequestMapping("/api/{userId}/transaction")
public class TransactionController{

    @Autowired
    TransactionService transactionService;

    @PostMapping("/add")
    public ResponseEntity<Transaction> addEntry(@PathVariable Long userId, @RequestBody Transaction transaction){
        Transaction saveTransaction = transactionService.save(userId, transaction);
        return new ResponseEntity<>(saveTransaction, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> update(@PathVariable Long id, @PathVariable Long userId, @RequestBody Transaction transaction){
        Transaction updateTransaction = transactionService.update(userId, id, transaction);
        return ResponseEntity.ok(updateTransaction);
    }



}


