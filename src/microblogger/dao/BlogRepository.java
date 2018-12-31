package microblogger.dao;

import java.util.List;

import microblogger.dao.entity.Blog;

public interface BlogRepository {
    List<Blog> findRecent();

    List<Blog> findBlogs(long max, int count);

    Blog findOne(long id);

    void save(Blog blog);
}
