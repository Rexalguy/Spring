package com.example.tests;

import com.example.tests.Model.Account;
import com.example.tests.Repository.AccountRepository;
import com.example.tests.Service.TransferService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class TransferServiceUnitTests {
    @Test
    public void moneyTransferHappyFlow(){
        //Create a mock object
        AccountRepository accountRepository = mock(AccountRepository.class);

        //Inject mock into service
        TransferService transferService = new TransferService(accountRepository);

        //Create test accounts
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        Account destination = new Account();
        destination.setId(2);
        destination.setAmount(new BigDecimal(1000));

        //Define the assumptions
        given(accountRepository.findById(sender.getId()))
                .willReturn(Optional.of(sender));

        given(accountRepository.findById(destination.getId()))
                .willReturn(Optional.of(destination));

        //Execution
        transferService.transferMoney(sender.getId(),destination.getId(),new BigDecimal(100));

        //Verify interactions
        verify(accountRepository).changeAmount(1,new BigDecimal(900));
        verify(accountRepository).changeAmount(2,new BigDecimal(1100));
    }
}
