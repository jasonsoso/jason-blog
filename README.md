
## JasonBlog 杰森博客 ##
- 开发进度：
暂时項目整理中... 
开发权限系统中...

## 项目框架： ##

- 主要框架：SpringMVC + Spring + SpringSecurity + Hibernate + Freemark
- 数据库：Mysql
- 项目管理：Maven
- 代码版本管理：Git

## Git Clone 代码： ##
- git clone git://github.com/jasonsoso/jason-blog.git

## 运行步骤： ##
- 导入mysql脚本（[JasonBlog 's sql](https://github.com/jasonsoso/jason-blog/blob/master/src/main/resources/META-INF/sql/jason-blog-security.sql "JasonBlog 's sql")）
- cd jason-blog 进入项目根路径
- mvn compile 编译
- mvn jetty:run 中间件jetty启动
