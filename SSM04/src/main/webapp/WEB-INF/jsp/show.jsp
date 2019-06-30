<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<%--1.条件查询--%>
<form  id="myForm" action="/news/show" method="post" style="text-align: center">
    新闻标题：<input type="text" name="name" value="${page.name}">

    <input type="hidden" id="pageNum" name="currPage" value="1">
    <input type="submit" value="搜索">
</form>
<%--2.数据展示--%>
<table  align="center" cellpadding="15" cellspacing="0" border="1" bgcolor="#48d1cc">
    <tr>

        <td>编号</td>
        <td>新闻标题</td>
        <td>新闻摘要</td>
        <td>作者</td>
        <td>发布时间</td>
        <%--<td><input type="button" id="batchDel" value="批量删除">| <input type="button" onclick="location.href='/company/add1'" value="新增"></td>--%>
    </tr>
    <c:if test="${not empty news1}">
        <c:forEach var="news1" items="${news1}" varStatus="vs">
            <tr <c:if test="${vs.index%2==0}">bgcolor="#ffe4c4" </c:if>>

                <td>${news1.id}</td>
                <td>${news1.title}</td>
                <td>${news1.summary}</td>
                <td>${news1.author}</td>

                <td><fmt:formatDate value="${news1.createdate}"></fmt:formatDate></td>



                <td>
                    <a href="/news/lookComment/${news1.id}">查看评论</a>|
                    <a href="/news/toComment1/${news1.id}">评论</a>|
                    <a onclick="return confirm('确定删除新闻及其所有评论吗？')" href="/news/deleteById/${news1.id}" id="one">删除</a>
                </td>
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

<!--js部分-->
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

