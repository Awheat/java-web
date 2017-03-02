package web.com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import web.com.dao.BaseDAO;
import web.com.dao.usersDAO;
import web.com.entity.users;

public class usersDAOImpl extends BaseDAO implements usersDAO {

	@Override
	public users getUsersById(int id) {
		String sql = "select * from users where id="+id;
		users u = new users();
		try {
			ps = getConn().prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setGender(rs.getInt(3));
				u.setAge(rs.getInt(4));
				u.setAddress(rs.getString(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			closeAll(conn, ps, rs);
		}
		return u;
	}

	@Override
	public List<users> getAllUsers() {
		List<users> list = new ArrayList<users>();
		String sql = "select * from users";
		try {
			ps = getConn().prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				users u = new users(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
				list.add(u);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			closeAll(conn, ps, rs);
		}
		return null;
	}

	@Override
	public List<users> getUsersByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addUser(users user) {
		String sql = "insert into users values(null,?,?,?,?)";
		try {
			ps = getConn().prepareStatement(sql);
			ps.setString(1,user.getName());
			ps.setInt(2,user.getGender());
			ps.setInt(3,user.getAge());
			ps.setString(4,user.getAddress());
			return ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			closeAll(conn, ps, rs);
		}
		return 0;
	}

	@Override
	public int deleteUser(int id) {
		String sql = "delete from users where id = "+id;
		try {
			ps = getConn().prepareStatement(sql);
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			closeAll(conn, ps, rs);
		}
		return 0;
	}

	@Override
	public int updateUser(users user) {
		String sql = "update users set name=?,gender=?,age=?,address=? where id = ?";
		try {
			ps = getConn().prepareStatement(sql);
			ps.setString(1,user.getName());
			ps.setInt(2, user.getGender());
			ps.setInt(3, user.getAge());
			ps.setString(4, user.getAddress());
			ps.setInt(5, user.getId());
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			closeAll(conn, ps, rs);
		}
		return 0;
	}

}
