package com.BasmaOnlineStore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.BasmaOnlineStore.beans.Utilisateur;

@RepositoryRestResource(exported=true)
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	public Utilisateur findByUsername(String username);
	
}
