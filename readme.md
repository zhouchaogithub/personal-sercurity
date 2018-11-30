**一、项目结构
personal-sercurity：主模块
personal-sercurity-core:核心业务逻辑
personal-sercurity-browser:浏览器安全特定代码
personal-sercurity-app：app相关特定代码
personal-sercurity-demo：样例程序**
**二、记住我建表语句
create table persistent_logins (
    username varchar(64) not null, 
    series varchar(64) primary key, 
    token varchar(64) not null, 
    last_used timestamp not null
)**