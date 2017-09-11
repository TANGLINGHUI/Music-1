<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"		prefix="c" 		%>
    <%
    		String path =  request.getContextPath();
    		String basePath = request.getScheme()+"://"+request.getServerName()
    											+":"+request.getServerPort()+path+"/";
    		//out.print(path);
    		//out.print(basePath);
    		
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath %>">
    <title></title>
    <meta charset="UTF-8">
    <!-- servlet跳转到jsp -->
    <!-- 请求的发起方：servlet
    		music_project/sys/servlet 
    		绝对路径定位css/js
    		request请求对象中：get路径
    		
    		base:将这个页面的路径定位到basePath
    		相对路径相对的是basePath：music
    		-->
    		<%
    				request.getContextPath();
    		%>
    <link rel="stylesheet" type="text/css" href="sys/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="sys/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="sys/Css/style.css" />
    <script type="text/javascript" src="sys/Js/jquery.js"></script>
    <script type="text/javascript" src="sys/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="sys/Js/bootstrap.js"></script>
    <script type="text/javascript" src="sys/Js/ckform.js"></script>
    <script type="text/javascript" src="sys/Js/common.js"></script>

 

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
</head>
<body>
<form class="form-inline definewidth m20" action="sys/UserServlet" method="get">    
<input  type="hidden"   name="type"  value="search"		/>
    用户名称：
    <input type="text" name="username" id="username"class="abc input-default" placeholder="" value="">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary " >查询</button>&nbsp;&nbsp; <button type="button" class="btn btn-success" id="addnew">新增用户</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>用户id</th>
        <th>用户名称</th>
        <th>邮件地址</th>
        <th>最后登录时间</th>
        <th>操作</th>
    </tr>
    </thead>
    
    <!-- list 中有多少个user对象，就会有多少行-->
    <%--   <%
    List<User> list = (List<User>)request.getAttribute("list");
    for(User user:list){
    %> --%>
  <c:forEach items="${list }"		var="user"		>
	     <tr>
            <td>${user.user_id }</td>
            <td>${user.user_name }</td>
            <td>${user.user_mail }</td>
            <td><%=new Date() %></td>
            <td>
                <a href="sys/UserServlet?id=${user.user_id}&type=findById">编辑</a>    
                <a href="sys/UserServlet?id=${user.user_id}&type=del">删除</a>            
            </td>
        </tr>	
        </c:forEach>
<%--         <%} %> --%>
        <!--  -->
</table>
</body>
</html>
<script>
    $(function () {
        

		$('#addnew').click(function(){

				window.location.href="User/add.jsp";
		 });


    });

	function del(id)
	{
		
		
		if(confirm("确定要删除吗？"))
		{
		
			var url = "index.html";
			
			window.location.href=url;		
		
		}
	
	
	
	
	}
</script>