package com.prolim.EndProjectP3;

import org.springframework.beans.factory.annotation.Autowired;

public class InitiateProgram {
	@Autowired
	private UserRepo userRepo;
	
	public InitiateProgram() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void startUser() {
		User u1= new User(1,"harsh");
		User u2= new User(2,"Arnav");
		User u3= new User(3,"Bhawan");
		User u4= new User(4,"Karjee");
		User u5= new User(1,"Kartikeya");
		userRepo.save(u1);
		userRepo.save(u2);
		userRepo.save(u3);
		userRepo.save(u4);
		userRepo.save(u5);
	}
	
}
