package com.mefunny;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mefunny.services.UserService;


public class Driver {
	public static void main(String[] args) {
//		Javalin app = Javalin.create().start(7000);
//
//		app.post("/login", ctx -> {
//			ctx.req.getSession();
//			//ctx.redirect("/home.html");
//		});
//
//		app.get("/logout",ctx -> {
//			HttpSession session = ctx.req.getSession(false);
//			if(session!=null)
//				session.invalidate();
//		});
//		app.after(ctx -> {
//			ctx.res.addHeader("Access-Control-Allow-Origin", "null");
//		});
//
//
//		UserRepository userRepo = new UserRepository();
//		userRepo.editPassword(2, "voitureMEANScarINfrench");
		
ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserService userService = context.getBean("userService", UserService.class);
		
		System.out.println(userService.findAll());
		
	}
}
