package application.dao;

import application.model.User;
import application.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserDAO implements DAOInterface<User> {

    @Override
    public List<User> getAll() {
        List<User> rss=new ArrayList<>();

        try{
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            Transaction tx=session.beginTransaction();

            String hql="from User";
            Query query=session.createQuery(hql);
            rss=query.getResultList();

            tx.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rss;
    }

    @Override
    public User selectById(String t) {
        User rs=null;

        try{
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            Transaction tx=session.beginTransaction();

            String hql="from User u where u.userID = :id";
            Query query=session.createQuery(hql);
            query.setParameter("id",t);
            rs= (User) query.getSingleResult();

            tx.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean insert(User user) {
        boolean rs=false;

        try{
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session=sessionFactory.openSession();
                Transaction tx=session.beginTransaction();

                session.save(user);

                tx.commit();
                session.close();
                rs=true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean update(User user) {
        boolean rs=false;

        try{
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            Transaction tx=session.beginTransaction();

            session.update(user);

            tx.commit();
            session.close();
            rs=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean delete(User user) {
        boolean rs=false;

        try{
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            Transaction tx=session.beginTransaction();

            session.delete(user);

            tx.commit();
            session.close();
            rs=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public User selectByUsernameAndPassword(String username,String password) {
        User rs=null;

        try{
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            Transaction tx=session.beginTransaction();

            String hql="from User u where u.userName=:username and u.password=:password";
            Query query=session.createQuery(hql);
            query.setParameter("username", username);
            query.setParameter("password", password);
            rs= (User) query.getSingleResult();

            tx.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public User selectByUsername(String username) {
        User rs=null;

        try{
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            Transaction tx=session.beginTransaction();

            String hql="from User u where u.userName=:username";
            Query query=session.createQuery(hql);
            query.setParameter("username", username);
            rs= (User) query.getSingleResult();

            tx.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public List<User> selectFriend(User user) {
        List<User> rss=null;

        try{
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            Transaction tx=session.beginTransaction();

            String hql = "select distinct r.user2 from User u join u.relationships1 r where u.userID = :userId and r.rStatus = 'accepted' \n" +
                    "union \n" +
                    "select distinct r.user1 from User u join u.relationships2 r where u.userID = :userId and r.rStatus = 'accepted'";
            Query query=session.createQuery(hql);
            query.setParameter("userId", user.getUserID());
            rss= query.getResultList();

            tx.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rss;
    }

    public List<User> selectByUsernameLike(String usernamePattern) {
        List<User> users = new ArrayList<>();
        Session session = null;
        Transaction tx = null;

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            String hql = "from User u where lower(u.userName) like :pattern";
            Query query = session.createQuery(hql);
            query.setParameter("pattern", "%" + usernamePattern.toLowerCase() + "%");
            users = query.getResultList();

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return users;
    }
}