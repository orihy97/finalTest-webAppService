<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Member 목록 전체 조회</h1>
<table>
    <tr>
        <th>선수코드</th>
        <th>선수명</th>
        <th>생년월일</th>
        <th>종족코드</th>
        <th>상세정보</th>
        <th>연락처</th>
        <th>소속팀코드</th>
        <th>활동상태</th>

    </tr>
    <c:forEach items="${ requestScope.memList }" var="mem">
        <tr>
            <td>${ mem.memberCode }</td>
            <td>${ mem.memberName }</td>
            <td>${ mem.birthDate }</td>
            <td>${ mem.divisionCode }</td>
            <td>${ mem.detailInfo }</td>
            <td>${ mem.contact }</td>
            <td>${ mem.teamCode }</td>
            <td>${ mem.activeStatus }</td>

        </tr>
    </c:forEach>
</table>

</body>
</html>
