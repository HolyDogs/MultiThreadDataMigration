# MultiThreadDataMigration

多数据源-多线程-数据迁移
----

多数据源配置如下，自行修改多源配置
```      datasource:
        master:
          url: jdbc:oracle:thin:@xxx.xxx.x.xxx:xxxx:ORCL
          username: xxxx
          password: password
          driverClassName: oracle.jdbc.driver.OracleDriver
        slave:
          url: jdbc:oracle:thin:@xxx.xxx.x.xxx:xxxx:ORCL
          username: xxx
          password: password
          driverClassName: oracle.jdbc.driver.OracleDriver```
          
手动迁移数据启动方法在单元测试类里，无须启动SpringBoot项目。有定时更新数据的功能，配置task包下的定时类即可。

主要迁移过程及原理：

    同时启动多个自定义继承Thread的线程类并运行，设置一个变量（分页页数）同步锁，同一时间只能被一个线程读取和写入，
    多个线程运行时，确保每个线程不会读取到重复的页码。
    线程根据页码读取数据数量（数据源A），然后执行更新或插入操作（数据源B）。
    
性能比较：

经过重复验证，笔者电脑每页数据数量设置在100-1000，线程数目设置6-10性能较优。

