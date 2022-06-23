package majorProject.one.TransactionService.repo;

import majorProject.one.TransactionService.entities.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface TransactionRepository extends CrudRepository<Transaction,Long> {

    Optional<Transaction> findByTxId(String txId);
}
