## 逆向工程

[开源项目：逆向工程—①键完成CRUD](https://gitee.com/renrenio/renren-generator?_from=gitee_search)

### 整合mybatis-plus

1. 导入依赖

    ```xml
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-boot-starter</artifactId>
        <version>3.2.0</version>
    </dependency>
    ```

2. 配置（参考官方文档）

    - 配置数据源

        - 导入数据库驱动

            ```xml
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>8.0.18</version>
            </dependency>
            ```

        - 配置数据源

            ```
            driver-class-name: com.mysql.cj.jdbc.Driver
            url: jdbc:mysql://192.168.110.135:3306/aimerrhythms_mall_admin?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useSSL=false
            username: root
            password: 123123
            ```

    - 配置mybatis-plus

        - @MapperScan("com.aimerrhythms.mall.product.dao")。  扫描dao层接口

        - 在yaml文件中告诉mybatis-plus，dao接口的SQL映射文件的位置

            ```yaml
            # classpath*中的*表示引用的其他jar包下的类路径也进行扫描
            # 一般写classpath即可
            mybatis-plus:
              mapper-locations: classpath:/mapper/**/*.xml
            # mapper-locations: classpath*:/mapper/**/*.xml
            ```

        - 配置文件中调整主键的自增（mybatis-plus的机制）

            ```yaml
            mybatis-plus:
              global-config:
                db-config:
                  id-type: auto
            ```

