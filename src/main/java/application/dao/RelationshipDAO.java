package application.dao;

import application.model.Relationship;
import application.model.Relationship;
import application.model.User;
import application.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class RelationshipDAO implements DAOInterface<Relationship> {
    @Override
    public List<Relationship> getAll() {
        List<Relationship> rss=new ArrayList<>();

        try{
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            Transaction tx=session.beginTransaction();

            String hql="from Relationship";
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
    public Relationship selectById(String t) {
        Relationship rs=null;

        try{
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            Transaction tx=session.beginTransaction();

            String hql="from Relationship u where u.relationshipID = :id";
            Query query=session.createQuery(hql);
            query.setParameter("id", t);
            rs= (Relationship) query.getSingleResult();

            tx.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean insert(Relationship Relationship) {
        boolean rs=false;

        try{
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session=sessionFactory.openSession();
                Transaction tx=session.beginTransaction();

                session.save(Relationship);

                tx.commit();
                session.close();
                rs=true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public boolean update(Relationship relationship, String status) {
        boolean rs = false;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            // Tìm bản ghi dựa trên UserID1 và UserID2
            String hql = "from Relationship r where (r.user1 = :user1 and r.user2 = :user2) or (r.user1 = :user2 and r.user2 = :user1)";
            Query query = session.createQuery(hql);
            query.setParameter("user1", relationship.getUser1());
            query.setParameter("user2", relationship.getUser2());
            List<Relationship> results = query.getResultList();

            if (!results.isEmpty()) {
                for (Relationship r : results) {
                    r.setrStatus(status);
                    session.update(r);
                }
                tx.commit();
                session.close();
                rs = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean update(Relationship Relationship) {
        boolean rs=false;

        try{
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            Transaction tx=session.beginTransaction();

            session.update(Relationship);

            tx.commit();
            session.close();
            rs=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean delete(Relationship Relationship) {
        boolean rs=false;

        try{
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            Transaction tx=session.beginTransaction();

            session.delete(Relationship);

            tx.commit();
            session.close();
            rs=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public List<Relationship> selectByUserName(String userName) {
        List<Relationship> rss = new ArrayList<>();

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            String hql = "from Relationship u where u.user1.userName = :userName or u.user2.userName = :userName";
            Query query = session.createQuery(hql);
            query.setParameter("userName", userName);
            rss = query.getResultList();

            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rss;
    }
    public boolean updateSpecific(Relationship relationship, String status) {
        boolean rs = false;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            // Tìm bản ghi dựa trên UserID1 và UserID2 cụ thể
            String hql = "from Relationship r where r.user1 = :user1 and r.user2 = :user2";
            Query query = session.createQuery(hql);
            query.setParameter("user1", relationship.getUser1());
            query.setParameter("user2", relationship.getUser2());
            List<Relationship> results = query.getResultList();

            if (!results.isEmpty()) {
                Relationship r = results.get(0);
                r.setrStatus(status);
                session.update(r);
                tx.commit();
                rs = true;
            } else {
                // Nếu không tìm thấy mối quan hệ, tạo mới
                relationship.setrStatus(status);
                session.save(relationship);
                tx.commit();
                rs = true;
            }
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
public List<Relationship> selectRelationshipsByUsers(User user1, User user2) {
    List<Relationship> relationships = new ArrayList<>();
    try {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        String hql = "from Relationship r where " +
                    "(r.user1 = :user1 and r.user2 = :user2) or " +
                    "(r.user1 = :user2 and r.user2 = :user1)";
        Query query = session.createQuery(hql);
        query.setParameter("user1", user1);
        query.setParameter("user2", user2);
        relationships = query.getResultList();

        tx.commit();
        session.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return relationships;
}
    public List<Relationship> selectByUser1AndStatus(User user1, String status) {
        List<Relationship> relationships = new ArrayList<>();
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            String hql = "from Relationship r where r.user1 = :user1 and r.rStatus = :status";
            Query query = session.createQuery(hql);
            query.setParameter("user1", user1);
            query.setParameter("status", status);
            relationships = query.getResultList();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return relationships;
    }
}