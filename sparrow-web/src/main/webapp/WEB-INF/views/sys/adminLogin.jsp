<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>��¼ - ��ȸ��С�������ȫ</title>
</head>
<body>
<form action="/admin/login" method="post">
    <label for="username">��¼��</label>
    <input type="text" id="username" name="username" value="${username}">
    <label for="password">����</label>
    <input type="password" id="password" name="password">
    <c:if test="${isValidateCodeLogin}"><div class="validateCode">
        <label for="validateCode">��֤��</label>
        <sys:validateCode name="validateCode" inputCssStyle="margin-bottom:0;"/>
    </div></c:if>
    <input type="submit" value="�� ¼"/>&nbsp;&nbsp;
    <label for="rememberMe" title="�´β���Ҫ�ٵ�¼"><input type="checkbox" id="rememberMe" name="rememberMe" ${rememberMe ? 'checked' : ''}/> ��ס�ң������������ã�</label>
</form>
</body>
</html>
