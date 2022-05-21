## 码匠社区

## 资料
[Spring 文档](https://spring.io/guides)  
[Spring Web](https://spring.io/guides/gs/serving-web-content)  
[Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html)  
[ElasticSearch 社区](https://elasticsearch.cn)  
[Github Deploy key](https://docs.github.com/cn/developers/overview/managing-deploy-keys#deploy-keys)  
[BootStrap](https://v3.bootcss.com/)  
[Github OAuth](https://docs.github.com/cn/developers/apps/building-oauth-apps/creating-an-oauth-app)  

## 工具
https://git-scm.com/

## 脚本
```sql
CREATE TABLE `user` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `account_id` varchar(100) DEFAULT NULL,
    `name` varchar(50) DEFAULT NULL,
    `token` char(36) DEFAULT NULL,
    `gmt_create` datetime DEFAULT NULL,
    `gmt-modified` datetime DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```
