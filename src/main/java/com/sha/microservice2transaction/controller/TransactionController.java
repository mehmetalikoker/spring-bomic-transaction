package com.sha.microservice2transaction.controller;

import com.sha.microservice2transaction.model.Transaction;
import com.sha.microservice2transaction.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/transaction")
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    @PostMapping
    public ResponseEntity<?> saveTransaction(@RequestBody Transaction transaction){
        return new ResponseEntity<>(transactionService.saveTransaction(transaction), HttpStatus.CREATED);
    }

    @DeleteMapping("{transactionId}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long transactionId){
        transactionService.deleteTransaction(transactionId);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("{userId}")
    public ResponseEntity<?> getAllTransaction(@PathVariable Long userId){
        return new ResponseEntity<>(transactionService.findAllTransaction(userId), HttpStatus.OK);
    }

}
