package com.patrickeng.words.app.service;

import com.patrickeng.words.app.entity.UserEntity;
import com.patrickeng.words.app.model.UserBo;
import com.patrickeng.words.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void add(UserBo bo) {
		
		UserEntity user = new UserEntity();
		user.setNumber(bo.getNumber());
		user.setName(bo.getName());
		userRepository.save(user);
	}
	
	public void save(UserEntity user) {
		userRepository.save(user);
	}
	
	
	public UserBo get(int number) {
		
		UserEntity user = userRepository.findByNumber(number);
		UserBo bo = new UserBo();
		bo.setUserId(user.getUserId());
		bo.setNumber((user.getNumber()));
		bo.setName(user.getName());
		
		return bo;
	}
	
	public List<UserEntity> findAll(){
		return userRepository.findAll();
	}
	
}
