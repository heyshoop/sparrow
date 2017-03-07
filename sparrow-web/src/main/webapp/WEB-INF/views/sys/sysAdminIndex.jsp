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
    <title>管理中心 ${fns:getConfig("title")}</title>

</head>
<body>
    <!-- begin #page-loader -->
    <div id="page-loader" class="fade in"><span class="spinner"></span></div>
    <!-- end #page-loader -->

    <!-- begin #page-container -->
    <div id="page-container" class="fade page-sidebar-fixed page-header-fixed">
        <!-- begin #header -->
        <div id="header" class="header navbar navbar-default navbar-fixed-top">
            <!-- begin container-fluid -->
            <div class="container-fluid">
                <!-- begin mobile sidebar expand / collapse button -->
                <div class="navbar-header">
                    <a href="index.html" class="navbar-brand"><span class="navbar-logo"></span> Sparrow Admin</a>
                    <button type="button" class="navbar-toggle" data-click="sidebar-toggled">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <!-- end mobile sidebar expand / collapse button -->

                <!-- begin header navigation right -->
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <form class="navbar-form full-width">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="输入关键词" />
                                <button type="submit" class="btn btn-search"><i class="fa fa-search"></i></button>
                            </div>
                        </form>
                    </li>
                    <li class="dropdown">
                        <a href="javascript:;" data-toggle="dropdown" class="dropdown-toggle f-s-14">
                            <i class="fa fa-bell-o"></i>
                            <span class="label">1</span>
                        </a>
                        <ul class="dropdown-menu media-list pull-right animated fadeInDown">
                            <li class="dropdown-header">消息提醒 (1)</li>
                            <li class="media">
                                <a href="javascript:;">
                                    <div class="media-left"><i class="fa fa-bug media-object bg-red"></i></div>
                                    <div class="media-body">
                                        <h6 class="media-heading">Server Error Reports</h6>
                                        <div class="text-muted f-s-11">3 minutes ago</div>
                                    </div>
                                </a>
                            </li>
                            <li class="dropdown-footer text-center">
                                <a href="javascript:;">更多</a>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown navbar-user">
                        <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="${ctxStatic}/assets/img/user-1.jpg" alt="" />
                            <span class="hidden-xs">${fns:getUser().name}</span> <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu animated fadeInLeft">
                            <li class="arrow"></li>
                            <li><a href="${ctx}/sys/user/info" target="mainFrame">编辑资料</a></li>
                            <li><a href="javascript:;" target="mainFrame">设置</a></li>
                            <li class="divider"></li>
                            <li><a href="${ctx}/logout">退出登录</a></li>
                        </ul>
                    </li>
                </ul>
                <!-- end header navigation right -->
            </div>
            <!-- end container-fluid -->
        </div>
        <!-- end #header -->

        <!-- begin #sidebar -->
        <div id="sidebar" class="sidebar">
            <!-- begin sidebar scrollbar -->
            <div data-scrollbar="true" data-height="100%">
                <!-- begin sidebar user -->
                <ul class="nav">
                    <li class="nav-profile">
                        <div class="image">
                            <a href="javascript:;"><img src="${ctxStatic}/assets/img/user-1.jpg" alt="" /></a>
                        </div>
                        <div class="info">
                            ${fns:getUser().name}
                            <small>${fns:getUser().email}</small>
                        </div>
                    </li>
                </ul>
                <!-- end sidebar user -->
                <!-- begin sidebar nav -->
                <ul class="nav">
                    <li class="nav-header">控制面板</li>
                    <li class="has-sub active">
                        <a href="javascript:;">
                            <b class="caret pull-right"></b>
                            <i class="fa fa-laptop"></i>
                            <span>用户信息</span>
                        </a>
                        <ul class="sub-menu">
                            <li><a href="${ctx}/sys/user/info" target="mainFrame">个人资料</a></li>
                            <li><a href="${ctx}/sys/user/list" target="mainFrame">人员列表</a></li>
                            <%--<li><a href="${ctx}/sys/user/modifyPwd" target="mainFrame">修改密码</a></li>--%>
                        </ul>
                    </li>
                    <li class="has-sub">
                        <a href="javascript:;">
                            <span class="badge pull-right">10</span>
                            <i class="fa fa-inbox"></i>
                            <span>Email</span>
                        </a>
                        <ul class="sub-menu">
                            <li><a href="email_inbox.html">Inbox v1</a></li>
                            <li><a href="email_inbox_v2.html">Inbox v2</a></li>
                            <li><a href="email_compose.html">Compose</a></li>
                            <li><a href="email_detail.html">Detail</a></li>
                        </ul>
                    </li>
                    <!-- begin sidebar minify button -->
                    <li><a class="sidebar-minify-btn" data-click="sidebar-minify"><i class="fa fa-angle-double-left"></i></a></li>
                    <!-- end sidebar minify button -->
                </ul>
                <!-- end sidebar nav -->
            </div>
            <!-- end sidebar scrollbar -->
        </div>
        <div class="sidebar-bg"></div>
        <!-- end #sidebar -->

        <!-- begin #content -->
        <div id="content" class="content">
            <iframe src="" id="mainFrame" name="mainFrame" style="width: 85%;height: 90%;z-index: 100;position: absolute;" frameborder="0"></iframe>
        </div>
        <!-- end #content -->
    </div>
    <!-- end page container -->
    <script>
        $(document).ready(function() {
            App.init();
            Dashboard.init();
        });
    </script>
</body>
</html>
