package DAO;

import model.Adres;
import model.Reiziger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ReizigerDAOHibernate implements ReizigerDAO {
    private SessionFactory sessionFactory;
    private Session session;

    public ReizigerDAOHibernate(){
        Configuration config = new Configuration();
        config.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost/ovchip");
        config.setProperty("hibernate.connection.username", "gebruiker");
        config.setProperty("hibernate.connection.password", "wachtwoord");
        config.configure();
        sessionFactory = config.buildSessionFactory();
    }

    @Override
    public boolean save(Reiziger r) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(r);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Reiziger r) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(r);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Reiziger r) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(r);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Reiziger findById(int id) {
        Session session = sessionFactory.openSession();
        Reiziger reiziger = session.get(Reiziger.class, id);
        session.close();
        return reiziger;
    }

    @Override
    public List<Reiziger> findByGbDatum(String datum) {
        Session session = sessionFactory.openSession();
        List<Reiziger> lijst = session.createQuery("from Reiziger where geboortedatum = :gbdatum").setParameter("gbdatum", datum).list();
        session.close();
        return lijst;
    }

    @Override
    public List<Reiziger> findAll() {
        Session session = sessionFactory.openSession();
        List<Reiziger> lijst = session.createQuery("from reiziger").list();
        session.close();

        return lijst;    }
}
