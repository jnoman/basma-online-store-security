package com.BasmaOnlineStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.BasmaOnlineStore.beans.Utilisateur;
import com.BasmaOnlineStore.repository.UtilisateurRepository;
import com.BasmaOnlineStore.service.AccountService;

@RepositoryRestController
public class Controller {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired 
	private AccountService accountService;
	
	@RequestMapping("/")
    public String home(){
        return "Hello World!";
    }
	
	@ResponseBody
	@RequestMapping(path="/utilisateurs", method=RequestMethod.POST)
	public Utilisateur saveUser(@RequestBody Utilisateur user) {
//		Utilisateur user1 = utilisateurRepository.findByUsername(user.getUsername());
//		if(user1 == null) {
//			user.setPassword(passwordEncoder.encode(user.getPassword()));
//			return utilisateurRepository.save(user);
//		} else {
//			return user1;
//		}
		return accountService.saveUser(user);
	}

}
