package majorProject.one.TransactionService.model;

import lombok.*;
import majorProject.one.TransactionService.entities.TransactionType;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
    private String toUser;
    private Float amount;
    private TransactionType txType;
}
