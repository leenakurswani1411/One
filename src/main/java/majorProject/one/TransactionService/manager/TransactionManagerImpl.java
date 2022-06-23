package majorProject.one.TransactionService.manager;

import majorProject.one.TransactionService.entities.Transaction;
import majorProject.one.TransactionService.model.TransactionRequest;
import majorProject.one.TransactionService.model.TransactionResponse;
import majorProject.one.TransactionService.model.TransactionStatus;
import majorProject.one.TransactionService.repo.TransactionRepository;
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
                .toUser(transactionRequest.getToUser())
                .txType(transactionRequest.getTxType())
                .txId(UUID.randomUUID().toString())
                .transactionStatus(TransactionStatus.PENDING)
                .build();

        transactionRepository.save(transaction);

        return transaction.getTxId();
    }

    @Override
    public TransactionResponse get(String transactionId) throws Exception {
        Transaction transaction = transactionRepository.findByTxId(transactionId)
                .orElseThrow(() -> new Exception("Can't find the transaction"));

        TransactionResponse transactionResponse = TransactionResponse.builder()
                .txId(transaction.getTxId())
                .txStatus(transaction.getTransactionStatus())
                .build();
        return transactionResponse;
    }

    @Override
    public void updateStatus(String transactionIId, TransactionStatus transactionStatus) throws Exception {
        Transaction transaction = transactionRepository.findByTxId(transactionIId)
                .orElseThrow(() -> new Exception("Can't find the transaction"));

        transaction.setTransactionStatus(transactionStatus);

        transactionRepository.save(transaction);

    }
}
