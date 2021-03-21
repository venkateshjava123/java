package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.LoginRepo;

@RestController
public class LoginCotroller {
   @Autowired
   LoginRepo repo;
	@RequestMapping("/")
	public String home() {
		return "home.jsp"; 
	}
  @PostMapping(path="/Login",consumes= {"Application/json"})
   public Login addLogin(@RequestBody Login login) {
	  repo.save(login);
	  return login;
  }
  @DeleteMapping("/Login/{id}")
  public String deleteLogin(@PathVariable int id) {
	  Login a=repo.getOne(id);
	  repo.delete(a);
	  return "deleted";
 }
  @GetMapping("/Logins")

  public List<Login> getLogins() {
	  
	 return repo.findAll();
  }
  @PutMapping(path="/Login",consumes= {"Application/json"})
  public Login saveOrUpdateLogin(@RequestBody Login login) {
	  repo.save(login);
	  return login;
 }
  @RequestMapping("/Login/{id}")
  @ResponseBody
  public Optional<Login> getLogin(@PathVariable("id") int id) {
	  
	 return repo.findById(id);
  }
}



