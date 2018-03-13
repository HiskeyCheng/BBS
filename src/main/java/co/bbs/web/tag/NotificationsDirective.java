package co.bbs.web.tag;

import co.bbs.config.SiteConfig;
import co.bbs.module.notification.model.Notification;
import co.bbs.module.notification.service.NotificationService;
import co.bbs.module.user.model.User;
import co.bbs.module.user.service.UserService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * Created by tomoya.
 * Copyright (c) 2016, All Rights Reserved.
 * https://yiiu.co
 */
@Component
public class NotificationsDirective implements TemplateDirectiveModel {

  @Autowired
  private NotificationService notificationService;
  @Autowired
  private UserService userService;
  @Autowired
  private SiteConfig siteConfig;

  @Override
  public void execute(Environment environment, Map map, TemplateModel[] templateModels,
                      TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
    DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String username = ((org.springframework.security.core.userdetails.User) authentication.getPrincipal()).getUsername();
    User user = userService.findByUsername(username);

    int p = map.get("p") == null ? 1 : Integer.parseInt(map.get("p").toString());

    Page<Notification> page = notificationService.findByTargetUserAndIsRead(p, siteConfig.getPageSize(), user, null);
    //将未读消息置为已读
    notificationService.updateByIsRead(user);

    environment.setVariable("page", builder.build().wrap(page));
    templateDirectiveBody.render(environment.getOut());
  }
}