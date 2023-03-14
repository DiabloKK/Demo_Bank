package com.demo_bank_v1.repository;

import com.demo_bank_v1.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> getAccountsByUserId(int user_id);

    Account getAccountByUserId(int user_id);

    Account getAccountByAccountId(int account_id);

}
