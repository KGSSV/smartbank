package com.brillio.repository;

import com.brillio.model.BankUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<BankUser, Long> {
    BankUser findByUsername(String username);

    boolean existsByUsername(String user);
}
