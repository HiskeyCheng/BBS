> 本项目是从 (https://github.com/HiskeyCheng/BBS) fork 过来的

## 技术栈

- JDK8
- Spring-Boot1.5.8
- Spring-Security
- Spring-JPA
- Hibernate-Search5.8.0
- Freemarker
- Sqlite(或MySQL)
- Bootstrap3
- Ehcache

*呃，就是spring全家桶*

## 特性

- 社区兼容性（IE9+）
- 页面自适应布局
- 本地登录，注册
- 登录时有验证码，尝试登录次数的限制
- 使用 `Spring-Boot` 开发
- 权限使用 `Spring-Security` ，基于url做的权限方便配置管理
- 使用的 `Spring-JPA` 操作数据存储
- 使用 `Hibernate-Search` 做数据检索，支持中文分词和结果关键字高亮
- 自己实现了一个Markdown编辑器, 附带菜单，书写方便, 还支持拖拽图片上传

待完成的功能 *如果有你折腾过的，欢迎提pr，先谢过了:-)* 

- [ ] 权限修改后实现热更新，不用重新登录就可以生效
- [ ] 第三方登录成功后记住我
- [ ] 制作Docker镜像
- [X] 登录记住我 感谢@beldon
- [X] 第三方登录集成，集成Github登录

## 快速开始

*数据库里的表是项目启动时自动创建的，不要再问创建表的脚本在哪了*

- 创建数据库yiiu, 字符集utf8，如果想支持emoji，就要选择utf8mb4字符集（仅限使用MySQL数据库）
- `git clone https://github.com/yiiu-co/yiiu`
- 运行 `mvn spring-boot:run` 启动项目 (这一步系统会自动把表创建好)
- 访问 `http://localhost:8080`
- 登录用户名：tomoya 密码：123123 (权限是超级管理员)

## 打包部署开发环境

- 将项目里的application.yml文件复制一份，重新命名application-prod.yml，并修改里面的配置项
- 运行 `mvn clean compile package`
- 拷贝 `target/yiiu.jar` 到你想存放的地方
- 运行 `java -jar yiiu.jar --spring.profiles.active=prod > yiiu.log 2>&1 &` 项目就在后台运行了
- 关闭服务运行 `ps -ef | grep yiiu.jar | grep -v grep | cut -c 9-15 | xargs kill -s 9`
- 查看日志运行 `tail -200f yiiu.log`

#### 启动好后可能会报404错误，两个解决办法

1. 把pom.xml里的这段代码放开注释重新打包再启动即可
```
<resource>
  <directory>views</directory>
</resource>
```
2. 把源码里的views文件夹复制到打好的jar包文件夹里（跟jar包同级）

windows上启动脚本参见 [传送门](https://github.com/yiiu-co/yiiu/wiki/windows上的启动脚本)

## 添加emoji支持（仅MySQL数据库）

- 创建数据库时选择 `utf8mb4` 字符集
- 添加下面这段配置到 `/etc/mysql/mysql.conf.d/mysqld.conf` 里的 `[mysqld]` 下，保存重启Mysql服务
```
[mysqld]
character-set-client-handshake = FALSE
character-set-server = utf8mb4
collation-server = utf8mb4_unicode_ci
init_connect='SET NAMES utf8mb4'
```
- 如果不行，试着把yiiu也重启一下

## 切回MySQL方法

打开 `application.yml` 将下面关于mysql连接的配置放开，把sqlite相关的配置注释掉就可以了

```yml
# mysql 配置
  datasource:
    url: jdbc:mysql://localhost/yiiu?useSSL=false&characterEncoding=utf8
    username: root
    password: 123123
  jpa:
    database: mysql
```

```yml
# sqlite 配置
  datasource:
    driver-class-name: org.sqlite.JDBC
    url: jdbc:sqlite:./yiiu.sqlite
  jpa:
    database-platform: co.yiiu.core.dialect.SQLiteDialect
```

另外pom.xml文件里的mysql依赖也要取消注释

```xml
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <scope>runtime</scope>
</dependency>
```

## 关于主题

本项目配置的结构目录非常方便主题开发，如果你想适配一套自己喜欢的主题，可以按照 `views` 目录下的文件夹结构开发，然后修改一下配置文件里的 `site.theme` 的值即可打包部署了

后续我也会适配一些好看的主题放到组织 `yiiu-co` 里

## 配置邮箱

我只配置了QQ邮箱，按照下面配置方法配置是没有问题的

```
mail:
  host: smtp.qq.com # 如果是企业邮箱这里要改成 smtp.exmail.qq.com
  username: xxoo@qq.com # 你的QQ邮箱地址
  password: # 这里的密码是QQ邮箱的授权码
  port: 465
  properties:
    mail.smtp.auth: true
    mail.smtp.ssl.enable: true
    mail.smtp.starttls.enable: true
    mail.smtp.starttls.required: true
```

## 反馈

[issues](https://github.com/yiiu-co/yiiu/issues)

QQ群：`419343003`

*提问题的时候请将问题重现步骤描述清楚*

## 其它版本

- golang版：https://github.com/tomoya92/pybbs-go
- springboot版：https://github.com/yiiu-co/yiiu
- jfinal版：https://github.com/tomoya92/pybbs/tree/v2.3
- ssm版：https://github.com/ehuacui/ehuacui-bbs

## 贡献

欢迎大家提 issues 及 pr 

感谢以下朋友的pr

[@beldon](https://github.com/beldon) [@Teddy-Zhu](https://github.com/Teddy-Zhu)

## License

MIT
# BBS
