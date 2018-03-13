package co.bbs.module.score.service;

import co.bbs.config.ScoreEventConfig;
import co.bbs.core.util.FreemarkerUtil;
import co.bbs.module.score.model.ScoreLog;
import co.bbs.module.score.repository.ScoreLogRepository;
import co.bbs.module.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by teddyzhu.
 * Copyright (c) 2017, All Rights Reserved.
 */
@Service
@CacheConfig(cacheNames = "scoreLogs")
public class ScoreLogService {

    @Autowired
    FreemarkerUtil freemarkerUtil;

    @Autowired
    ScoreLogRepository scoreLogRepository;
    @Autowired
    ScoreEventConfig scoreEventConfig;

    @CacheEvict(allEntries = true)
    public void save(ScoreLog scoreLog) {
        scoreLogRepository.save(scoreLog);
    }

    @Cacheable
    public Page<ScoreLog> findScoreByUser(Integer p, int size, User user) {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "inTime"));
        Pageable pageable = new PageRequest(p == null ? 0 : p-1, size, sort);
        return scoreLogRepository.findByUser(user, pageable);
    }

}
