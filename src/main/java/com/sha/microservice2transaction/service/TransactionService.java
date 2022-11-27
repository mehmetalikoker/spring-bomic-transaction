package com.sha.microservice2transaction.service;

import com.sha.microservice2transaction.model.Transaction;
import com.sha.microservice2transaction.repository.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService implements ITransactionService {
    @Autowired
    private ITransactionRepository transationRepository;

    @Override
    public Transaction saveTransaction(Transaction transaction){
        transaction.setTransactionTime(LocalDateTime.now());

        return transationRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Long transactionId){
        transationRepository.deleteById(transactionId);
    }

    @Override
    public List<Transaction> findAllTransaction(Long userId){
        return transationRepository.findAllByUserId(userId);
    }
}
