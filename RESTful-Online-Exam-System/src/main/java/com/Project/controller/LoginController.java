package com.Project.controller;

import javax.servlet.http.HttpSession;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Entity.Answer;
import com.Project.Entity.User;


@RestController
@CrossOrigin("http://localhost:4200")
public class LoginController {
	
	
	@Autowired
	SessionFactory factory ;
	
	static HttpSession httpsession;
	
	@PostMapping("validate")
	public boolean validate(@RequestBody User userFromAngular,HttpServletRequest request)
	{
		
		Session session=factory.openSession();
	
		String usernameFromAngular=userFromAngular.username;
		
		User UserFromDatabase=session.get(User.class,usernameFromAngular);
		
		
		
		if(UserFromDatabase==null)
		{
			return false;
		}
		else
		{
			if(UserFromDatabase.password.equals(userFromAngular.password))
			{
				
				httpsession=request.getSession();
								
				httpsession.setAttribute("score",0);
				
				httpsession.setAttribute("questionIndex",0);
								
				HashMap<Integer,Answer> hashMap=new HashMap<Integer, Answer>();
				
				httpsession.setAttribute("submittedDetails",hashMap);

							
				return true;
			}
			else
			{
				return false;
			}
		}
			
	}
	
	
	
	
	
	
	@PostMapping("saveUser")
	public void saveUser(@RequestBody User user)
	{
		
		Session session=factory.openSession();
		
		
		Transaction tx=session.beginTransaction();
		
			session.save(user);
		
		tx.commit();
		
		
		System.out.println("Data saved");
		
		
	}
}
