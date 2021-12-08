package ru.firstTry.bot;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import ru.firstTry.bot.models.User;

import java.util.List;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class DBHandler {
    private static SessionFactory sessionFactory = null;
    private static ServiceRegistry serviceRegistry = null;

    private static SessionFactory configureSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();

        configuration.configure("resources/hibernate.cfg.xml");

        Properties properties = configuration.getProperties();

        serviceRegistry = new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }

    public User getOrRegisterUser(long chatId, String usernaeme, String fullName, int balance) {
        // Configure the session factory
        configureSessionFactory();

        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            List<User> users = getAllUsers();

            for(User user : users){
                if (user.getChatId() == chatId)
                    return user;
            }

            User user = new User(chatId, usernaeme, fullName, balance);

            session.save(user);
            session.flush();
            tx.commit();
            return user;
        } catch (Exception ex) {
            ex.printStackTrace();
            tx.rollback();
        } finally{
            if(session != null) {
                session.close();
            }
        }
        return null;
    }

    public User getUserByChatId(long chatId) {
        // Configure the session factory
        configureSessionFactory();

        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            List<User> users = session.createQuery("From User").list();
            for(User user : users){
                if (user.getChatId() == chatId)
                    return user;
            }
            tx.commit();
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            tx.rollback();
        } finally{
            if(session != null) {
                session.close();
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        // Configure the session factory
        configureSessionFactory();

        Session session = null;
        Transaction tx = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            List<User> users = session.createQuery("From User").list();
            tx.commit();
            return users;
        } catch (Exception ex) {
            ex.printStackTrace();
            tx.rollback();
        } finally{
            if(session != null) {
                session.close();
            }
        }
        return null;
    }
}
