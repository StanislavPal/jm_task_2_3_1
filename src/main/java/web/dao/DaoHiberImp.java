package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DaoHiberImp implements Dao<User> {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   @SuppressWarnings("unchecked")
   public List<User> findAll() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User findOne(long id) {
      String hql = "from User u where u.id = :id";
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
      query.setParameter("id", id);
      User user = query.getSingleResult();
      return user;
   }

   @Override
   public void deleteById(long id) {
      Session session = sessionFactory.getCurrentSession();
      User user = session.get(User.class, id);
      session.delete(user);
   }

   @Override
   public User update(User user) {
      sessionFactory.getCurrentSession().update(user);
      return findOne( user.getId() );
   }

    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
   public void create(User user) {
      sessionFactory.getCurrentSession().save(user);
   }
}
