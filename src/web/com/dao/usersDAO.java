package web.com.dao;

import java.util.List;

import web.com.entity.users;

// 接口 
public interface  usersDAO {
	
	public users getUsersById(int id);
	
	public List<users> getAllUsers();
	
	public List<users> getUsersByName();
	
	public int addUser(users user);
	
	public int deleteUser(int id);
	
	public int updateUser(users user);
	
}
