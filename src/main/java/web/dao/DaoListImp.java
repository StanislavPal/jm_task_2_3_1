package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoListImp implements Dao<User> {
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
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findOne(long id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(new User());
    }

    @Override
    public void delete(User user) {
        users.removeIf(u -> u.equals(user));
    }

    @Override
    public void deleteById(long id) {
        users.removeIf(user -> user.getId() == id);
    }

    @Override
    public User update(User newUser) {
        User user = findOne(newUser.getId());
        user.setId(newUser.getId());
        user.setName(newUser.getName());
        user.setLastName(newUser.getLastName());
        user.setAge(newUser.getAge());
        return user;
    }

    @Override
    public void create(User user) {
        user.setId(++USER_COUNT);
        users.add(user);
    }
}
