<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../common/header.jsp"/>

Member코드 : ${ requestScope.selectedMem.memCode }<br>
Member이름 : ${ requestScope.selectedMem.memName }<br>
Member몰라 : ${ requestScope.selectedMem.memGender }<br>

</body>
</html>
