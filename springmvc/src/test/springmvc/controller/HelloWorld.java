package test.springmvc.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.URLCodec;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import test.utils.MD5_Util;
import test.utils.VerifyCodeUtils;

@Controller
@RequestMapping("/mvc")
public class HelloWorld {
	
	@RequestMapping("/hello")
	public String hello(HttpServletRequest request){
		
		 String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
		 HttpSession session = request.getSession(true); 
		 session.setAttribute("salt", verifyCode.toLowerCase());
		
		return "hello";
	}
	
	@RequestMapping("/image")
	public void image(HttpServletRequest request, HttpServletResponse response){
		
		response.setHeader("Pragma", "No-cache"); 
        response.setHeader("Cache-Control", "no-cache"); 
        response.setDateHeader("Expires", 0); 
        response.setContentType("image/jpeg"); 
           
        //生成随机字串 
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4); 
        
        System.out.println(verifyCode);
        
        //存入会话session 
        HttpSession session = request.getSession(true); 
        //删除以前的
        session.removeAttribute("verCode");
        session.setAttribute("verCode", verifyCode.toLowerCase()); 
        
        //生成图片 
        int w = 100, h = 30; 
        try {
			VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}
	
	@RequestMapping("/login")
	public String login(String username,String password,String verificationCode,HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session = request.getSession(true); 
		
		String verCode=(String) session.getAttribute("salt");
		
		String v_psw=MD5_Util.MD5(MD5_Util.MD5(username+MD5_Util.MD5("luke"))+verCode);
		
		System.out.println("校验结果："+v_psw.equals(password));
		
		System.out.println("this-----用户名："+username+"---唯一码："+verCode+"----MD5码："+v_psw);
		
//		System.out.println("login------"+username+"---"+password+"----"+verificationCode);
		
		return "hello2";
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException, DecoderException {
		System.out.println(URLCodec.decodeUrl("+".getBytes()));
	}

}
