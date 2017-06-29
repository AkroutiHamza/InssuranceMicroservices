package com.cat.user.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cat.user.Repository.AssuranceUserRepository;
import com.cat.user.domain.AssuranceUsers;

@RestController
@RequestMapping(value="/User")
public class UserRest {
	
	@Autowired
	private AssuranceUserRepository assuranceUserRepository;

	@RequestMapping(value="/list")
	@ResponseBody
	public Iterable<AssuranceUsers> findAll() {
		return assuranceUserRepository.findAll();
	}

	
	@RequestMapping(value = "/find")
	public AssuranceUsers read(@RequestParam Long user_id){
		AssuranceUsers user =  assuranceUserRepository.findOne(user_id);
		return user;
		
	}
	
	
	@RequestMapping(value = "/save")
	@ResponseBody

	@ResponseStatus(HttpStatus.CREATED)
	public void createUser(@RequestBody AssuranceUsers user){
		assuranceUserRepository.save(new AssuranceUsers(user.getUser_id(),user.getLogin(),user.getPassword(),
				user.getNom(),user.getPrenom(),user.getTel(),user.getDate_naissance(),user.getSexe(),user.getEmail(),
				user.getAssuranceEtatCivil()));
	}
	
	
	 @RequestMapping(value = "/delete")
	public String delete(@RequestParam Long user_id){
		assuranceUserRepository.delete(user_id);
		return "societe #" + user_id + "deleted successfully";
	}
	 
	 
	 
	  @RequestMapping(value = "/update")
		@ResponseBody

		@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateUSer(@RequestParam Long user_id, @RequestBody AssuranceUsers user){
		AssuranceUsers existingUser = assuranceUserRepository.findOne(user_id);
		existingUser.setLogin(user.getLogin());
		existingUser.setPassword(user.getPassword());
		existingUser.setNom(user.getNom());
		existingUser.setPrenom(user.getPrenom());
		existingUser.setTel(user.getTel());
		existingUser.setDate_naissance(user.getDate_naissance());
		existingUser.setSexe(user.getSexe());
		existingUser.setEmail(user.getEmail());
		existingUser.setAssuranceEtatCivil(user.getAssuranceEtatCivil());
		assuranceUserRepository.save(existingUser);
		
		
	}
}
