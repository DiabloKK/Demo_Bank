package com.demo_bank_v1.services;

import com.demo_bank_v1.models.TransactionHistory;
import com.demo_bank_v1.repository.TransactionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionHistoryService {

    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;

    public List<TransactionHistory> getTransactionRecordById(@Param("user_id")int user_id) {
        return transactionHistoryRepository.getTransactionRecordById(user_id);
    }

}
