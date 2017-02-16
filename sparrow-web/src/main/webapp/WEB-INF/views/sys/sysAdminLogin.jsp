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

    <!-- ================== BEGIN BASE CSS STYLE ================== -->
    <link href="${ctxStatic}/assets/plugins/jquery-ui/themes/base/minified/jquery-ui.min.css" rel="stylesheet" />
    <link href="${ctxStatic}/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${ctxStatic}/assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <link href="${ctxStatic}/assets/css/animate.min.css" rel="stylesheet" />
    <link href="${ctxStatic}/assets/css/style.min.css" rel="stylesheet" />
    <link href="${ctxStatic}/assets/css/style-responsive.min.css" rel="stylesheet" />
    <link href="${ctxStatic}/assets/css/theme/default.css" rel="stylesheet" id="theme" />
    <!-- ================== END BASE CSS STYLE ================== -->

    <!-- ================== BEGIN BASE JS ================== -->
    <script src="${ctxStatic}/assets/plugins/pace/pace.min.js"></script>
    <!-- ================== END BASE JS ================== -->

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

<%--    <ul class="login-bg-list clearfix">
        <li class="active"><a href="#" data-click="change-bg"><img src="${ctxStatic}/assets/img/login-bg/bg-1.jpg" alt="" /></a></li>
        <li><a href="#" data-click="change-bg"><img src="${ctxStatic}/assets/img/login-bg/bg-2.jpg" alt="" /></a></li>
        <li><a href="#" data-click="change-bg"><img src="${ctxStatic}/assets/img/login-bg/bg-3.jpg" alt="" /></a></li>
        <li><a href="#" data-click="change-bg"><img src="${ctxStatic}/assets/img/login-bg/bg-4.jpg" alt="" /></a></li>
        <li><a href="#" data-click="change-bg"><img src="${ctxStatic}/assets/img/login-bg/bg-5.jpg" alt="" /></a></li>
        <li><a href="#" data-click="change-bg"><img src="${ctxStatic}/assets/img/login-bg/bg-6.jpg" alt="" /></a></li>
    </ul>

    <!-- begin theme-panel -->
    <div class="theme-panel">
        <a href="javascript:;" data-click="theme-panel-expand" class="theme-collapse-btn"><i class="fa fa-cog"></i></a>
        <div class="theme-panel-content">
            <h5 class="m-t-0">Color Theme</h5>
            <ul class="theme-list clearfix">
                <li class="active"><a href="javascript:;" class="bg-green" data-theme="default" data-click="theme-selector" data-toggle="tooltip" data-trigger="hover" data-container="body" data-title="Default">&nbsp;</a></li>
                <li><a href="javascript:;" class="bg-red" data-theme="red" data-click="theme-selector" data-toggle="tooltip" data-trigger="hover" data-container="body" data-title="Red">&nbsp;</a></li>
                <li><a href="javascript:;" class="bg-blue" data-theme="blue" data-click="theme-selector" data-toggle="tooltip" data-trigger="hover" data-container="body" data-title="Blue">&nbsp;</a></li>
                <li><a href="javascript:;" class="bg-purple" data-theme="purple" data-click="theme-selector" data-toggle="tooltip" data-trigger="hover" data-container="body" data-title="Purple">&nbsp;</a></li>
                <li><a href="javascript:;" class="bg-orange" data-theme="orange" data-click="theme-selector" data-toggle="tooltip" data-trigger="hover" data-container="body" data-title="Orange">&nbsp;</a></li>
                <li><a href="javascript:;" class="bg-black" data-theme="black" data-click="theme-selector" data-toggle="tooltip" data-trigger="hover" data-container="body" data-title="Black">&nbsp;</a></li>
            </ul>
            <div class="divider"></div>
            <div class="row m-t-10">
                <div class="col-md-5 control-label double-line">Header Styling</div>
                <div class="col-md-7">
                    <select name="header-styling" class="form-control input-sm">
                        <option value="1">default</option>
                        <option value="2">inverse</option>
                    </select>
                </div>
            </div>
            <div class="row m-t-10">
                <div class="col-md-5 control-label">Header</div>
                <div class="col-md-7">
                    <select name="header-fixed" class="form-control input-sm">
                        <option value="1">fixed</option>
                        <option value="2">default</option>
                    </select>
                </div>
            </div>
            <div class="row m-t-10">
                <div class="col-md-5 control-label double-line">Sidebar Styling</div>
                <div class="col-md-7">
                    <select name="sidebar-styling" class="form-control input-sm">
                        <option value="1">default</option>
                        <option value="2">grid</option>
                    </select>
                </div>
            </div>
            <div class="row m-t-10">
                <div class="col-md-5 control-label">Sidebar</div>
                <div class="col-md-7">
                    <select name="sidebar-fixed" class="form-control input-sm">
                        <option value="1">fixed</option>
                        <option value="2">default</option>
                    </select>
                </div>
            </div>
            <div class="row m-t-10">
                <div class="col-md-5 control-label double-line">Sidebar Gradient</div>
                <div class="col-md-7">
                    <select name="content-gradient" class="form-control input-sm">
                        <option value="1">disabled</option>
                        <option value="2">enabled</option>
                    </select>
                </div>
            </div>
            <div class="row m-t-10">
                <div class="col-md-5 control-label double-line">Content Styling</div>
                <div class="col-md-7">
                    <select name="content-styling" class="form-control input-sm">
                        <option value="1">default</option>
                        <option value="2">black</option>
                    </select>
                </div>
            </div>
            <div class="row m-t-10">
                <div class="col-md-12">
                    <a href="#" class="btn btn-inverse btn-block btn-sm" data-click="reset-local-storage"><i class="fa fa-refresh m-r-3"></i> Reset Local Storage</a>
                </div>
            </div>
        </div>
    </div>
    <!-- end theme-panel -->--%>
</div>
<!-- end page container -->

<!-- ================== BEGIN BASE JS ================== -->
<script src="${ctxStatic}/assets/plugins/jquery/jquery-1.9.1.min.js"></script>
<script src="${ctxStatic}/assets/plugins/jquery/jquery-migrate-1.1.0.min.js"></script>
<script src="${ctxStatic}/assets/plugins/jquery-ui/ui/minified/jquery-ui.min.js"></script>
<script src="${ctxStatic}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>

<script src="${ctxStatic}/assets/plugins/jquery-hashchange/jquery.hashchange.min.js"></script>
<script src="${ctxStatic}/assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<!-- ================== END BASE JS ================== -->

<!-- ================== BEGIN PAGE LEVEL JS ================== -->
<script src="${ctxStatic}/assets/js/login.min.js"></script>
<script src="${ctxStatic}/assets/js/apps.min.js"></script>
<!-- ================== END PAGE LEVEL JS ================== -->

<script>
    $(document).ready(function() {
        App.init(ajax=true);
        Login.init();
    });
</script>
</body>
</html>
