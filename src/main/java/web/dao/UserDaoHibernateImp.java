package web.dao;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoHibernateImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   @SuppressWarnings("unchecked")
   public List<User> index() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getById(long id) {
      String hql = "from User u where u.id = :id";
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
      query.setParameter("id", id);
      User user = query.getSingleResult();
      return user;
   }

   @Override
   public void delete(long id) {
      Session session = sessionFactory.getCurrentSession();
      User user = session.get(User.class, id);
      session.delete(user);
   }

   @Override
   public void update(long id, String name, String lastName, int age) {
      User user = new User(id, name, lastName, age);
      sessionFactory.getCurrentSession().update(user);
   }

   @Override
   public void create(String name, String lastName, int age) {
      User user = new User(name, lastName, age);
      sessionFactory.getCurrentSession().save(user);
   }
}
