package com.demo_bank_v1.controllers;

import com.demo_bank_v1.models.Account;
import com.demo_bank_v1.models.PaymentHistory;
import com.demo_bank_v1.models.TransactionHistory;
import com.demo_bank_v1.models.User;
import com.demo_bank_v1.services.AccountService;
import com.demo_bank_v1.services.PaymentHistoryService;
import com.demo_bank_v1.services.TransactionHistoryService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/app")
public class AppController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private PaymentHistoryService paymentHistoryService;

    @Autowired
    private TransactionHistoryService transactionHistoryService;

    @GetMapping("/dashboard")
    public ModelAndView getDashBoard(HttpSession session) {
        ModelAndView getDashboardPage = new ModelAndView("dashboard");

        User user = (User) session.getAttribute("user");

        List<Account> getUserAccounts = accountService.getUserAccountsById(user.getUser_id());

        BigDecimal totalAccountsBalance = accountService.getTotalBalance(user.getUser_id());

        for (Account a : getUserAccounts) {
            System.out.println(a);
        }

        getDashboardPage.addObject("userAccounts", getUserAccounts);
        getDashboardPage.addObject("totalBalance", totalAccountsBalance);

        return getDashboardPage;
    }

    @GetMapping("/payment_history")
    public ModelAndView getPaymentHistory(HttpSession session) {

        ModelAndView getPaymentHistoryPage = new ModelAndView("paymentHistory");

        User user = (User) session.getAttribute("user");

        List<PaymentHistory> userPaymentHistory = paymentHistoryService.getPaymentRecordById(user.getUser_id());

        getPaymentHistoryPage.addObject("payment_history", userPaymentHistory);

        return getPaymentHistoryPage;
    }

    @GetMapping("/transaction_history")
    public ModelAndView getTransactionHistory(HttpSession session) {

        ModelAndView getTransactionHistoryPage = new ModelAndView("transactionHistory");

        User user = (User) session.getAttribute("user");

        List<TransactionHistory> userTransactionHistory = transactionHistoryService.getTransactionRecordById(user.getUser_id());

        getTransactionHistoryPage.addObject("transaction_history", userTransactionHistory);

        return getTransactionHistoryPage;
    }

}
