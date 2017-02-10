<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%--
  Created by IntelliJ IDEA.
  User: Netuser
  Date: 2017/2/8
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML>
<html>
<head>
    <title>登录 - 麻雀虽小，五脏俱全</title>
</head>
<body>
<form action="/admin/login" method="post">
    <label for="username">登录名</label>
    <input type="text" id="username" name="username" value="${username}">
    <label for="password">密码</label>
    <input type="password" id="password" name="password">
    <c:if test="${isValidateCodeLogin}"><div class="validateCode">
        <label for="validateCode">验证码</label>
        <sys:validateCode name="validateCode" inputCssStyle="margin-bottom:0;"/>
    </div></c:if>
    <input type="submit" value="登 录"/>&nbsp;&nbsp;
    <label for="rememberMe" title="下次不需要再登录"><input type="checkbox" id="rememberMe" name="rememberMe" ${rememberMe ? 'checked' : ''}/> 记住我（公共场所慎用）</label>
</form>
</body>
</html>
