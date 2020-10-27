package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoListImp implements UserDao {
    private static long USER_COUNT;
    private List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User(++USER_COUNT, "Elton", "John", 43));
        users.add(new User(++USER_COUNT, "Angelina", "Jolly", 35));
        users.add(new User(++USER_COUNT, "Tom", "Cat", 27));
        users.add(new User(++USER_COUNT, "Jerry", "Mouse", 33));
    }

    @Override
    public List<User> index() {
        return users;
    }

    @Override
    public User getById(long id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(new User());
    }

    @Override
    public void delete(long id) {
        users.removeIf(user -> user.getId() == id);
    }

    @Override
    public void update(long id, String name, String lastName, int age) {
        User user = getById(id);
        user.setId(id);
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
    }

    @Override
    public void create(String name, String lastName, int age) {
        users.add(new User(++USER_COUNT, name, lastName, age));
    }
}
