### 数据库准备
数据库名称：dz-shop<br>
dz-shop目录下的_sql目录下的dz-shop.sql文件导入数据库

### 组织结构图
dz-shop --父工程<br>
 ┝━dz-shop-application   --业务接口工程<br>
 ┝━dz-shop-application-impl --业务接口实现工程<br>
 ┝━dz-shop-appweb --PC端应用工程<br>

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
