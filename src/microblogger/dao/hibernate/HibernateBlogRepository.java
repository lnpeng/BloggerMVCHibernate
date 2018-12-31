package microblogger.dao.hibernate;

import microblogger.dao.BlogRepository;
import microblogger.dao.entity.Blog;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Primary
@Transactional
public class HibernateBlogRepository implements BlogRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public HibernateBlogRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Blog> findRecent() {
        return blogCriteria()
                .setMaxResults(20)
                .list();
    }

    @Override
    public Blog findOne(long id) {
        return (Blog) currentSession()
                .get(Blog.class, id);
    }

    @Override
    public void save(Blog blog) {
        currentSession().save(blog);
    }

    @Override
    public List<Blog> findBlogs(long max, int count) {
        return blogCriteria()
                .add(Restrictions.lt("id", max))
                .setMaxResults(count)
                .list();
    }

    private Criteria blogCriteria() {
        return currentSession()
                .createCriteria(Blog.class)
                .addOrder(Order.desc("createTime"));
    }
}
