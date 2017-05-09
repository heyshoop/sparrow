<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<link rel="stylesheet" href="${ctxStatic}/assets/css/bootstrap.min.css"/>
<link rel="stylesheet" href="${ctxStatic}/assets/css/bootstrap-responsive.min.css"/>
<link rel="stylesheet" href="${ctxStatic}/assets/css/matrix-style.css"/>
<link rel="stylesheet" href="${ctxStatic}/assets/css/matrix-media.css"/>
<script src="${ctxStatic}/assets/js/select2.min.js"></script>
<script src="${ctxStatic}/assets/js/jquery.dataTables.min.js"></script>
<script src="${ctxStatic}/assets/js/jquery.uniform.js"></script>
<script src="${ctxStatic}/assets/js/matrix.tables.js"></script>
<html>
<head>
    <title>用户管理</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#btnExport").click(function () {
                top.$.jBox.confirm("确认要导出用户数据吗？", "系统提示", function (v, h, f) {
                    if (v == "ok") {
                        $("#searchForm").attr("action", "${ctx}/sys/user/export");
                        $("#searchForm").submit();
                    }
                }, {buttonsFocus: 1});
                top.$('.jbox-body .jbox-icon').css('top', '55px');
            });
            $("#btnImport").click(function () {
                $.jBox($("#importBox").html(), {
                    title: "导入数据", buttons: {"关闭": true},
                    bottomText: "导入文件不能超过5M，仅允许导入“xls”或“xlsx”格式文件！"
                });
            });
        });
        function page(n, s) {
            if (n) $("#pageNo").val(n);
            if (s) $("#pageSize").val(s);
            $("#searchForm").attr("action", "${ctx}/sys/user/list");
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<div id="importBox" class="hide">
    <form id="importForm" action="${ctx}/sys/user/import" method="post" enctype="multipart/form-data"
          class="form-search" style="padding-left:20px;text-align:center;" onsubmit="loading('正在导入，请稍等...');"><br/>
        <input id="uploadFile" name="file" type="file" style="width:330px"/><br/><br/>　　
        <input id="btnImportSubmit" class="btn btn-primary" type="submit" value="   导    入   "/>
        <a href="${ctx}/sys/user/import/template">下载模板</a>
    </form>
</div>
<div id="content" class="left" id="left" style="margin-left:0px;">
    <div class="row-fluid">
        <!-- begin col-12 -->
        <div class="span12">
            <!-- begin panel -->
            <div class="widget-box" style="margin-top: 10px;">
                <div class="widget-title"><span class="icon"><i class="icon-th"></i></span>
                    <h5>人员列表</h5>
                </div>
                <div class="widget-content nopadding">
                    <table class="table table-bordered data-table">
                        <thead>
                        <tr>
                            <th id="thlocation">归属公司</th>
                            <th id="thlocation">归属部门</th>
                            <th class="sort-column login_name" id="thlocation">登录名</th>
                            <th class="sort-column name" id="thlocation">姓名</th>
                            <th id="thlocation">电话</th>
                            <th id="thlocation">手机</th>
                            <shiro:hasPermission name="sys:user:edit">
                                <th id="thlocation">操作</th>
                            </shiro:hasPermission>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${page.list}" var="user">
                            <tr>
                                <td class="center">${user.company.name}</td>
                                <td>${user.office.name}</td>
                                <td><a href="${ctx}/sys/user/form?id=${user.id}">${user.loginName}</a></td>
                                <td>${user.name}</td>
                                <td>${user.phone}</td>
                                <td>${user.mobile}</td>
                                    <%--<td>${user.roleNames}</td> --%>
                                <shiro:hasPermission name="sys:user:edit">
                                    <td>
                                        <a href="${ctx}/sys/user/form?id=${user.id}">修改</a>
                                        <a href="${ctx}/sys/user/delete?id=${user.id}"
                                           onclick="return confirmx('确认要删除该用户吗？', this.href)">删除</a>
                                    </td>
                                </shiro:hasPermission>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>

<style>
    #thlocation > div {
        height: 20px;
    }

    #thlocation > div > span {
        height: 1px;
    }

    #left {
        height: 30%;
    }
</style>
</body>
</html>
