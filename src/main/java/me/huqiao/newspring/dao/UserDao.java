package me.huqiao.newspring.dao;

import org.springframework.data.repository.CrudRepository;

import me.huqiao.newspring.domain.User;

public interface UserDao extends CrudRepository<User,Long> {

	User findByUsername(String username);
	
}
