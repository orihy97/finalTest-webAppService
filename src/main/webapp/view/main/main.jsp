<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<h3>MEMBER_INFO 테이블에서 MEMBER_CODE를 이용하여 선수 정보 조회해오기</h3>
<form action="member/select">
  <label>조회할 코드 : </label>
  <input type="text" name="memberCode" id="memberCode">
  <button type="submit">조회하기</button>
</form>

<h3>MEMBER_INFO 테이블에서 선수 전체 정보 조회 (현재 소속된 선수만 조회할 것) : /member/list (get)</h3>
<button onclick="location.href='${pageContext.servletContext.contextPath}/member/list'">선수정보 전체 조회하기</button>

<h3>MEMBER_INFO 테이블에서 신규 선수 정보 추가 (필요한 정보를 입력받을 수 있는 form을 만들어서 추가할 것) : /member/insert (post)</h3>
<form action="${ pageContext.servletContext.contextPath }/member/insert" method="post">
  선수명 : <input type="text" name="memberName"><br>
  생년월일 : <input type="text" name="birthDate"><br>
  종족코드 : <input type="text" name="divisionCode"><br>
  세부사항 : <input type="text" name="detailInfo"><br>
  전화번호 : <input type="text" name="contact"><br>
  팀코드 : <input type="text" name="teamCode"><br>
  활동상태 : <input type="text" name="activeStatus"><br>


  <button type="submit">등록하기</button>
</form>

<h3>MEMBER_INFO 테이블에서 Member 정보 수정 (Member코드와 변경할 정보를 입력 받아 Member코드와 일치하는 ,Member의 정보 변경 - 원하는 데이터 변경) : /member/update (post)</h3>
<form action="${ pageContext.servletContext.contextPath }/member/update" method="post">
  선수코드 : <input type="text" name="memberCode"><br>
  생년월일 : <input type="text" name="birthDate"><br>
  <button type="submit">Member 생년월일</button>
</form>

<h3>MEMBER_INFO 테이블에서 Member 정보 삭제 (Member코드 입력 받아 Member코드와 일치하는 행 삭제) : /member/delete (post)</h3>
<form action="${ pageContext.servletContext.contextPath }/member/delete" method="post">
  Member코드 : <input type="text" name="memberCode"><br>
  <button type="submit">Member 정보 삭제</button>
</form>
</body>
</html>
