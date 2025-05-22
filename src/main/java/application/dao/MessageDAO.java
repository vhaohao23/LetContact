package application.dao;

import application.model.Message;
import application.model.Message;
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
}
