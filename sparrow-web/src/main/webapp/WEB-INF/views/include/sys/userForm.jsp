<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>用户修改页面</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="${ctxStatic}/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${ctxStatic}/assets/css/bootstrap-responsive.min.css"/>
    <link rel="stylesheet" href="${ctxStatic}/assets/css/matrix-style.css"/>
    <link rel="stylesheet" href="${ctxStatic}/assets/css/matrix-media.css"/>
</head>
<body>
<div id="content" style="margin-left:0px;">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span6">
                <div class="widget-box">
                    <div class="widget-title"><span class="icon"> <i class="icon-align-justify"></i> </span>
                        <h5>人员修改</h5>
                    </div>
                    <div class="widget-content nopadding">
                        <form action="${ctx}/sys/user/info" method="post" class="form-horizontal">
                            <div class="control-group">
                                <label class="control-label">归属公司 :</label>
                                <div class="controls">
                                    <input type="text" class="span11" value="${user.company}" name="company"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">归属部门 :</label>
                                <div class="controls">
                                    <input type="text" class="span11" value="${user.office}" name="office"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">工号：</label>
                                <div class="controls">
                                    <input type="text" class="span11" value="${user.no}" name="no"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">姓名：</label>
                                <div class="controls">
                                    <input type="text" class="span11" value="${user.name}" name="name"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">登录名：</label>
                                <div class="controls">
                                    <input type="text" class="span11" value="${user.loginName}" name="loginName"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">邮箱：</label>
                                <div class="controls">
                                    <input type="text" class="span11" value="${user.email}" name="email"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">电话： </label>
                                <div class="controls">
                                    <input type="text" class="span11" value="${user.phone}" name="phone"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">手机：</label>
                                <div class="controls">
                                    <input type="text" class="span11" value="${user.mobile}" name="mobile"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">是否允许登录：</label>
                                <div class="controls">
                                    <select name="loginFlag">
                                        <option value="0" <c:if test="${user.loginFlag == '0'}">selected</c:if>>是
                                        </option>
                                        <option value="1" <c:if test="${user.loginFlag == '1'}">selected</c:if>>否
                                        </option>
                                    </select>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">用户类型：</label>
                                <div class="controls">
                                    <select name="userType">
                                        <option value="0" <c:if test="${user.userType == '0'}">selected</c:if>>管理员
                                        </option>
                                        <option value="1" <c:if test="${user.userType == '1'}">selected</c:if>>普通员工
                                        </option>
                                    </select>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">用户角色：</label>
                                <div class="controls">
                                    <input type="checkbox" name="media" value="公司管理员"/>公司管理员
                                    <input type="checkbox" name="media" value="普通用户" style="margin-left: 3px;"/>普通用户
                                    <input type="checkbox" name="media" value="系统管理员" style="margin-left: 3px;"/>系统管理员
                                    <input type="checkbox" name="media" value="部门管理员" style="margin-left: 3px;"/>部门管理员
                                    <input type="hidden" value="${user.roleList}" id="meidaHidden">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">最后登陆日期：</label>
                                <div class="controls">
                                    <input type="text" class="span11"  value="<fmt:formatDate value='${user.loginDate}' pattern='yyyy-MM-dd  HH:mm'/>" name="loginDate" readonly="true"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">备注： </label>
                                <div class="controls">
                                    <textarea class="span11"></textarea>
                                </div>
                            </div>
                            <div class="form-actions">
                                <button type="submit" class="btn btn-success">修改</button>
                                <button type="reset" class="btn btn-success">重置</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(function () {
        window.onload = function () {
            var checkeds = $("#meidaHidden").val();
            var checkBoxAll = $("input[name='media']");
            for (var i = 0; i < checkeds.length; i++) {
                $.each(checkBoxAll, function (j, checkbox) {
                    var checkValue = $(checkbox).val();
                    if (checkeds[i].name == checkValue) {
                        $(checkbox).attr("checked", true);
                    }
                })
            }
        };
    });
</script>
</body>
</html>
