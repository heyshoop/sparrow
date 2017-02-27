<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld" %>
<c:set var="ctx" value="${pageContext.request.contextPath}${fns:getAdminPath()}"/>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static"/>

<!-- ================== BEGIN BASE CSS STYLE ================== -->
<link href="${ctxStatic}/assets/plugins/jquery-ui/themes/base/minified/jquery-ui.min.css" rel="stylesheet" />
<link href="${ctxStatic}/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="${ctxStatic}/assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
<link href="${ctxStatic}/assets/css/animate.min.css" rel="stylesheet" />
<link href="${ctxStatic}/assets/css/style.min.css" rel="stylesheet" />
<link href="${ctxStatic}/assets/css/style-responsive.min.css" rel="stylesheet" />
<link href="${ctxStatic}/assets/css/theme/default.css" rel="stylesheet" id="theme" />
<!-- ================== END BASE CSS STYLE ================== -->

<!-- ================== BEGIN PAGE LEVEL STYLE ================== -->
<link href="${ctxStatic}/assets/plugins/bootstrap-datepicker/css/bootstrap-datepicker.css" rel="stylesheet" />
<link href="${ctxStatic}/assets/plugins/gritter/css/jquery.gritter.css" rel="stylesheet" />
<link href="${ctxStatic}/assets/plugins/jquery-jbox/2.3/Skins/Bootstrap/jbox.min.css" rel="stylesheet" />
<!-- ================== END PAGE LEVEL STYLE ================== -->

<!-- ================== BEGIN BASE JS ================== -->
<script src="${ctxStatic}/assets/plugins/pace/pace.min.js"></script>
<!-- ================== END BASE JS ================== -->

<!-- ================== BEGIN BASE JS ================== -->
<script src="${ctxStatic}/assets/plugins/jquery/jquery-1.9.1.min.js"></script>
<script src="${ctxStatic}/assets/plugins/jquery/jquery-migrate-1.1.0.min.js"></script>
<script src="${ctxStatic}/assets/plugins/jquery-ui/ui/minified/jquery-ui.min.js"></script>
<script src="${ctxStatic}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${ctxStatic}/assets/plugins/jquery-jbox/2.3/jquery.jBox-2.3.min.js" ></script>


<script src="${ctxStatic}/assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${ctxStatic}/assets/plugins/jquery-cookie/jquery.cookie.js"></script>
<!-- ================== END BASE JS ================== -->

<!-- ================== BEGIN PAGE LEVEL JS ================== -->
<script src="${ctxStatic}/assets/js/apps.min.js"></script>
<!-- ================== END PAGE LEVEL JS ================== -->