package majorProject.one.TransactionService.controller;

import majorProject.one.AuthenticationService.entities.User;
import majorProject.one.TransactionService.manager.TransactionManager;
import majorProject.one.TransactionService.model.TransactionRequest;
import majorProject.one.TransactionService.model.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;

@RestController
public class Controller {

    @Autowired
    private TransactionManager transactionManager;

    @PostMapping("/transaction")
    ResponseEntity create(@RequestBody TransactionRequest transactionRequest, Authentication authentication){
        User fromUser = (User) authentication.getPrincipal();
        return ResponseEntity.ok(transactionManager.create(transactionRequest, fromUser.getUsername()));
    }

    @GetMapping("/transaction/{transactionId}")
    ResponseEntity get(@PathVariable("transactionId") String transactionId){
        try{
            TransactionResponse transactionResponse = transactionManager.get(transactionId);
            return ResponseEntity.ok(transactionResponse);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

//    @PutMapping("/transaction/{transactionId}")
//    ResponseEntity get(@PathVariable("transactionId") String transactionId){
//        try{
//            TransactionResponse transactionResponse = transactionManager.get(transactionId);
//            return ResponseEntity.ok(transactionResponse);
//        }
//        catch (Exception e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//
//    }
//



}
