<%@ page import="com.alibaba.fastjson.JSONObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<title>demo</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script>
    var root = "<%=basePath %>";
    var qq = "<%=request.getRequestURI() %>";
</script>
<link rel="stylesheet" href="<%=basePath %>plugin/bootstrap/css/bootstrap.min.css" >
<script src="<%=basePath %>plugin/jquery.js"></script>
<script src="<%=basePath %>plugin/bootstrap/js/bootstrap.min.js" ></script>
<script src="<%=basePath %>plugin/vue.js"></script>
<script src="<%=basePath %>js/main.js"></script>





