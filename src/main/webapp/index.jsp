<%@ page contentType="text/html;charset=UTF-8" language="java" import="bean.StudentBean" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--转换时间格式--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>学生管理页面</title>
    <script type="text/javascript" src="js/jquery-3.5.1.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <script type="text/javascript" src="js/index.js"></script>
    <script type="text/javascript" src="js/pageCount.js"></script>
<%--    <script>--%>
<%--        $(function () {--%>
<%--            allStudentInfo();--%>
<%--        });--%>
<%--    </script>--%>
</head>
<body>
<div class="div_total">
    <div class="div_student_title"><h1>学生管理</h1></div>
    <div>
        <!--列表详细信息-->
        <div class="div_middle" id="div_middle">
            <p>
                <input type="button" onclick="addStudent()" value="新增" style="width: 100px">
            <div id="add_student" class="div_add_student"></div>
            </p>
            <table id="students" class="tab-list" border="1">
                <thead>
                <tr>
                    <th>学生ID</th>
                    <th>姓名</th>
                    <th>出生日期</th>
                    <th>平均分</th>
                    <th>备注</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="students_tbody">
                <c:forEach var="list" items="${studentList}">
                    <tr>
                        <td name="td_student_id"><c:out value="${list.studentId}" ></c:out></td>
                        <td name='td_student_name'><c:out value="${list.studentName}"></c:out></td>
<%--                        设置日期格式，date类型转换为string类型--%>
                        <td name='td_student_birthday'><fmt:formatDate value="${list.birthday}" type="date" pattern="yyyy年MM月dd日"/></td>
                        <td name='td_student_avgScore'><c:out value="${list.avgScore}"></c:out></td>
                        <td name='td_student_description'><c:out value="${list.description}"></c:out></td>
                        <td name='td_student_update'><input type="button" onclick="updateStudent(this)" value="修改">&nbsp;&nbsp;
                            <input type="button" onclick="deleteStudent(this)" value="删除"></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <!--    分页布局-->
            <br/>
            <div class="paging">
                <form action="/pageSelectStudent" method="post">
                <table>
                    <tr class="page-font">
                        <td><a href="#" name="firstPage" id="firstPage">首页</a></td>
                        <td>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#" name="beforePage" id="beforePage">上一页</a></td>
                        <td>&nbsp;&nbsp;|&nbsp;&nbsp;第<input type="button" name="currentPage" value="${currentPage}" id="currentPage" readonly="readonly">页</td>
                        <td>&nbsp;&nbsp;|&nbsp;&nbsp;每页<input type="button" value="3" readonly="readonly">条</td>
                        <td>&nbsp;&nbsp;|&nbsp;&nbsp;共<input type="button" name="totalPage" value="${countStudent}" id="totalPage" readonly="readonly">页</td>
                        <td>&nbsp;&nbsp;|&nbsp;&nbsp;<input type="text" style="width: 20px">&nbsp;<a href="#" id="jumpPage">跳转</a></td>
                        <td>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#" name="nextPage" id="nextPage">下一页</a></td>
                        <td>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#" name="lastPage" id="lastPage">尾页</a></td>
                    </tr>
                </table>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>