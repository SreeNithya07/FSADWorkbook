package com.klu.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.klu.entity.Product;
import com.klu.util.HibernateUtil;

public class InsertProduct {

public static void main(String[] args) {

Session session = HibernateUtil.getSessionFactory().openSession();
Transaction tx = session.beginTransaction();

session.save(new Product("Laptop","Electronics",65000,5));
session.save(new Product("Mouse","Electronics",500,20));
session.save(new Product("Keyboard","Electronics",1500,15));

tx.commit();

session.close();

System.out.println("Products Inserted");

}

}