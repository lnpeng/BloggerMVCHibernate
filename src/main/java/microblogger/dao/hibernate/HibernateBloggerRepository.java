package microblogger.dao.hibernate;

import microblogger.dao.BloggerRepository;
import microblogger.dao.entity.Blogger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Repository
@Primary
@Transactional
public class HibernateBloggerRepository implements BloggerRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public HibernateBloggerRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Blogger save(Blogger blogger) {
        Serializable id = currentSession().save(blogger);

        return new Blogger((Long)id,
                blogger.getUsername(),
                blogger.getPassword(),
                blogger.getFirstName(),
                blogger.getLastName(),
                blogger.getEmail());
    }

    @Override
    public Blogger findByUsername(String username) {
        return (Blogger)currentSession()
                .createCriteria(Blogger.class)
                .add(Restrictions.eq("username", username))
                .list().get(0);
    }
}
