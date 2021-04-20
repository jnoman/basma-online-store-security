package com.BasmaOnlineStore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.BasmaOnlineStore.beans.Utilisateur;
import com.BasmaOnlineStore.repository.UtilisateurRepository;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@RequestMapping("/")
    public String home(){
        return "Hello World!";
    }
	
	@ResponseBody
	@GetMapping("/profile")
	public Utilisateur getProfile(Authentication authentication) {
		return utilisateurRepository.findByUsername(authentication.getName());
	}
	
	@ResponseBody
	@PutMapping("/profile")
	public String updateProfie(Authentication authentication, @RequestBody Utilisateur user) {
		Utilisateur user1 = utilisateurRepository.findByUsername(authentication.getName());
		if(user1 != null) {
			try {
				user1.setFirstName(user.getFirstName());
				user1.setLastName(user.getLastName());
				user1.setPassword(passwordEncoder.encode(user.getPassword()));
				utilisateurRepository.save(user1);
				return "modification terminer avec succés";
			} catch (Exception e) {
				return "e";
			}
		} else {
			return "utilisateur n'exist pas";
		}
	}
}
