<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <jsp:include page="head.jsp"></jsp:include>
    <link href="css/taskList.css" rel="stylesheet">
</head>
<body>
<div id="app">
    <div id="loading" class="loading" >
        <div class="spinner">
            <div class="rect1"></div>
            <div class="rect2"></div>
            <div class="rect3"></div>
            <div class="rect4"></div>
            <div class="rect5"></div>
        </div>
    </div>
    <div class="alert alert-danger alert_message" role="alert">
        <button type="button" class="close" onclick="close_message()"><span aria-hidden="true">&times;</span></button>
        <strong></strong>
    </div>
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Project name</a>
            </div>

        </div>
    </nav>

    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-3 col-md-2 sidebar">
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav nav-sidebar">
                        <li class="active"><a href="#">任务调度</a></li>
                        <li><a href="#">参数配置</a></li>
                        <li><a href="<%=basePath%>/page/sqlAnalysis.jsp">参数配置</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <jsp:include page="page/taskList.jsp" flush="true"></jsp:include>
            </div>
        </div>
    </div>
</div>
</body>
</html>