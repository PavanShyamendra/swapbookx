package com.swapbookx.api.controllers;

import java.util.List;


import com.swapbookx.api.payloads.ApiResponse;
import com.swapbookx.api.payloads.TransactionDto;
import com.swapbookx.api.payloads.TxReturnDto;
import com.swapbookx.api.services.TransactionService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins="*")
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/")
    public ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto transactionDto) {
        TransactionDto createTransactionDto = this.transactionService.createTransaction(transactionDto);

        return new ResponseEntity<>(createTransactionDto, HttpStatus.CREATED);
    }
    @PutMapping("/{transactionID}")
    public ResponseEntity<TransactionDto> updatetransaction(@RequestBody TransactionDto transactionDto, @PathVariable("transactionID") Integer transactionID)
    {
        TransactionDto updateTransaction = this.transactionService.updateTransaction(transactionDto, transactionID);
        return ResponseEntity.ok(updateTransaction);
    }

    @GetMapping("/lender/{lenderID}")
    public ResponseEntity<List<TxReturnDto>> getTxLender(@PathVariable("lenderID") Integer lenderID){
        return ResponseEntity.ok(this.transactionService.getTxLender(lenderID));
    }

    @GetMapping("/borrower/{borrowerID}")
    public ResponseEntity<List<TxReturnDto>> getTxBorrower(@PathVariable("borrowerID") Integer borrowerID){
        return ResponseEntity.ok(this.transactionService.getTxBorrower(borrowerID));
    }
    //Get
    @GetMapping("/")
    public ResponseEntity<List<TransactionDto>> getAllTransactions(){
        return ResponseEntity.ok(this.transactionService.getAllTransactions());
    }

    //Get - transaction

    @GetMapping("/{transactionID}")
    public ResponseEntity<TransactionDto> getSingletransaction(@PathVariable("transactionID") Integer transactionID){
        return ResponseEntity.ok(this.transactionService.getTransactionByID(transactionID));
    }

}
