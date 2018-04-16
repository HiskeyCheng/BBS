/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: 程志祥<cheng_zx@suixingpay.com>
 * @date: 2018/3/13
 * @Copyright: ©2018 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package co.bbs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: 程志祥<cheng_zx@suixingpay.com>
 * @date: 2018/3/13 下午1:41
 * @version: V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MailSendTest {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String username;

    @Test
    public void testSendSimple() {
        /*SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(username);
        message.setTo("cheng_zx@suixingpay.com");
        message.setSubject("标题：测试标题");
        message.setText("测试内容部份");
        javaMailSender.send(message);*/
    }

}
