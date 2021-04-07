package com.BasmaOnlineStore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.BasmaOnlineStore.beans.Utilisateur;
import com.BasmaOnlineStore.repository.UtilisateurRepository;

@SpringBootTest
class BasmaOnlineStoreApplicationTests {
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Test
	void saveUserTest() {
		utilisateurRepository.save(new Utilisateur(null, "mohamed el mehdi", "choukri", "choukri@gmail.com",  "aaaaaaaa",new ArrayList<>()));
		assertThat(utilisateurRepository.findByUsername("choukri@gmail.com")).isNotNull();
	}
	
	@Test
	void updateUserTest() {
		Utilisateur user = utilisateurRepository.findByUsername("choukri@gmail.com");
		if(user!=null) {
			user.setFirstName("mohamed");
			utilisateurRepository.save(user);
			Utilisateur user1 = utilisateurRepository.findByUsername("choukri@gmail.com");
			assertThat("mohamed").isEqualTo(user1.getFirstName());
		}
	}
	
	@Test
	void deleteUserTest() {
		Utilisateur user = utilisateurRepository.findByUsername("choukri@gmail.com");
		if(user!=null) {
			utilisateurRepository.delete(user);
			assertThat(utilisateurRepository.findByUsername("choukri@gmail.com")).isNull();
		}
	}
	
	@Test
	void getAllUserTest() {
		List<Utilisateur> users = utilisateurRepository.findAll();
		assertThat(0).isNotEqualTo(users.size());
	}
	
	

}