<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%--
  Created by IntelliJ IDEA.
  User: Netuser
  Date: 2017/2/8
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>管理中心</title>
</head>
<body>
登录成功：管理中心<br/>
当前用户：${fns:getUser().name}<br/>
邮箱地址：${fns:getUser().email}<br/>
<li><a href="${ctx}/logout" title="退出登录">退出登录</a></li>
</body>
</html>
