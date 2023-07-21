package com.brillio.model;

import com.brillio.repository.TransactionRepository;
import com.brillio.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.brillio.model.BankUser;
import com.brillio.repository.UserRepository;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final TransactionRepository transactionRepository;
    @Autowired
    public DataLoader(UserRepository userRepository, PasswordEncoder passwordEncoder,TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadUsers();
        loadDummyTransactions();
    }

    private void loadUsers() {
        BankUser user1 = new BankUser();
        user1.setUsername("amit");
        user1.setPassword(passwordEncoder.encode("brillio!2020"));

        BankUser user2 = new BankUser();
        user2.setUsername("ravi");
        user2.setPassword(passwordEncoder.encode("brillio!2021"));

        BankUser user3 = new BankUser();
        user3.setUsername("krishna");
        user3.setPassword(passwordEncoder.encode("brillio!2022"));

        BankUser user4 = new BankUser();
        user4.setUsername("guru");
        user4.setPassword(passwordEncoder.encode("brillio!2023"));
        userRepository.saveAll(List.of(user1, user2, user3, user4));
    }

    private void loadDummyTransactions() {
        // Create dummy transactions
        Transaction transaction1 = new Transaction();

        transaction1.setDescription("Dummy Transaction 1 ");
        transaction1.setAmount(100.0);
        transaction1.setUser(userRepository.findByUsername("amit"));

        Transaction transaction2 = new Transaction();
        transaction2.setDescription("Dummy Transaction 2");
        transaction2.setAmount(200.0);
        transaction1.setUser(userRepository.findByUsername("amit"));


        Transaction transaction3 = new Transaction();
        transaction2.setDescription("Dummy Transaction 3");
        transaction2.setAmount(200.0);
        transaction1.setUser(userRepository.findByUsername("ravi"));


        Transaction transaction4 = new Transaction();
        transaction2.setDescription("Dummy Transaction 4");
        transaction2.setAmount(4200.0);
        transaction1.setUser(userRepository.findByUsername("ravi"));


        Transaction transaction5 = new Transaction();
        transaction2.setDescription("Dummy Transaction 5");
        transaction2.setAmount(34400.0);
        transaction1.setUser(userRepository.findByUsername("krishna"));


        Transaction transaction6 = new Transaction();
        transaction2.setDescription("Dummy Transaction 6");
        transaction2.setAmount(600.0);
        transaction1.setUser(userRepository.findByUsername("krishna"));


        Transaction transaction7 = new Transaction();
        transaction2.setDescription("Dummy Transaction 7");
        transaction2.setAmount(700.0);
        transaction1.setUser(userRepository.findByUsername("guru"));

        Transaction transaction8 = new Transaction();
        transaction2.setDescription("Dummy Transaction 8");
        transaction2.setAmount(800.0);
        transaction1.setUser(userRepository.findByUsername("guru"));


        // Add the transactions to the database
        transactionRepository.saveAll(List.of(transaction1, transaction2,transaction3, transaction4,transaction5, transaction6,transaction7, transaction8));


    }
}
