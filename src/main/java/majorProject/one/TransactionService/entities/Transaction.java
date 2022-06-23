package majorProject.one.TransactionService.entities;

import lombok.*;
import majorProject.one.TransactionService.model.TransactionStatus;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String txId;
    private String fromUser;
    private String toUser;
    private Float amount;
    private TransactionType txType;
    private TransactionStatus transactionStatus;
    @Temporal(value= TemporalType.DATE)
    private Date date;



}
