<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld" %>
<c:set var="ctx" value="${pageContext.request.contextPath}${fns:getAdminPath()}"/>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static"/>
<%--==================================基础JS库========================================--%>
<script src="${ctxStatic}/assets/plugins/jquery/jquery-1.9.1.min.js"></script>
<script src="${ctxStatic}/assets/plugins/jquery/jquery-migrate-1.1.0.min.js"></script>
<script src="${ctxStatic}/assets/plugins/jquery-ui/ui/minified/jquery-ui.min.js"></script>
<script src="${ctxStatic}/assets/plugins/jquery-hashchange/jquery.hashchange.min.js"></script>
<script src="${ctxStatic}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${ctxStatic}/assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${ctxStatic}/assets/plugins/jquery-cookie/jquery.cookie.js"></script>

<script src="${ctxStatic}/assets/js/excanvas.min.js"></script>
<script src="${ctxStatic}/assets/js/jquery.ui.custom.js"></script>
<script src="${ctxStatic}/assets/js/bootstrap.min.js"></script>
<script src="${ctxStatic}/assets/js/jquery.flot.min.js"></script>
<script src="${ctxStatic}/assets/js/jquery.flot.resize.min.js"></script>
<script src="${ctxStatic}/assets/js/jquery.gritter.min.js"></script>
<script src="${ctxStatic}/assets/js/jquery.peity.min.js"></script>
<script src="${ctxStatic}/assets/js/jquery.uniform.js"></script>
<script src="${ctxStatic}/assets/js/jquery.validate.min.js"></script>
<script src="${ctxStatic}/assets/js/jquery.wizard.js"></script>
<script src="${ctxStatic}/assets/js/jquery.dataTables.min.js"></script>
<script src="${ctxStatic}/assets/js/fullcalendar.min.js"></script>
<script src="${ctxStatic}/assets/js/select2.min.js"></script>



<%--==================================基础CSS库=======================================--%>
<link href="${ctxStatic}/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="${ctxStatic}/assets/plugins/jquery-ui/themes/base/minified/jquery-ui.min.css" rel="stylesheet" />
<link href="${ctxStatic}/assets/plugins/bootstrap-datepicker/css/bootstrap-datepicker.css" rel="stylesheet" />
<link href="${ctxStatic}/assets/plugins/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href="${ctxStatic}/assets/css/bootstrap-responsive.min.css" rel="stylesheet" />
<link href="${ctxStatic}/assets/css/fullcalendar.css" rel="stylesheet" />
<link href="${ctxStatic}/assets/css/matrix-style.css" rel="stylesheet" />
<link href="${ctxStatic}/assets/css/matrix-media.css" rel="stylesheet" />
<link href="${ctxStatic}/assets/css/jquery.gritter.css" rel="stylesheet" />










