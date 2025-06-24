package application.dao;

import application.model.Message;
import application.model.Message;
import application.model.User;
import application.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MessageDAO implements DAOInterface<Message> {
    @Override
    public List<Message> getAll() {
        List<Message> rss=new ArrayList<>();

        try{
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            Transaction tx=session.beginTransaction();

            String hql="from Message";
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
    public Message selectById(String t) {
        Message rs=null;

        try{
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            Transaction tx=session.beginTransaction();

            String hql="from Message u where u.messageId = :id";
            Query query=session.createQuery(hql);
            query.setParameter("id", t);
            rs= (Message) query.getSingleResult();

            tx.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean insert(Message Message) {
        boolean rs=false;

        try{
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session=sessionFactory.openSession();
                Transaction tx=session.beginTransaction();

                session.save(Message);

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
    public boolean update(Message Message) {
        boolean rs=false;

        try{
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            Transaction tx=session.beginTransaction();

            session.update(Message);

            tx.commit();
            session.close();
            rs=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean delete(Message Message) {
        boolean rs=false;

        try{
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            Transaction tx=session.beginTransaction();

            session.delete(Message);

            tx.commit();
            session.close();
            rs=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public List<Message> selectByParticipantID(String t) {
        List<Message> rss=new ArrayList<>();

        try{
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            Transaction tx=session.beginTransaction();

            String hql="from Message m where m.participant = :id";
            Query query=session.createQuery(hql);
            query.setParameter("id", t);
            rss=query.getResultList();

            tx.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rss;
    }
public List<Message> selectMessagesBetweenUsers(User user1, User user2) {
    List<Message> messages = new ArrayList<>();
    try {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "SELECT m FROM Message m " +
                    "WHERE m.participant IN " +
                    "(SELECT p.participantId FROM Participant p " +
                    "WHERE p.conversation IN " +
                    "(SELECT p1.conversation FROM Participant p1, Participant p2 " +
                    "WHERE p1.conversation = p2.conversation " +
                    "AND ((p1.user = :user1 AND p2.user = :user2) " +
                    "OR (p1.user = :user2 AND p2.user = :user1))))";

        Query query = session.createQuery(hql);
        query.setParameter("user1", user1);
        query.setParameter("user2", user2);
        messages = query.getResultList();

        session.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return messages;
}
}