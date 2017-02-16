<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8" />
    <title>404 Error Page</title>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />

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
</head>
<body class="pace-top">
<!-- begin #page-loader -->
<div id="page-loader" class="fade in"><span class="spinner"></span></div>
<!-- end #page-loader -->

<!-- begin #page-container -->
<div id="page-container" class="fade">
    <!-- begin error -->
    <div class="error">
        <div class="error-code m-b-10">404 <i class="fa fa-warning"></i></div>
        <div class="error-content">
            <div class="error-message">您访问的页面不存在！</div>
            <div class="error-desc m-b-20">
                The page you're looking for doesn't exist. <br />
                Perhaps, there pages will help find what you're looking for.
            </div>
            <div>
                <a href="/" class="btn btn-success">返回首页</a>
            </div>
        </div>
    </div>
    <!-- end error -->

    <!-- begin scroll to top btn -->
    <a href="javascript:;" class="btn btn-icon btn-circle btn-success btn-scroll-to-top fade" data-click="scroll-top"><i class="fa fa-angle-up"></i></a>
    <!-- end scroll to top btn -->
</div>
<!-- end page container -->

<!-- ================== BEGIN BASE JS ================== -->
<script src="${ctxStatic}/assets/plugins/jquery/jquery-1.9.1.min.js"></script>
<script src="${ctxStatic}/assets/plugins/jquery/jquery-migrate-1.1.0.min.js"></script>
<script src="${ctxStatic}/assets/plugins/jquery-ui/ui/minified/jquery-ui.min.js"></script>
<script src="${ctxStatic}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>

<script src="${ctxStatic}/assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${ctxStatic}/assets/plugins/jquery-cookie/jquery.cookie.js"></script>
<!-- ================== END BASE JS ================== -->

<!-- ================== BEGIN PAGE LEVEL JS ================== -->
<script src="${ctxStatic}/assets/js/apps.min.js"></script>
<!-- ================== END PAGE LEVEL JS ================== -->

<script>
    $(document).ready(function() {
        App.init();
    });
</script>
</body>
</html>
