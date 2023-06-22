package com.example.lifemax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


import java.util.Optional;

@Controller
public class MainRestController {

    @Autowired
    CredentialRepository credentialRepository;


    @GetMapping("/")
    public String getLandingPage(){
        return "landingpage";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam("username")String username,@RequestParam("password")String password){
        Credential credential = new Credential();
        credential.setUsername(username);
        credential.setPassword(password);

        credentialRepository.save(credential);

        return "dashboard";
    }


    @PostMapping("/login")

    public String login(@RequestParam("username")String username,@RequestParam("password")String password, HttpSession session){

        Optional<Credential> credValue=credentialRepository.findById(username);
        if(credValue.isPresent()) {
            if (credValue.get().getPassword().equals(password)) {

                session.setAttribute("username",username);
                return "dashboard";
            }
            else {
                return "landingpage";
            }
        }
        else {
            return "landingpage";
        }
    }
}