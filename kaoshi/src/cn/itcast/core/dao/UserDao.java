package cn.itcast.core.dao;

import cn.itcast.core.pojo.User;

public interface UserDao {
    /**
     * 添加用户
     */
	void insertUser(User user);
	/**
	 * 
	 */

	void findAllUser();
}
