package application.dao;

import application.model.Conversation;
import application.model.Participant;
import application.model.Participant;
import application.model.User;
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
    public boolean insert(Participant participant) {
        boolean rs = false;

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tx = session.beginTransaction();

                session.save(participant);

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
    public Conversation getCommonConversation(User user1, User user2){
        Conversation rs=null;

        try{
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            Transaction tx=session.beginTransaction();

            String hql="select distinct p1.conversation from Participant p1,Participant p2 " +
                    "where p1.user = :user1 and p2.user = :user2 and p1.conversation = p2.conversation";
            Query query=session.createQuery(hql);
            query.setParameter("user1", user1);
            query.setParameter("user2", user2);
            rs= (Conversation) query.getSingleResult();

            tx.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    public Participant selectParticipantOneByTwoUser(User user1,User user2){
        Participant rs=null;

        try{
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            Transaction tx=session.beginTransaction();

            String hql="select p1 " +
                    "from Participant p1, Participant p2 " +
                    "where p1.conversation = p2.conversation " +
                    "and p1.user = :user1 " +
                    "and p2.user = :user2";
            Query query=session.createQuery(hql);
            query.setParameter("user1", user1);
            query.setParameter("user2", user2);

            rs= (Participant) query.getSingleResult();

            tx.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public List<Participant> selectByUserIDAndRole(String userId, String role) {
        List<Participant> participants = new ArrayList<>();
        Session session = null;
        Transaction tx = null;

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            String hql = "from Participant p where p.user.userID = :userId and p.role = :role";
            Query query = session.createQuery(hql);
            query.setParameter("userId", userId);
            query.setParameter("role", role);
            participants = query.getResultList();

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return participants;
    }
public int countParticipantsInConversation(String conversationId) {
    try {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        String hql = "SELECT COUNT(p) FROM Participant p WHERE p.conversation.conversationID = :cid";
        Query query = session.createQuery(hql);
        query.setParameter("cid", conversationId);
        
        Long count = (Long) query.getSingleResult();
        session.close();
        return count.intValue();
    } catch (Exception e) {
        e.printStackTrace();
        return 0;
    }
}

public List<Conversation> getGroupConversationsForUser(String userId) {
    try {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        String hql = "SELECT DISTINCT p.conversation FROM Participant p " +
                    "WHERE p.conversation.type = 'group' " +
                    "AND p.conversation.conversationID IN " +
                    "(SELECT p2.conversation.conversationID FROM Participant p2 " +
                    "GROUP BY p2.conversation.conversationID " +
                    "HAVING COUNT(p2) > 3) " +
                    "AND EXISTS (SELECT 1 FROM Participant p3 " +
                    "WHERE p3.conversation = p.conversation " +
                    "AND p3.user.userID = :userId)";
        
        Query query = session.createQuery(hql);
        query.setParameter("userId", userId);
        
        List<Conversation> results = query.getResultList();
        session.close();
        return results;
    } catch (Exception e) {
        e.printStackTrace();
        return new ArrayList<>();
    }
}
}