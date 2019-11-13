# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.0.RELEASE/maven-plugin/)

####集成swagger2, 可以通过以下方式查看接口文档
http://localhost:8888/aopdemo/swagger-ui.html#/
http://localhost:8888/aopdemo/v2/api-docs


 该项目目前实现的功能包括:
1. 面向切面编程，实现日志管理
2. 集成Swagger实现接口API文档，快速运行接口测试
    http://localhost:8888/aopdemo/swagger-ui.html#/
3. 实现Druid实现sql实时监控（密码在application.yml配置文件中）
    http://localhost:8888/aopdemo/druid/index.html
    登录名/密码：admin/admin
4. 集成了mybatis-generator，快速生成User.java, UserMapper.java, UserMapper.xml 三个文件
5. 集成了PageHelper, 实现方法请查看接口 http://localhost:8888/aopdemo/user/list?limit=3&offset=3
   使用PageInfo返回分页数据
6. 集成spring-security实现安全访问控制，登录名/密码：user/user
   访问链接地址：http://localhost:8888/aopdemo/hello/list 在未登录的情况下会跳转到登录页面
   坑：csrf Token会导致post，put，Delete请求无法验证通过，返回403错误
   因此在swagger环境下设置为 csrf().disable()，实际情况应该使用默认设置
7. 集成Redis
