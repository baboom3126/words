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
	private UserRepository userrepository;
	
	public void add(UserBo bo) {
		
		UserEntity user = new UserEntity();
		user.setId(bo.getId());
		user.setName(bo.getName());
		userrepository.save(user);
	}
	
	public void save(UserEntity user) {
		userrepository.save(user);
	}
	
	
	public UserBo get(Long id) {
		
		UserEntity user = userrepository.findById(id).orElse(new UserEntity());
		UserBo bo = new UserBo();
		bo.setId(user.getId());
		bo.setName(user.getName());
		
		return bo;
	}
	
	public List<UserEntity> findAll(){
		return userrepository.findAll();
	}
	
}
