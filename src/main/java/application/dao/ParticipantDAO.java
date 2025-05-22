package application.dao;

import application.model.Participant;
import application.model.Participant;
import application.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ParticipantDAO implements DAOInterface<Participant> {
    @Override
    public List<Participant> getAll() {
        List<Participant> rss=new ArrayList<>();

        try{
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            Transaction tx=session.beginTransaction();

            String hql="from Participant";
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
    public Participant selectById(String t) {
        Participant rs=null;

        try{
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            Transaction tx=session.beginTransaction();

            String hql="from Participant u where u.participantId = :id";
            Query query=session.createQuery(hql);
            query.setParameter("id", t);
            rs= (Participant) query.getSingleResult();

            tx.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean insert(Participant Participant) {
        boolean rs=false;

        try{
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session=sessionFactory.openSession();
                Transaction tx=session.beginTransaction();

                session.save(Participant);

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
    public boolean update(Participant Participant) {
        boolean rs=false;

        try{
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            Transaction tx=session.beginTransaction();

            session.update(Participant);

            tx.commit();
            session.close();
            rs=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean delete(Participant Participant) {
        boolean rs=false;

        try{
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            Transaction tx=session.beginTransaction();

            session.delete(Participant);

            tx.commit();
            session.close();
            rs=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public Participant selectByUserIDAndConversationID(String uid, String cid) {
        Participant rs=null;

        try{
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            Transaction tx=session.beginTransaction();

            String hql="from Participant p where p.user = :uid and p.conversation = :cid";
            Query query=session.createQuery(hql);
            query.setParameter("uid", uid);
            query.setParameter("cid", cid);
            rs= (Participant) query.getSingleResult();

            tx.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }
}