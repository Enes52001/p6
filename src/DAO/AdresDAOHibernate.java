package DAO;

import model.Adres;
import model.Reiziger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AdresDAOHibernate implements AdresDAO {
    private SessionFactory sessionFactory;
    private Session session;

    public AdresDAOHibernate(){
        Configuration config = new Configuration();
        config.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost/ovchip");
        config.setProperty("hibernate.connection.username", "gebruiker");
        config.setProperty("hibernate.connection.password", "wachtwoord");
        config.configure();
        sessionFactory = config.buildSessionFactory();
    }

    @Override
    public boolean save(Adres r) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(r);
        transaction.commit();
        session.close();
        return true;    }

    @Override
    public boolean delete(Adres r) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(r);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Adres r) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(r);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Adres findById(int id) {
        Session session = sessionFactory.openSession();
        Adres adres = session.get(Adres.class, id);
        session.close();
        return adres;
    }

    @Override
    public Adres findByReiziger(Reiziger r) {
        return null;
    }

    @Override
    public List<Adres> findAll() {
        Session session = sessionFactory.openSession();
        List<Adres> adressen = session.createQuery("from adres").list();
        session.close();

        return adressen;
    }
}
