package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.Dao;
import web.model.User;

import java.util.List;

@Service
public class UserService{

    @Autowired
    @Qualifier("daoJpaImp")
    private Dao<User> dao;

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return dao.findAll();
    }

    @Transactional
    public User getById(long id) {
        return dao.findOne(id);
    }

    @Transactional
    public void delete(long id) {
        dao.deleteById(id);
    }

    @Transactional
    public void update(long id, User user) {
        user.setId(id);
        dao.update(user);
    }

    @Transactional
    public void create(User user) {
        dao.create(user);
    }
}
