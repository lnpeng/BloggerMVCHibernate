package microblogger.dao;

import microblogger.dao.entity.Blogger;

public interface BloggerRepository {
    Blogger save(Blogger bloger);

    Blogger findByUsername(String username);
}
