package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public List<User> index();

    public User getById(long id);

    public void delete(long id);

    public void update(long id, String name, String lastName, int age);

    public void create(String name, String lastName, int age);
}
