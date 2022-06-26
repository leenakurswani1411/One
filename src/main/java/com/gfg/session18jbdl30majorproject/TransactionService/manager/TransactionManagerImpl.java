package com.gfg.session18jbdl30majorproject.TransactionService.manager;

import com.gfg.session18jbdl30majorproject.TransactionService.entites.Transaction;
import com.gfg.session18jbdl30majorproject.TransactionService.models.TransactionRequest;
import com.gfg.session18jbdl30majorproject.TransactionService.models.TransactionResponse;
import com.gfg.session18jbdl30majorproject.TransactionService.models.TransactionStatus;
import com.gfg.session18jbdl30majorproject.TransactionService.repos.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class TransactionManagerImpl implements TransactionManager{
    @Autowired
    private TransactionRepository transactionRepository;
    @Override
    public String create(TransactionRequest transactionRequest, String username) {
        Transaction transaction = Transaction.builder()
                .amount(transactionRequest.getAmount())
                .date(new Date())
                .fromUser(username)
                .toUser(transactionRequest.getToUser())
                .txType(transactionRequest.getTxType())
                .txId(UUID.randomUUID().toString())
                .status(TransactionStatus.PENDING)
                .build();
        transactionRepository.save(transaction);
        return transaction.getTxId();

    }

    @Override
    public TransactionResponse get(String transactionId) throws Exception {
        Transaction transaction = transactionRepository.findByTxId(transactionId)
                .orElseThrow(()-> new Exception("transaction id not valid"));
        TransactionResponse transactionResponse = TransactionResponse.builder()
                .txId(transaction.getTxId())
                .transactionStatus(transaction.getStatus())
                .build();
        return transactionResponse;
    }

    @Override
    public void updateStatus(String transactionId, TransactionStatus transactionStatus) throws Exception {
        Transaction transaction = transactionRepository.findByTxId(transactionId)
                .orElseThrow(()-> new Exception("transaction id not valid"));
        transaction.setStatus(transactionStatus);
        transactionRepository.save(transaction);
    }
}
