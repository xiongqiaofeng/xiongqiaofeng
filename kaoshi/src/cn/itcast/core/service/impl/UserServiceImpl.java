package cn.itcast.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.core.dao.UserDao;
import cn.itcast.core.pojo.User;
import cn.itcast.core.service.UserService;

/**
 * 新增用户实现类
 * @author Administrator
 *
 */
@Service
public class UserServiceImpl implements UserService{
  //注入dao
	@Autowired
	private UserDao userDao;
	@Override
	public void updateUser(User user) {
		userDao.insertUser(user);
	}
	
	@Override
	public List<User> findAllUser() {
		userDao.findAllUser();
		return null;
	}

	@Override
	public User queryItemById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
 
}
