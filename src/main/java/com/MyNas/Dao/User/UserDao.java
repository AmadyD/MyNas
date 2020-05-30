/**
 * 
 */
package com.MyNas.Dao.User;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.MyNas.Model.User.User;



/**
 * @author Amady
 *
 */
public interface UserDao extends CrudRepository<User, Long> {
	
	public List<User> findAll();

	public User findUserByLogin(String login);
	
	public void deleteByLogin(String login);
	
	public User save(User user);
	
	public boolean existsByLogin(String login);
	
	public boolean existsByLoginAndPassword(String login, String password);
}
