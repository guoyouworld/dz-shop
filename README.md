# dz-shop
![Gitter](https://badges.gitter.im/Join Chat.svg)

### 数据库准备
数据库名称：dz-shop<br>
dz-shop目录下的_sql目录下的dz-shop.sql文件导入数据库

### 组织结构图
dz-shop --父工程<br>
 ┝━dz-shop-application   --业务接口工程<br>
 ┝━dz-shop-application-impl --业务接口实现工程<br>
 ┝━dz-shop-appweb --PC端应用工程<br>
 ┝━dz-shop-wechat --微信小程序工程<br>

### 测试路径
http://localhost:8080/dz-shop-appweb/in

### appweb引用application
在`dz-shop-appweb`的`pom.xml`文件内加入下列代码：<br>

```
<dependency>
	<groupId>dz-shop</groupId>
	<artifactId>dz-shop-application</artifactId>
	<version>0.0.1-SNAPSHOT</version>
</dependency>
```
### 当前需求
1. 完成用户注册登陆模块<br>
      ┝━账号<手机号>注册<br>
      ┝━绑定手机号<br>
      ┝━微信授权登陆<br>

![login](https://user-images.githubusercontent.com/21979120/45273764-ae076c80-b4e6-11e8-9ee3-0214271924d7.png)

<br>
2. 首页展示
      
