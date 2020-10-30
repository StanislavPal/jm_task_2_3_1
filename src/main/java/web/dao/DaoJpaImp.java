package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DaoJpaImp implements Dao<User> {

//   @Autowired
//   private SessionFactory sessionFactory;

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public List<User> findAll() {
      TypedQuery<User> query = entityManager.createQuery("from User", User.class);
      return query.getResultList();
   }

   @Override
   public User findOne(long id) {
      String hql = "from User u where u.id = :id";
      TypedQuery<User> query = entityManager.createQuery(hql, User.class);
      query.setParameter("id", id);
      return query.getSingleResult();
   }

    @Override
    public void delete(User entity) {

    }

    @Override
   public void deleteById(long id) {
      entityManager.remove(findOne(id));
   }

   @Override
   public User update(User user) {
//      sessionFactory.getCurrentSession().update(user);
       return new User();
   }

   @Override
   public void create(User user) {
//      sessionFactory.getCurrentSession().save(user);
   }
}
