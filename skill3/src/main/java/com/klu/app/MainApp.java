package com.klu.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.klu.entity.Product;
import com.klu.util.HibernateUtil;

public class MainApp {

    public static void main(String[] args) {

        insertProducts();
        sortByPriceAsc();
        sortByPriceDesc();
        sortByQuantityDesc();
        pagination();
        aggregateQueries();
        groupByDescription();
        filterByPriceRange();
        likeQueries();

        HibernateUtil.getSessionFactory().close();
    }

    // Insert 5–8 products
    static void insertProducts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(new Product("Laptop", "Electronics", 70000, 5));
        session.persist(new Product("Mobile", "Electronics", 30000, 10));
        session.persist(new Product("Tablet", "Electronics", 25000, 7));
        session.persist(new Product("Mouse", "Accessories", 800, 50));
        session.persist(new Product("Keyboard", "Accessories", 1500, 30));
        session.persist(new Product("Monitor", "Electronics", 12000, 12));
        session.persist(new Product("Printer", "Electronics", 18000, 4));

        tx.commit();
        session.close();
    }

    // Sort by price ascending
    static void sortByPriceAsc() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> q =
                session.createQuery("from Product order by price asc", Product.class);

        q.list().forEach(p ->
                System.out.println(p.getName() + " : " + p.getPrice()));

        session.close();
    }

    // Sort by price descending
    static void sortByPriceDesc() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> q =
                session.createQuery("from Product order by price desc", Product.class);

        q.list().forEach(p ->
                System.out.println(p.getName() + " : " + p.getPrice()));

        session.close();
    }

    // Sort by quantity (highest first)
    static void sortByQuantityDesc() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> q =
                session.createQuery("from Product order by quantity desc", Product.class);

        q.list().forEach(p ->
                System.out.println(p.getName() + " : " + p.getQuantity()));

        session.close();
    }

    // Pagination
    static void pagination() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> q = session.createQuery("from Product", Product.class);

        q.setFirstResult(0);
        q.setMaxResults(3);
        System.out.println("First 3 Products:");
        q.list().forEach(p -> System.out.println(p.getName()));

        q.setFirstResult(3);
        q.setMaxResults(3);
        System.out.println("Next 3 Products:");
        q.list().forEach(p -> System.out.println(p.getName()));

        session.close();
    }

    // Aggregate queries
    static void aggregateQueries() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Long total = session.createQuery(
                "select count(*) from Product", Long.class).uniqueResult();

        Long available = session.createQuery(
                "select count(*) from Product where quantity > 0", Long.class)
                .uniqueResult();

        Object[] minMax = session.createQuery(
                "select min(price), max(price) from Product", Object[].class)
                .uniqueResult();

        System.out.println("Total Products: " + total);
        System.out.println("Available Products: " + available);
        System.out.println("Min Price: " + minMax[0]);
        System.out.println("Max Price: " + minMax[1]);

        session.close();
    }

    // Group by description
    static void groupByDescription() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Object[]> list = session.createQuery(
                "select description, count(*) from Product group by description",
                Object[].class).list();

        for (Object[] obj : list) {
            System.out.println(obj[0] + " : " + obj[1]);
        }

        session.close();
    }

    // Filter by price range
    static void filterByPriceRange() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Product> q = session.createQuery(
                "from Product where price between 10000 and 40000",
                Product.class);

        q.list().forEach(p ->
                System.out.println(p.getName() + " : " + p.getPrice()));

        session.close();
    }

    // LIKE queries
    static void likeQueries() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        System.out.println("Starts with M:");
        session.createQuery(
                "from Product where name like 'M%'", Product.class)
                .list().forEach(p -> System.out.println(p.getName()));

        System.out.println("Ends with r:");
        session.createQuery(
                "from Product where name like '%r'", Product.class)
                .list().forEach(p -> System.out.println(p.getName()));

        System.out.println("Contains 'top':");
        session.createQuery(
                "from Product where name like '%top%'", Product.class)
                .list().forEach(p -> System.out.println(p.getName()));

        System.out.println("Exact length = 5:");
        session.createQuery(
                "from Product where length(name) = 5", Product.class)
                .list().forEach(p -> System.out.println(p.getName()));

        session.close();
    }
}
