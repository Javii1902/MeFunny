package com.mefunny.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;

    public static Session getSession() {
        if(sessionFactory == null) {
            sessionFactory = new Configuration().configure()
                    .setProperty("hibernate.connection.url", System.getenv("db_url"))
                    .setProperty("hibernate.connection.username", System.getenv("db_username"))
                    .setProperty("hibernate.connection.password", System.getenv("db_password"))
                    .buildSessionFactory();
        }
        return sessionFactory.getCurrentSession();
    }
}