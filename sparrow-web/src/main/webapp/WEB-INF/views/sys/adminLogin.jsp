<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
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
    <title>登录 ${fns:getConfig("title")}</title>

    <style type="text/css">
        .alert{position:relative;width:300px;margin:0 auto;*padding-bottom:0px;}
        label.error{background:none;width:300px;font-weight:normal;color:inherit;margin:0;font-size: 20px}
        .input-label{font-size:18px;line-height:23px;color:#999;}
        .mid{vertical-align:middle;height: 23px;margin-top: -3px;}
    </style>

</head>
<div>
    <div id="messageBox" class="alert alert-error ${empty message ? 'hide' : ''}">
        <label id="loginError">${message}</label>
    </div>
</div>
<br>
<body class="pace-top">
<!-- begin #page-loader -->
<div id="page-loader" class="fade in"><span class="spinner"></span></div>
<!-- end #page-loader -->

<div class="login-cover">
    <div class="login-cover-image"><img src="${ctxStatic}/assets/img/login-bg/bg-1.jpg" data-id="login-cover-image" alt="" /></div>
    <div class="login-cover-bg"></div>
</div>
<!-- begin #page-container -->
<div id="page-container" class="fade">
    <!-- begin login -->
    <div class="login login-v2" data-pageload-addclass="animated fadeIn">
        <!-- begin brand -->
        <div class="login-header">
            <div class="brand">
                <span class="logo"></span> Sparrow Admin
                <div class="alert alert-error ${empty message ? 'hide' : ''}"><button data-dismiss="alert" class="close">×</button>
                    <label class="error">${message}</label>
                </div>
            </div>
            <div class="icon">
                <i class="fa fa-sign-in"></i>
            </div>
        </div>
        <!-- end brand -->
        <div class="login-content">
            <form action="${ctx}/login" method="POST" class="margin-bottom-0">
                <div class="form-group m-b-20">
                    <input type="text" class="form-control input-lg" name="username" value="${username}" placeholder="账号" required />
                </div>
                <div class="form-group m-b-20">
                    <input type="password" class="form-control input-lg" name="password" placeholder="密码" required />
                </div>
                <c:if test="${isValidateCodeLogin}">
                    <div class="validateCode">
                        <label class="input-label mid" for="validateCode">验证码</label>
                        <sys:validateCode name="validateCode" inputCssStyle="margin-bottom:0;width:80px;height:23px;"/>
                    </div>
                </c:if>
                <div class="checkbox m-b-20">
                    <label title="下次不需要再登录">
                        <input type="checkbox" /> 记住我（公共场所慎用）
                    </label>
                </div>
                <div class="login-buttons">
                    <button type="submit" class="btn btn-success btn-block btn-lg">登录</button>
                </div>
            </form>
        </div>
    </div>
    <!-- end login -->

</div>
<!-- end page container -->

<script>
    $(document).ready(function() {
        App.init(ajax=true);
        Login.init();
    });
</script>
</body>
</html>
