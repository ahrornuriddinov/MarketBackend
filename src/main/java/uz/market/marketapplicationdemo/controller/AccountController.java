package uz.market.marketapplicationdemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.market.marketapplicationdemo.config.utilsSecurity.SecurityUtils;
import uz.market.marketapplicationdemo.entity.User;
import uz.market.marketapplicationdemo.repository.UserRepository;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountController {

    private final UserRepository userRepository;

    @GetMapping("/account")
    public ResponseEntity<?> getAccount(){
        String username = SecurityUtils.getCurrentUsername().get();
        User byEmail = userRepository.findByEmail(username).get();
        return ResponseEntity.ok(byEmail);
    }
}
