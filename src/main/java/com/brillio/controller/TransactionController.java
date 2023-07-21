package com.brillio.controller;

import com.brillio.model.BankUser;
import com.brillio.model.Transaction;

import com.brillio.repository.TransactionRepository;
import com.brillio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class TransactionController {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;

    @Autowired
    public TransactionController(TransactionRepository transactionRepository, UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/transactions")
    public ResponseEntity<List<Transaction>> showTransactions(Model model) {
        // Get the currently logged-in user's username
        List<Transaction> transactions = new ArrayList<>();
        try {
        String loggedInUsername = getLoggedInUsername();

        // Fetch transactions for the logged-in
        BankUser user = userRepository.findByUsername(loggedInUsername);

        transactions  = transactionRepository.findByUserUsername(user);

        // Add the transaction details to the model to be displayed in the view
      //  model.addAttribute("transactions", transactions);
        } catch (Exception e) {
            // Handle any exceptions that occur during the request processing
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok(transactions);
    }

    // Helper method to get the username of the currently logged-in user
    private String getLoggedInUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else {
            return principal.toString();
        }
    }
}

