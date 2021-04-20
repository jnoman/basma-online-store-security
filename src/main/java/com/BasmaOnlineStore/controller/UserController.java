package com.BasmaOnlineStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.BasmaOnlineStore.beans.Utilisateur;
import com.BasmaOnlineStore.service.AccountService;

@RepositoryRestController
public class UserController {
	
	@Autowired 
	private AccountService accountService;

	@ResponseBody
	@RequestMapping(path="/utilisateurs", method=RequestMethod.POST)
	public Utilisateur saveUser(@RequestBody Utilisateur user) {
		return accountService.saveUser(user);
	}
}
