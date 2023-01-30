package com.ecommerce.demo;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.demo.DAO.BankDAO;
import com.ecommerce.demo.DAO.ShoeDAO;
import com.ecommerce.demo.DAO.UserDAO;
import com.ecommerce.demo.POJO.ShoeData;
import com.ecommerce.demo.POJO.UserData;

@Controller
public class MainController {
@Autowired
	ShoeDAO sdao;
@Autowired
    UserDAO udao;
@Autowired
BankDAO bdao;

Logger log=Logger.getAnonymousLogger();


@RequestMapping("/")
public ModelAndView displaypage(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv=new ModelAndView();
	mv.setViewName("websitepage.jsp");
	return mv;
}


@RequestMapping("/adminlogin")
public ModelAndView adminloginpage(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv=new ModelAndView();
	String msg="Welcome Admin ";
	mv.addObject("msg",msg);
	mv.setViewName("adminhomepage.jsp");
	return mv;
}


@RequestMapping("/insertshoe")
public ModelAndView shoeinsertControl(HttpServletRequest request,HttpServletResponse response) {
	log.info("Entered into the insert method");
	ModelAndView mv=new ModelAndView();
	ShoeData s=new ShoeData();
	s.setShoeName(request.getParameter("shoeName"));
	s.setShoePrice(request.getParameter("shoePrice"));
	ShoeData sd=sdao.insert(s);
	if(sd!=null) {
		mv.setViewName("success.jsp");
	}
	return mv;
}

@RequestMapping("/editshoe")
public ModelAndView shoeupdateControl(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv=new ModelAndView();
	ShoeData s=new ShoeData();
	s.setShoeId(Integer.parseInt(request.getParameter("shoeId")));
	s.setShoeName(request.getParameter("shoeName"));
	s.setShoePrice(request.getParameter("shoePrice"));
	ShoeData sd=sdao.updateshoe(s);
	if(sd!=null) {
		mv.setViewName("success.jsp");
	}
	return mv;
}

@RequestMapping("/deleteshoe")
public ModelAndView shoedeleteControl(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv=new ModelAndView();
	ShoeData s=new ShoeData();
	s.setShoeId(Integer.parseInt(request.getParameter("shoeId")));
     sdao.delete(s);
	mv.setViewName("success.jsp");
	return mv;
}

@RequestMapping("/shoelist")
public ModelAndView displayAll(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv=new ModelAndView();
List<ShoeData> list=sdao.getall();
mv.setViewName("shoelist.jsp");
mv.addObject("list",list);	
	return mv;
}

@RequestMapping("/searchshoe")
public ModelAndView search (HttpServletRequest request,HttpServletResponse response,@Param("keyword")String keyword) {
	log.info("Entered into the search method");
	ModelAndView mv=new ModelAndView();
	List<ShoeData> listAll=sdao.listAll(keyword);
	mv.setViewName("shoelist.jsp");
	mv.addObject("list",listAll);	
		return mv;
	
}


@RequestMapping("/insertuser")
public ModelAndView userinsertControl(HttpServletRequest request,HttpServletResponse response) {
	log.info("Entered into the insert method");
	ModelAndView mv=new ModelAndView();
	UserData u=new UserData();
	u.setName(request.getParameter("name"));
	u.setEmail(request.getParameter("email"));
	u.setPhono(request.getParameter("phono"));
	u.setUsername(request.getParameter("username"));
	u.setPassword(request.getParameter("password"));
	UserData ud=udao.insertuser(u);
	if(ud!=null) {
		mv.setViewName("success.jsp");
	}
	return mv;
}

@RequestMapping("/userlist")
public ModelAndView displayAlluser(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv=new ModelAndView();
	List<UserData> list=udao.getalluser();
mv.setViewName("userlist.jsp");
mv.addObject("list",list);	
	return mv;
}

@RequestMapping("/searchuser")
public ModelAndView searchuser (HttpServletRequest request,HttpServletResponse response,@Param("keyword")String keyword) {
	log.info("Entered into the search method");
	ModelAndView mv=new ModelAndView();
	List<UserData> listAll=udao.listAlluser(keyword);
	mv.setViewName("userlist.jsp");
	mv.addObject("list",listAll);	
		return mv;
	
}
@RequestMapping("/edituser")
public ModelAndView userupdateControl(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv=new ModelAndView();
	UserData u=new UserData();
	u.setId(Integer.parseInt(request.getParameter("id")));
	u.setName(request.getParameter("name"));
	u.setEmail(request.getParameter("email"));
	u.setPhono(request.getParameter("phono"));
	u.setUsername(request.getParameter("username"));
	u.setPassword(request.getParameter("password"));
	UserData ud=udao.updateuser(u);
	if(ud!=null) {
		mv.setViewName("success.jsp");
	}
	return mv;
}

@RequestMapping("/deleteuser")
public ModelAndView userdeleteControl(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv=new ModelAndView();
	UserData u=new UserData();
	u.setId(Integer.parseInt(request.getParameter("id")));
     udao.deleteuser(u);
	mv.setViewName("success.jsp");
	return mv;
}

@RequestMapping("/userlogin")
public ModelAndView userloginpage(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv=new ModelAndView();
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	UserData ud=udao.findByuserpwd(username, password);
	if(ud!=null) {
		String msg="Welcome "+username;
		mv.addObject("msg",msg);
		mv.setViewName("displaypageuser.jsp");		
	}
	else {
		mv.setViewName("fail.jsp");
	}
	return mv;

}

@RequestMapping("/registeruser")
public ModelAndView registeruserpage(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv=new ModelAndView();
	String email=request.getParameter("email");
	boolean b =udao.checkEmail(email);
	if(b){
		String msg="Email already Exists";
	mv.setViewName("registeruser1.jsp");
	mv.addObject("msg",msg);
		
	}
	else {
		UserData u=new UserData();
		u.setName(request.getParameter("name"));
		u.setEmail(request.getParameter("email"));
		u.setPhono(request.getParameter("phono"));
		u.setUsername(request.getParameter("username"));
		u.setPassword(request.getParameter("password"));
		UserData ud=udao.insertuser(u);
		if(ud!=null) {
			String msg="Registered Successfully";
			String name=u.getName();
			mv.addObject("name",name);
			mv.setViewName("userlogin1.jsp");
			mv.addObject("msg",msg);	
		}
		}
	
	return mv;
}


@RequestMapping("/usershoelist")
public ModelAndView usershoelistpage(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv=new ModelAndView();
	List<ShoeData> list=sdao.getall();
	mv.setViewName("usershoelist.jsp");
	mv.addObject("list",list);	
		return mv;

}

@RequestMapping("/buyshoe")
public ModelAndView butshoepage(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv=new ModelAndView();
	String shoeprice=request.getParameter("shoePrice");
	int shprice=Integer.parseInt(shoeprice);
	String bname=request.getParameter("bname");
	Long bal=bdao.getBal(bname);
	
	if(bal>=shprice) {
		mv.setViewName("paysuccess.jsp");
	}
	else {
		mv.setViewName("payfail.jsp");
	}
	
		return mv;
		
		
}



}






