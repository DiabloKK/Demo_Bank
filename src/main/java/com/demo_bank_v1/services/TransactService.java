package com.demo_bank_v1.services;

import com.demo_bank_v1.models.Transact;
import com.demo_bank_v1.repository.TransactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactService {

    @Autowired
    private TransactRepository transactRepository;

    public void logTransaction(@Param("account_id")int account_id,
                               @Param("transact_type")String transact_type,
                               @Param("amount")double amount,
                               @Param("source")String source,
                               @Param("status")String status,
                               @Param("reason_code")String reason_code,
                               @Param("create_at")LocalDateTime create_at) {
        Transact transact = new Transact(account_id, transact_type, amount, source, status, reason_code, create_at);
        transactRepository.save(transact);

    }

}
