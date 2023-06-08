<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/view/common/header.jsp"/>

Member코드 : ${ requestScope.selectedMember.memberCode }<br>
Member이름 : ${ requestScope.selectedMember.memberName }<br>
Member생년월일 : ${requestScope.selectedMember.birthDate }<br>
Member종족코드 : ${requestScope.selectedMember.divisionCode}<br>
Member상세정보 : ${requestScope.selectedMember.detailInfo }<br>
Member연락처 : ${requestScope.selectedMember.contact }<br>
Member소속팀코드 : ${requestScope.selectedMember.teamCode }<br>
Member활동상태 : ${requestScope.selectedMember.activeStatus}<br>

</body>
</html>
