SPRING IO PLATFORM 控制maven坐标兼容问题

采用配置中心spring config + bus + RabbitMQ

实现配置git远端拉取与免重启

simple-demo附带一些参考demo

如：过滤器、swagger-ui、加载配置文件等


架构介绍

spring-cloud-version中的pom控制体系内的版本升级

spring-cloud-core控制体系内的公有模块代码，如依赖以及日后加入的常用工具包等

Spring官网:http://spring.io/projects

注：同时希望各位可以将自己的小demo、小设计上传至simple-demo
    或者simple-${name}-demo工程命名的形式共享出自己的心得
    
使用教程

首先你得下载spring-cloud-version与spring-cloud-core两个pom头并且install

其次用自定义骨架，如
<archetype>
  <groupId>com.hxg.cloud</groupId>
  <artifactId>app-archetype</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <description>Demo project for Spring Boot</description>
</archetype>
快速生成工程
