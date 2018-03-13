package co.bbs.web.front;

import co.bbs.core.ErrorCodeConstant;
import co.bbs.core.base.BaseController;
import co.bbs.core.bean.Result;
import co.bbs.core.exception.ApiException;
import co.bbs.module.notification.service.NotificationService;
import co.bbs.module.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tomoya.
 * Copyright (c) 2016, All Rights Reserved.
 * https://yiiu.co
 */
@Controller
@RequestMapping("/notification")
public class NotificationController extends BaseController {

  @Autowired
  private NotificationService notificationService;

  /**
   * 通知列表
   *
   * @param p
   * @param model
   * @return
   */
  @GetMapping("/list")
  public String list(Integer p, Model model) {
    model.addAttribute("p", p);
    return "/front/notification/list";
  }

  /**
   * 查询当前用户未读的消息数量
   *
   * @return
   */
  @GetMapping("/notRead")
  @ResponseBody
  public Result notRead() throws ApiException {
    User user = getUser();
    if (user == null) throw new ApiException(ErrorCodeConstant.notLogin, "请先登录");
    return Result.success(notificationService.countByTargetUserAndIsRead(user, false));
  }
}
