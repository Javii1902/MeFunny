package com.mefunny;

import java.sql.Connection;

import javax.servlet.http.HttpSession;

import com.mefunny.controllers.UserController;
import com.mefunny.utils.HibernateSessionFactory;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.staticfiles.Location;

public class Driver {
	public static void main(String[] args) {
		Javalin app = Javalin.create().start(7000);

		app.post("/login", ctx -> {
			ctx.req.getSession();
			//ctx.redirect("/home.html");
		});

		app.get("/logout",ctx -> {
			HttpSession session = ctx.req.getSession(false);
			if(session!=null)
				session.invalidate();
		});
		app.after(ctx -> {
			ctx.res.addHeader("Access-Control-Allow-Origin", "null");
		});

		//app.config.addStaticFiles("/Static", Location.CLASSPATH);

		UserController userController = new UserController(app);
		//MemeController memeController = new MemeController(app);

		System.out.println("done");
	}
}
