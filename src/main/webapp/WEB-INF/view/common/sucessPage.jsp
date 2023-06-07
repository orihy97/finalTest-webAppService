<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<script>
  (function() {
    const successCode = '${ requestScope.successCode }';

    let successMessage = '';
    let movePath = '';

    switch(successCode) {
      case 'insertMem' :
        successMessage = 'ㅋㅋ신규 선수 등록 성공ㅋㅋ';
        movePath = '${pageContext.servletContext.contextPath}/member/list';
        break;
      case 'updateMem' :
        successMessage = 'ㅋㅋ선수 정보 수정 성공ㅋㅋ';
        movePath = '${pageContext.servletContext.contextPath}/member/list';
        break;
      case 'deleteMem' :
        successMessage = 'ㅋㅋ선수 정보 삭제 성공ㅋㅋ';
        movePath = '${pageContext.servletContext.contextPath}/member/list';
        break;
    }

    alert(successMessage);
    location.href = movePath;

  })();
</script>
</body>
</html>