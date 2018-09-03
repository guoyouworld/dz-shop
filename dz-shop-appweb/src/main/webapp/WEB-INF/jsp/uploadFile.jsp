<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>upload file</title>
</head>
<body>
	<form action="filesUpload" method="post"  enctype="multipart/form-data">  
        <p>选择文件:<input type="file" name="files"></p>
        <p>选择文件:<input type="file" name="files"></p>
        <p><input type="submit" value="提交"></p>
    </form>  
</body>
</html>