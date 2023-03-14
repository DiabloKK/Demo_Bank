package com.demo_bank_v1.services;

import com.demo_bank_v1.models.Payment;
import com.demo_bank_v1.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public void makePayment(@Param("account_id")int account_id,
                            @Param("beneficiary")String beneficiary,
                            @Param("beneficiary_acc_no")String beneficiary_acc_no,
                            @Param("amount")double amount,
                            @Param("reference_no")String reference_no,
                            @Param("status")String status,
                            @Param("reason_code")String reason_code,
                            @Param("created_at")LocalDateTime create_at) {

        Payment payment = new Payment(account_id, beneficiary, beneficiary_acc_no, amount,
                                reference_no, status, reason_code, create_at);

        paymentRepository.save(payment);
    }



}
