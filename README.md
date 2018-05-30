后端使用Java语言，Mysql数据库和Redis数据库以及Tomcat作为基本开发环境。
采用了Spring全家桶技术栈：
* 以Spring Boot为脚手架开发后端服务接口。
* 采用Spring Data Jpa完成访问数据库访问操作。
* 使用NoSQL，即Spring Data Redis以及Spring Data Cache组件进行部分数据缓存。
* 使用Quartz以及多线程池完成定时任务的调度以及缓存。
* 采用Spring Boot Devtools实施项目的热部署。
* 采用Lombok简化数据模型层的构建。
* 使用Swagger2自动构建接口文档。
