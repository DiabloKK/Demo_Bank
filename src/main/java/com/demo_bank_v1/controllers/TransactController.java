package com.demo_bank_v1.controllers;

import com.demo_bank_v1.models.User;
import com.demo_bank_v1.repository.TransactRepository;
import com.demo_bank_v1.services.AccountService;
import com.demo_bank_v1.services.PaymentService;
import com.demo_bank_v1.services.TransactService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/transact")
public class TransactController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private TransactService transactService;

    User user;
    double currentBalance;
    double newBalance;

    @PostMapping("/deposit")
    public String deposit(@RequestParam("deposit_amount")String depositAmount,
                          @RequestParam("account_id")String accountID,
                          HttpSession session,
                          RedirectAttributes redirectAttributes) {


        // TODO: CHECK FOR EMPTY STRINGS
        if(depositAmount.isEmpty() || accountID.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Deposit Amount or Account Depositing to Cannot Be Empty");
            return "redirect:/app/dashboard";
        }

        // TODO: GET LOGGED IN USER
        user = (User) session.getAttribute("user");

        // TODO: GET CURRENT ACCOUNT BALANCE
        int acc_id = Integer.parseInt(accountID);

        double depositAmountValue = Double.parseDouble(depositAmount);

        currentBalance = accountService.getAccountBalance(acc_id);

        // TODO: CHECK IF DEPOSIT AMOUNT IS 0(ZEROS)
        if(depositAmountValue == 0) {
            redirectAttributes.addFlashAttribute("error", "Deposit Amount Cannot be of 0(zeros) Value");
            return "redirect:/app/dashboard";
        }

        // TODO: UPDATE BALANCE
        double newBalance = currentBalance + depositAmountValue;

        accountService.changeAccountBalanceById(newBalance, acc_id);

        transactService.logTransaction(acc_id, "deposit", depositAmountValue, "online",
                "success", "Deposit Transaction Successful", LocalDateTime.now());

        redirectAttributes.addFlashAttribute("success", "Amount Deposited Successfully");
        return "redirect:/app/dashboard";
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam("transfer_from")String transfer_from,
                           @RequestParam("transfer_to")String transfer_to,
                           @RequestParam("transfer_amount")String transfer_amount,
                           HttpSession session,
                           RedirectAttributes redirectAttributes) {

        String errorMessage;
        // TODO: CHECK FOR EMPTY FIELDS
        if(transfer_amount.isEmpty() || transfer_from.isEmpty() || transfer_to.isEmpty()) {
            errorMessage = "The account transferring from and to along with the amount cannot be empty!";
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/app/dashboard";
        }

        // TODO: CONVERT VARIABLES
        int transferFromId = Integer.parseInt(transfer_from);
        int transferToId = Integer.parseInt(transfer_to);
        double transferAmount = Double.parseDouble(transfer_amount);

        // TODO: CHECK IF TRANSFERRING
        if(transferFromId == transferToId) {
            errorMessage = "Cannot Transfer Into The same Account, Please select the appropriate account to perform transfer";
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/app/dashboard";
        }

        // TODO: CHECK FOR 0 (ZEROS) VALUES
        if(transferAmount == 0) {
            errorMessage = "Cannot Transfer an amount of 0 (Zero) value, please enter a value greater than 0 (Zero)";
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/app/dashboard";
        }

        // TODO: GET LOGGED IN USER
        user = (User) session.getAttribute("user");

        // TODO: GET CURRENT BALANCE
        double currentBalanceOfAccountTransferringFrom = accountService.getAccountBalance(transferFromId);
        double currentBalanceOfAccountTransferringTo = accountService.getAccountBalance(transferToId);

        // TODO: CHECK CURRENT BALANCE GREATER THAN TRANSFER AMOUNT
        if(currentBalanceOfAccountTransferringFrom < transferAmount) {
            errorMessage = "The amount in the account is not enough";
            transactService.logTransaction(transferFromId, "transfer", transferAmount, "online",
                    "failed", "Insufficient Funds", LocalDateTime.now());
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/app/dashboard";
        }

        // TODO: SET NEW BALANCE
        double newBalanceOfAccountTransferringFrom = currentBalanceOfAccountTransferringFrom - transferAmount;

        double newBalanceOfAccountTransferringTo = currentBalanceOfAccountTransferringTo + transferAmount;


        accountService.changeAccountBalanceById(newBalanceOfAccountTransferringFrom, transferFromId);

        accountService.changeAccountBalanceById(newBalanceOfAccountTransferringTo, transferToId);

        transactService.logTransaction(transferFromId, "Transfer", transferAmount, "online",
                "success", "Transfer Transaction Successful", LocalDateTime.now());

        String successMessage = "Amount Transferred Successfully!";
        redirectAttributes.addFlashAttribute("success", successMessage);
        return "redirect:/app/dashboard";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam("withdraw_amount")String withdrawalAmount,
                           @RequestParam("account_id")String accountID,
                           HttpSession session,
                           RedirectAttributes redirectAttributes) {

        String errorMessage;
        String successMessage;
        // TODO: CHECK FOR EMPTY VALUES
        if(withdrawalAmount.isEmpty() || accountID.isEmpty()) {
            errorMessage = "Withdrawal Amount and Account Withdrawing From Cannot be Empty!";
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/app/dashboard";
        }

        // TODO: COVERT VARIABLES
        double withdrawal_amount = Double.parseDouble(withdrawalAmount);
        int account_id = Integer.parseInt(accountID);

        // TODO: CHECK FOR 0 (ZEROS) VALUES
        if (withdrawal_amount == 0) {
            errorMessage = "Withdrawal Amount Cannot be of 0 (Zero) value, please enter a value greater than 0 (Zero)!";
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/app/dashboard";
        }

//        // TODO: GETLOGGED IN USER
//        user = (User) session.getAttribute("user");

        // TODO: GET CURRENT BALANCE
        currentBalance = accountService.getAccountBalance(account_id);

        // TODO: CHECK CURRENT BALANCE GREATER THAN WITHDRAWAL AMOUNT
        if(currentBalance < withdrawal_amount) {
            errorMessage = "The amount in the account is not enough";
            transactService.logTransaction(account_id, "Withdrawal", withdrawal_amount, "online",
                    "failed", "Insufficient Funds", LocalDateTime.now());
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/app/dashboard";
        }

        // TODO: SET NEW BALANCE
        newBalance = currentBalance - withdrawal_amount;

        // TODO: UPDATE ACCOUNT BALANCE
        accountService.changeAccountBalanceById(newBalance, account_id);

        transactService.logTransaction(account_id, "Withdrawal", withdrawal_amount, "online",
                "success", "Withdrawal Transaction Successful", LocalDateTime.now());
        successMessage = "Withdrawal Successfully!";
        redirectAttributes.addFlashAttribute("success", successMessage);
        return "redirect:/app/dashboard";
    }

    @PostMapping("/payment")
    public String payment(@RequestParam("beneficiary")String beneficiary,
                          @RequestParam("account_number")String account_number,
                          @RequestParam("account_id")String account_id,
                          @RequestParam("reference")String reference,
                          @RequestParam("payment_amount")String payment_amount,
                          HttpSession session,
                          RedirectAttributes redirectAttributes) {

        String errorMessage;
        String successMessage;

        // TODO: CHECK FOR EMPTY VALUES
        if(beneficiary.isEmpty() || account_number.isEmpty() || account_id.isEmpty() || payment_amount.isEmpty()) {
            errorMessage = "Beneficiary, Account Number, Account Paying From and Payment Amount Cannot be Empty!";
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/app/dashboard";
        }

        // TODO: CONVERT VARIABLES
        int accountID = Integer.parseInt(account_id);
        double paymentAmount = Double.parseDouble(payment_amount);


        // TODO: CHECK FOR 0 (ZEROS) VALUES
        if(paymentAmount == 0) {
            errorMessage = "Payment Amount Cannot be of 0 (Zero) value, please enter a value greater than 0 (Zero)";
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/app/dashboard";
        }

//        // TODO: GET LOGGED IN USER
//        user = (User) session.getAttribute("user");

        // TODO: GET CURRENT BALANCE
        currentBalance = accountService.getAccountBalance(accountID);

        // TODO: CHECK IF PAYMENT AMOUNT IS MORE THAN CURRENT BALANCE
        if(currentBalance < paymentAmount) {
            errorMessage = "You have insufficient Funds to perform this payment";
            String reasonCode = "Could not Processed Payment due to insufficient funds";
            transactService.logTransaction(accountID, "Payment", paymentAmount, "online",
                    "failed", reasonCode, LocalDateTime.now());
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/app/dashboard";
        }

        // TODO: SET NEW BALANCE FOR ACCOUNT PAYING FORM
        newBalance = currentBalance - paymentAmount;

        // TODO: MAKE PAYMENT
        String reasonCode = "Payment Processed Successfully!";
        LocalDateTime currentDateTime = LocalDateTime.now();
        paymentService.makePayment(accountID, beneficiary, account_number, paymentAmount, reference, "success", reasonCode, currentDateTime);

        // TODO: UPDATE ACCOUNT PAYING FORM
        accountService.changeAccountBalanceById(newBalance, accountID);

        transactService.logTransaction(accountID, "Payment", paymentAmount, "online",
                "success", "Payment Transaction Successful", LocalDateTime.now());
        successMessage = reasonCode;
        redirectAttributes.addFlashAttribute("success", successMessage);
        return "redirect:/app/dashboard";

    }


}
