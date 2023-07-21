package com.brillio.repository;

import com.brillio.model.BankUser;
import com.brillio.model.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserUsername(BankUser user);
}
