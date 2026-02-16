package com.example.tests.Repository;

import com.example.tests.Model.Account;

import java.math.BigDecimal;
import java.util.Optional;

public interface AccountRepository {

    Optional<Account> findById(int id);

    void changeAmount(int id, BigDecimal newAmount);
}
