package com.example.testspringweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

    @Autowired
    CredentialRepository credentialRepository;

    @GetMapping("/")
        public String getLandingPage()
    {
        return "landingpage";
    }
    @PostMapping("/signup")
    public String





    @GetMapping("/save")
    public String saveCredential(){
        Credential cr=new Credential();
        cr.setUsername("Jas");
        cr.setPassword("Jas@123");
        credentialRepository.save(cr);
        return "New Credential Saved";
    }
}
