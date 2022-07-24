<h2 align="center">DB-Encryption</h2>

* 来源：[ulisesbocchio](https://github.com/ulisesbocchio/jasypt-spring-boot)


## 介绍
参照[ulisesbocchio](https://github.com/ulisesbocchio/jasypt-spring-boot)
实现加密数据库的加密解密功能，将加密与解密实现分离，提高DB安全性

## 快速开始
### pom文件添加依赖
```xml
<dependency>
    <groupId>com.github.ulisesbocchio</groupId>
    <artifactId>jasypt-spring-boot-starter</artifactId>
    <version>3.0.4</version>
</dependency>
```
### 修改*DbEncryptionApplication*中的数据库账号密码
``` java
String account = "root"; #初始账号
String password = "123456"; #初始密码

encryptor.setPassword("Keington"); #自定义盐值
```
启动应用即可得到加密后的数据库账号密码
```
加密后账号：XT94R9PJxGoQ+k6ixpkDAg==
加密后密码：bj9DzMLKf9xHtSv5Demifg==
```
## 然后在需要加密数据库连接的的程序启动类中加入以下注解
```
@EnableEncryptableProperties
```
### 项目配置文件添加配置
```yaml
jasypt:
  encryptor:
    algorithm: PBEWithMD5AndDES
    password: Keington # 此处盐值需与上面的一致

spring:
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/DB_Encryption?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8
    username: ENC(XT94R9PJxGoQ+k6ixpkDAg==)  # 加密后的账号
    password: ENC(bj9DzMLKf9xHtSv5Demifg==)  # 加密后的密码
```
最后启动项目即可

## 鸣谢
感谢[JetBrain](https://www.jetbrains.com/)提供的IntelliJ IDEA授权License。

感谢[ulisesbocchio](https://github.com/ulisesbocchio/jasypt-spring-boot)提供的加密依赖。

## 联系我
如有问题请在issues提问，会不定期解答，或者也可以发送[邮件](mailto:keington@outlook.com)

## LICENSE & Copyright
[MIT License](https://github.com/keington/DB-Encryption/blob/f729e5208051dce53a66c94364f1efa8c29d70ec/LICENSE)

Copyright (c) 2021-2022 许怀安
