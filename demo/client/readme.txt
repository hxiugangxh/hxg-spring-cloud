目的：暴露该项目的fegin等功能接口
不建议让别的工程直接feign本工程的controller功能
一：利于查看fegin微服务链路关系(zipkin插件辅助改造架构)
二：若该项目人员修改controller讲无法得知其他项目的影响情况，就建议使用统一client
达到"服务端"代码的一致性