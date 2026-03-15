package com.klu.main;

import org.hibernate.Session;

import com.klu.entity.Product;
import com.klu.util.HibernateUtil;

public class GetProduct {

public static void main(String[] args) {

Session session = HibernateUtil.getSessionFactory().openSession();

Product p = session.get(Product.class,1);

System.out.println(p.getName());
System.out.println(p.getPrice());

session.close();

}

}