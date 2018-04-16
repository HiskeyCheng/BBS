/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: 程志祥<cheng_zx @ suixingpay.com>
 * @date: 2018/4/10
 * @Copyright: ©2018 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package co.bbs.start;

import co.bbs.Application;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @description:
 * @author: 程志祥<cheng_zx @ suixingpay.com>
 * @date: 2018/4/10 下午2:15
 * @version: V1.0
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}
