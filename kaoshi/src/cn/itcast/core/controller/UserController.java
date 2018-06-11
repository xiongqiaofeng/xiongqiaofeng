package cn.itcast.core.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.core.converter.DateConverter;
import cn.itcast.core.pojo.User;
import cn.itcast.core.service.UserService;

/**
 *用户的登录类
 * @author Administrator
 *
 */
@Controller
public class UserController {
   //注入service
	@Autowired
	private UserService userService;
	
	/**
	 * 添加用户保存导数据库
	 * action="insert.action"
	 * @throws ParseException 
	 */
	@RequestMapping("/insert.action")
	public String lsit(Model model,HttpServletRequest request){
		//model.addAttribute("result", result);
		User user =new  User();
		String name = request.getParameter("name");
		String birthdays = request.getParameter("birthday");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
			// 转换成功直接返回
        	Date birthday =	format.parse(birthdays);
        	user.setBirthday(birthday);
        	user.setName(name);
    		userService.updateUser(user);
    		 

		} catch (Exception e) {
			e.printStackTrace();
		}
        List<User> userList=userService.findAllUser();
        model.addAttribute("userList", userList);
        model.addAttribute("id", user.getId());
        model.addAttribute("name", user.getName());
        model.addAttribute("birthday", user.getBirthday());
        return "forward:/WEB-INF/jsp/list.jsp";
        
		// response.sendRedirect("queryItem.do");
		//href="${pageContext.request.contextPath }/queryItemById.do
       
		
	}
	
	
	@RequestMapping("/toinsert")
	public String toinsert() {
		return "insert";
	}
}
