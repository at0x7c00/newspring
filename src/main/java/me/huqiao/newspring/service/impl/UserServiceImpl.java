package me.huqiao.newspring.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.huqiao.newspring.dao.UserDao;
import me.huqiao.newspring.domain.User;
import me.huqiao.newspring.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public void add(User user) {
		userDao.save(user);
	}

	@Override
	public void delete(Long id) {
		userDao.deleteById(id);
	}

	@Override
	public List<User> getAll() {
		Iterable<User> it = userDao.findAll();
		List<User> res = new ArrayList<User>();
		Iterator<User> iterator =  it.iterator();
		while(iterator.hasNext()) {
			res.add(iterator.next());
		}
		return res;
	}

	@Override
	public User findById(Long id) {
		Optional<User> res = userDao.findById(id);
		return res.isPresent() ? res.get() : null;
	}

	@Override
	public void update(User user) {
		userDao.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
