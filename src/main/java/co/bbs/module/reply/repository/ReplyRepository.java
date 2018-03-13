package co.bbs.module.reply.repository;

import co.bbs.module.reply.model.Reply;
import co.bbs.module.topic.model.Topic;
import co.bbs.module.user.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tomoya.
 * Copyright (c) 2016, All Rights Reserved.
 * https://yiiu.co
 */
@Repository
public interface ReplyRepository extends JpaRepository<Reply, Integer> {

  List<Reply> findByTopicOrderByUpDownDescDownAscInTimeAsc(Topic topic);

  void deleteByTopic(Topic topic);

  void deleteByUser(User user);

  Page<Reply> findByUser(User user, Pageable pageable);
}
