package co.bbs.module.collect.repository;

import co.bbs.module.collect.model.Collect;
import co.bbs.module.topic.model.Topic;
import co.bbs.module.user.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tomoya.
 * Copyright (c) 2016, All Rights Reserved.
 * https://yiiu.co
 */
@Repository
public interface CollectRepository extends JpaRepository<Collect, Integer> {

  Page<Collect> findByUser(User user, Pageable pageable);

  long countByUser(User user);

  long countByTopic(Topic topic);

  Collect findByUserAndTopic(User user, Topic topic);

  void deleteByUser(User user);

  void deleteByTopic(Topic topic);
}
