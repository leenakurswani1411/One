package majorProject.one.TransactionService.model;

import lombok.*;
import majorProject.one.TransactionService.entities.TransactionType;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
    private String txId;
    private TransactionStatus txStatus;
}
