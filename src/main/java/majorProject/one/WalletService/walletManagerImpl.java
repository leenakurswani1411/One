package majorProject.one.WalletService;

import com.fasterxml.jackson.databind.ObjectMapper;
import majorProject.one.UserService.entities.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class walletManagerImpl implements WalletManager{
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    WalletRepository walletRepository;
    @Override
    @KafkaListener()
    public void createWallet(String request) {
        UserResponse userResponse = objectMapper.readValue(request,UserResponse.class);

    }

    @Override
    @KafkaListener()
    public void updateWallet(String walletUpdateRequest) {

    }
}
