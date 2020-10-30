package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

@Repository
public class DaoJpaImp extends AbstractJpaDao<User> implements Dao<User> {
    public DaoJpaImp() {
        setClazz(User.class );
    }
}