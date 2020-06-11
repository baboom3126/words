package com.patrickeng.words.app.controller;

import com.patrickeng.words.app.entity.UserEntity;
import com.patrickeng.words.app.model.UserBo;
import com.patrickeng.words.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/user")
public class UserController {


	@Autowired
	private UserService userService;

	@RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value ="/{number}/{name}")
	@ResponseBody
	public ResponseEntity<?> setUser(HttpServletRequest request,
                                     HttpServletResponse response, @PathVariable String number, @PathVariable String name) {

		System.out.println("number"+number+"name"+name);
		int intNumber = Integer.parseInt(number);

		UserBo userbo = new UserBo();
		userbo.setNumber(intNumber);
		userbo.setName(name);
		userService.add(userbo);
		
		
		try {
			UserBo QueryUserBo = userService.get(intNumber);
		
			return new ResponseEntity<>(QueryUserBo, HttpStatus.OK);
		}
		catch(Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value="/all")
	@ResponseBody
	public ResponseEntity<?> getAllUser(HttpServletRequest request,
                                        HttpServletResponse response){
		
		List<UserEntity> userlist = userService.findAll();
		
		
		return new ResponseEntity<>(userlist, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST,value="/new")
	@ResponseBody
	public ResponseEntity<?> setNewUserByName(HttpServletRequest request,
                                              HttpServletResponse response, @RequestBody UserEntity userEntity){
		String userId = userEntity.getUserId();
		String name = userEntity.getName();
		int number = userEntity.getNumber();
		//////
		
		
		return null;
		
	}
	
	@RequestMapping(value="/list")
	public String userlistPage() {
		return "userlist";
	}
	
	@RequestMapping(value="/new")
	public String usernewPage() {
		return "usernew";
	}

}
