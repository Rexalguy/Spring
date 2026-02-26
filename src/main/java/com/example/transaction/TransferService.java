package com.example.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {
    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(long senderId, long receiverId, BigDecimal amount){
        //Get the sender and Receiver
        Account sender = accountRepository.findAccountById(senderId);
        Account receiver = accountRepository.findAccountById(receiverId);

        //Withdraw and deposit funds
        BigDecimal newSenderAmount = sender.getBalance().subtract(amount);
        BigDecimal newReceiverAmount = receiver.getBalance().add(amount);

        //Apply changes in the balances
        accountRepository.updateAccountBalance(senderId,newSenderAmount);
        accountRepository.updateAccountBalance(receiverId,newReceiverAmount);

        //Throw an exception to test the transaction management
        throw new RuntimeException("Oh no! Something went wrong 'wink wink' now we have to rollback the transaction");

    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAllAccounts();
    }


}
