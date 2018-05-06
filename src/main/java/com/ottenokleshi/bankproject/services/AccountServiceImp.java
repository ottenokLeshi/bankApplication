package com.ottenokleshi.bankproject.services;

import com.ottenokleshi.bankproject.models.entity.Account;
import com.ottenokleshi.bankproject.models.entity.Client;
import com.ottenokleshi.bankproject.models.entity.Transaction;
import com.ottenokleshi.bankproject.models.entity.TransactionType;
import com.ottenokleshi.bankproject.models.repository.AccountRepository;
import com.ottenokleshi.bankproject.models.repository.ClientRepository;
import com.ottenokleshi.bankproject.models.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Service
public class AccountServiceImp implements AccountService{
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    TransactionRepository transactionRepository;

    public void save(Account account) {
        accountRepository.save(account);
    }

    @Transactional
    public void transferTransaction(Transaction transaction, Long clientId) {
        Optional<Account> account = accountRepository.findById(transaction.getAccountId());
        Optional<Account> targetAccount = accountRepository.findById(transaction.getTargetAccountId());
        if (!account.isPresent() || !targetAccount.isPresent()) {
            return;
        }

        Client client = clientRepository.findById(account.get().getClientId()).get();
        Integer balance = account.get().getBalance();
        Integer targetBalance = targetAccount.get().getBalance();

        if (balance < transaction.getSumm() || clientId != account.get().getClientId()) {
            return;
        }
        account.get().setBalance(balance - transaction.getSumm());
        targetAccount.get().setBalance(targetBalance + transaction.getSumm());
        accountRepository.save(account.get());
        accountRepository.save(targetAccount.get());
        transaction.setType(TransactionType.TRANSFER);
        transaction.setTime(new Timestamp(new Date().getTime()));
        transactionRepository.save(transaction);
    }
}
