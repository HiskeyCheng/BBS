package co.bbs.module.user.repository;

import co.bbs.module.user.model.GithubUser;
import co.bbs.module.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tomoya.
 * Copyright (c) 2016, All Rights Reserved.
 * https://yiiu.co
 */
@Repository
public interface GithubUserRepository extends JpaRepository<GithubUser, Integer> {

  GithubUser findByUser(User user);

  GithubUser findByLogin(String login);
}
