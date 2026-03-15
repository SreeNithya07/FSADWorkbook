package com.klu.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.klu.entity.Product;
import com.klu.util.HibernateUtil;

public class DeleteProduct {

public static void main(String[] args) {

Session session = HibernateUtil.getSessionFactory().openSession();
Transaction tx = session.beginTransaction();

Product p = session.get(Product.class,1);

session.delete(p);

tx.commit();

session.close();

System.out.println("Product Deleted");

}

}