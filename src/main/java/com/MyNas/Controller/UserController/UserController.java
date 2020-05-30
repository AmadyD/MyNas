/**
 * 
 */
package com.MyNas.Controller.UserController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MyNas.Dao.User.UserDao;
import com.MyNas.Model.User.User;


/**
 * @author Amady
 *
 */
@RestController
@RequestMapping(value = "/crud", method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {
	private static final Logger  logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserDao dao;
	
	@GetMapping(value = "/getUser")
	public User getUser(@RequestParam String login) {
		User user = new User();
		try {
			user = dao.findUserByLogin(login);
		}catch(DataAccessException e) {
			logger.error("Erreur lors de la récupération du user. Problème d'accès à la ressource.");
		}
		
		return user;
	}
	
	@PostMapping(value = "/insertUser")
	public String insertUser(@RequestParam String login,@RequestParam String password) {
		
		User user = new User(login,password);
		try {
			dao.save(user);
			return "OK";
		}catch(DataAccessException e) {
			logger.error("Erreur lors de l'insertion du User "+e.getCause().getMessage());
			return "KO";
		}
	}
	
	@PutMapping(value = "/updateUser")
	public String updateUser(User user) {
		try {
			dao.save(user);
			return "OK";
		} catch (DataAccessException e) {
			logger.error("Erreur lors de la modification du User "+e.getCause().getMessage());
			return "KO";
		}
		
	}
	
	@GetMapping(value = "/verifyCredentials")
	public boolean verifyCredentials(@RequestParam String login, @RequestParam String password) {
		return dao.existsByLoginAndPassword(login, password);
	}
	
	
	@GetMapping(value = "/verifyLogin")
	public boolean verifyLogin(@RequestParam String login) {
		return dao.existsByLogin(login);
	}
	
	@DeleteMapping(value ="/deleteUser")
	public String deleteUser(User user) {
		try {
			dao.delete(user);
			return "OK";
		}catch(DataAccessException e) {
			logger.error("Erreur lors de la suppression du User "+e.getCause().getMessage());
			return "KO";
		}
	}

}
