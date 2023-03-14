package com.demo_bank_v1.services;

import com.demo_bank_v1.models.PaymentHistory;
import com.demo_bank_v1.repository.PaymentHistoryRepository;
import com.demo_bank_v1.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentHistoryService {

    @Autowired
    private PaymentHistoryRepository paymentHistoryRepository;

    public List<PaymentHistory> getPaymentRecordById(@Param("user_id")int user_id) {
        return paymentHistoryRepository.getPaymentRecordById(user_id);
    }

}
