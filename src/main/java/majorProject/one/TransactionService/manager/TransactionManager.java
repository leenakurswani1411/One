package majorProject.one.TransactionService.manager;

import majorProject.one.TransactionService.model.TransactionRequest;
import majorProject.one.TransactionService.model.TransactionResponse;
import majorProject.one.TransactionService.model.TransactionStatus;

public interface TransactionManager {

    String create(TransactionRequest transactionRequest, String username);
    TransactionResponse get(String transactionId) throws Exception;
    void updateStatus(String transactionIId, TransactionStatus transactionStatus) throws Exception;
}
