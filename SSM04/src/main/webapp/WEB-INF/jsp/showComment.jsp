<%--
  Created by IntelliJ IDEA.
  User: 11485
  Date: 2019/6/28
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1 style="text-align: center">新闻界面</h1>
    <form  style="text-align: center">

        <input type="button" onclick="location.href='/news/show'" value="返回新闻页面">
    </form>

<table  align="center" cellpadding="15" cellspacing="0" border="1">
    <tr>

        <td>编号</td>
        <td>新闻编号</td>
        <td>评论内容</td>
        <td>作者</td>
        <td>发布时间</td>
        <%--<td><input type="button" id="batchDel" value="批量删除">| <input type="button" onclick="location.href='/company/add1'" value="新增"></td>--%>
    </tr>
    <c:if test="${not empty comments}">
        <c:forEach var="comment" items="${comments}">
            <tr>
                <td>${comment.id}</td>
                <td>${comment.newsid}</td>
                <td>${comment.content}</td>
                <td>${comment.author}</td>

                <td><fmt:formatDate value="${comment.createdate}"></fmt:formatDate></td>


            </tr>
        </c:forEach>
    </c:if>
</table>
<%--3.分页--%>

<table align="center" cellpadding="10" cellspacing="10" border="1">
    <tr>
        <td><a href="javascript:goPage(1)">首页</a></td>
        <td><a href="javascript:goPage(${page.currPage-1})">上一页</a></td>
        <c:forEach var="i" begin="1" end="${page.totalPage}">
            <td><a href="javascript:goPage(${i})">${i}</a></td>
        </c:forEach>
        <td><a href="javascript:goPage(${page.currPage+1})">下一页</a></td>
        <td><a href="javascript:toPage()">跳转</a>到第<input size="2" type="text" value="${page.currPage}" id="go">页</td>
        <td><a href="javascript:goPage(${page.totalPage})">尾页</a></td>
    </tr>
</table>

<script>
    /*批量删除*/
    /* $("#batchDel").click(function () {
         //1.获取到选中的ids  2. ids数组 送到后台
         var ids=new Array();
         $(".checkNow:checked").each(function () {
             var id=$(this).val()
             ids.push(id);
         })
         $.post("/company2/batchDel",{ids:ids.toString()},function (data) {
             location.href="/";
         });
     })*/

    /*全选*/
    /* $("#checkAll").click(function () {
         if ($(this).prop("checked")){
             $(".checkNow").prop("checked",true)
         }else {
             $(".checkNow").prop("checked",false)
         }
     })*/



    function goPage(page) {
        var total=${page.totalPage};

        if(page>total){
            page=total;
        }
        if(page<1){
            page=1;
        }

        $("#pageNum").val(page);
        $("#myForm").submit()
    }
    function toPage() {
        var page=$("#go").val();
        goPage(page)
    }
</script>
</body>
</html>
