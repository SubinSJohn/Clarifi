package com.subin.clarifi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.subin.clarifi.entity.Transaction;
import com.subin.clarifi.entity.User;

import java.util.Optional;

import java.time.LocalDate;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

    Optional<User> findByUserId(Long userId);
    Optional<User> findByUserIdAndFinanceType(Long userId, Transaction.FinanceType financeType);
    Optional<User> findByUserIdOrderByDateDesc(Long userId);
    Optional<User> findByUserIdAndDateBetween(Long userId, LocalDate start, LocalDate end);
}
