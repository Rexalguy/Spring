package com.example.tests.Service;

import com.example.tests.Model.Account;
import com.example.tests.Repository.AccountRepository;

import java.math.BigDecimal;

public class TransferService {

    private AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public void transferMoney(int senderId, int receiverId, BigDecimal amount){
        Account sender = accountRepository.findById(senderId)
                .orElseThrow(() -> new RuntimeException("Sender Not Found"));

        Account receiver = accountRepository.findById(receiverId)
                .orElseThrow(() -> new RuntimeException("Receiver Not Found"));

        BigDecimal newSenderAmount = sender.getAmount().subtract(amount);
        BigDecimal newReceiverAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(senderId,newSenderAmount);
        accountRepository.changeAmount(receiverId,newReceiverAmount);
    }
}
