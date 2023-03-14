package com.demo_bank_v1.services;

import com.demo_bank_v1.models.Account;
import com.demo_bank_v1.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    public List<Account> getUserAccountsById(@Param("user_id")int user_id) {
        return accountRepository.getAccountsByUserId(user_id);
    }

    public BigDecimal getTotalBalance(@Param("user_id")int user_id) {
        List<Account> accounts = accountRepository.getAccountsByUserId(user_id);
        if(accounts == null) return BigDecimal.valueOf(0);
        BigDecimal total = BigDecimal.valueOf(0);
        for (Account a : accounts) {
            System.out.println(a);
            total = total.add(a.getBalance());
        }
        return total;
    }

    public void createBankAccount(@Param("user_id")int user_id,
                                  @Param("account_number")String account_number,
                                  @Param("account_name")String account_name,
                                  @Param("account_type")String account_type) {
        Account account = new Account(user_id, account_number, account_name, account_type);
        accountRepository.save(account);
    }

    public double getAccountBalance(@Param("account_id")int account_id) {
        Account account = accountRepository.getAccountByAccountId(account_id);

        if(account != null) {
            return Double.parseDouble(account.getBalance().toString());
        }

        return 0;
    }

    public void changeAccountBalanceById(@Param("new_balance")double balance, @Param("account_id")int account_id) {
        Account account = accountRepository.getAccountByAccountId(account_id);
        if(account != null) {
            account.setBalance(BigDecimal.valueOf(balance));
        }
        accountRepository.save(account);
    }

}
