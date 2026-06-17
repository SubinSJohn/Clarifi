package com.subin.clarifi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subin.clarifi.entity.Transaction;
import com.subin.clarifi.entity.User;
import com.subin.clarifi.repository.TransactionRepository;
import com.subin.clarifi.repository.UserRepository;

@Service
public class TransactionService{


    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    UserRepository userRepository;

    public Transaction save(Long userId, Transaction transaction){
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        transaction.setUser(user);
        return transactionRepository.save(transaction);
    }

    public Transaction update(Long userId, Long id, Transaction transaction){
        
        Transaction checkIdExist = transactionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Transaction not found with the Id"));

        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User cannot be found from TransactionService"));
        transaction.setUser(user);
        transaction.setId(id);
        return transactionRepository.save(transaction);
     }
}

