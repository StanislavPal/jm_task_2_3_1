package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    @Qualifier("userDaoHibernateImp")
    private UserDao userDao;

    @Transactional(readOnly = true)
    @Override
    public List<User> index() {
        return userDao.index();
    }

    @Transactional
    @Override
    public User getById(long id) {
        return userDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Transactional
    @Override
    public void update(long id, String name, String lastName, int age) {
        userDao.update(id, name, lastName, age);
    }

    @Transactional
    @Override
    public void create(String name, String lastName, int age) {
        userDao.create(name, lastName, age);
    }
}
