package cn.itcast.core.service;

import java.util.List;

import cn.itcast.core.pojo.User;

public interface UserService {
    /**
     * 添加用户
     * @param user
     */
	void updateUser(User user);

	User queryItemById(Integer id);

	List<User> findAllUser();

}
