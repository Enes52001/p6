package DAO;

import model.Adres;
import model.OVChipkaart;
import model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProductDAOHibernate implements ProductDAO {
    private SessionFactory sessionFactory;
    private Session session;

    public ProductDAOHibernate(){
        Configuration config = new Configuration();
        config.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost/ovchip");
        config.setProperty("hibernate.connection.username", "gebruiker");
        config.setProperty("hibernate.connection.password", "wachtwoord");
        config.configure();
        sessionFactory = config.buildSessionFactory();
    }

    @Override
    public boolean save(Product p) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(p);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Product p) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(p);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Product p) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(p);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Product> findByOvChipkaart(OVChipkaart ov) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        Session session = sessionFactory.openSession();
        List<Product> lijst = session.createQuery("from product").list();
        session.close();

        return lijst;
    }
}
