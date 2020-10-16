package DAO;

import model.Adres;
import model.OVChipkaart;
import model.Reiziger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class OVChipkaartDAOHibernate implements OVChipkaartDAO {
    private SessionFactory sessionFactory;
    private Session session;

    public OVChipkaartDAOHibernate(){
        Configuration config = new Configuration();
        config.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost/ovchip");
        config.setProperty("hibernate.connection.username", "gebruiker");
        config.setProperty("hibernate.connection.password", "wachtwoord");
        config.configure();
        sessionFactory = config.buildSessionFactory();
    }

    @Override
    public boolean save(OVChipkaart o) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(o);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(OVChipkaart o) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(o);
        transaction.commit();
        session.close();
        return true;    }

    @Override
    public boolean update(OVChipkaart o) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(o);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public OVChipkaart findByKaartnummer(int kaartnummer) {
        Session session = sessionFactory.openSession();
        OVChipkaart ov = session.get(OVChipkaart.class, kaartnummer);
        session.close();
        return ov;
    }

    @Override
    public List<OVChipkaart> findAll() {
        Session session = sessionFactory.openSession();
        List<OVChipkaart> lijst = session.createQuery("from ov_chipkaart").list();
        session.close();
        return lijst;
    }

    @Override
    public OVChipkaart findByReiziger(Reiziger r) {
        return null;
    }
}
