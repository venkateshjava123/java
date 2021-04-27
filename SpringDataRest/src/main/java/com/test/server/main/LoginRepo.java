package com.test.server.main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.test.server.main.model.Login;
@RepositoryRestResource(collectionResourceRel = "logins",path="logins")
public interface LoginRepo extends JpaRepository<Login,Integer> {

}
