package com.training.springmvc.controllar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.springmvc.controllar.dao.UserDao;
import com.training.springmvc.controllar.dao.UserDaoImpl;
import com.training.springmvc.controllar.model.User;
import com.training.springmvc.service.LoginService;
import com.training.springmvc.service.LoginServiceImpl;
import com.training.springmvc.service.RegisterServiceImpl;


@Controller
@RequestMapping("/")//controller
public class HomeController {
	@Autowired
	LoginService service;
	@Autowired
	UserDao dao;
	@Autowired
	RegisterServiceImpl lService;
	
//	@RequestMapping(value="/home",method= RequestMethod.GET)
//	public String printGreet(ModelMap map,HttpServletRequest req) {
//		String user1=req.getParameter("user");
//		map.addAttribute("msg","this is from model map");
//		if(user1.equals("abc")) {
//			return "success";
//		}
//		else {
//			map.addAttribute("msg","Please enter correct username");
//			return "home";
//		}
//		
//		//return "home";//view name
//	}
	
	
	@RequestMapping(value="/home",method= RequestMethod.GET)
	public String printGreet(ModelMap map,@ModelAttribute("user") User user) {
//		String user1=req.getParameter("user");
		map.addAttribute("msg","this is from model map");
		
//		User userr=(User) dao.getUsers();
//		LoginService service = new LoginServiceImpl();
		
		
		if(service.isValidUser_det(user.getUsername(), user.getPassword())) {
//			UserDao dao=new UserDaoImpl() ;
			List<User> userList1 = dao.getUsers();
			return "success";
//			rd.include(request, response);
//			chain.doFilter(request, response);

		}
		
//		if(user.getUsername().equals(userr.getUsername()) && user.getPassword().equals(userr.getPassword())) {
//			return "success";
//		}
		else {
			map.addAttribute("msg","Please enter correct username");
			return "home";
		}
		
		//return "home";//view name
	}
	
	
	@RequestMapping(value="/register",method= RequestMethod.GET)
	public String register(ModelMap map,@ModelAttribute("user") User user1) {
//		String user1=req.getParameter("user");
		map.addAttribute("msg","this is from model map");
	
		String userN=user1.getUsername();
		String pasw=user1.getPassword();
		if(lService.isUser_Registered(user1.getUsername(), user1.getPassword())) {
//			UserDao dao=new UserDaoImpl() ;
			List<User> userList1 = dao.getUsers();
			map.addAttribute("msg","Successfully Registered");
			return "index";
//			rd.include(request, response);
//			chain.doFilter(request, response);

		}
		else {
			return "home";
		}
        
		
		
		//return "home";//view name
	}
	@RequestMapping(method= RequestMethod.GET)
	public String openMainPage() {
		//System.out.print("hello");
		return "index";
	}

}
