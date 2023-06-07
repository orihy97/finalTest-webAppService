package com.mvc.member.controller;

import com.mvc.member.model.dto.MemberDTO;
import com.mvc.member.model.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/com/mvc/member/select")
public class SelectOneMemByIdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* 전달한 파라미터 꺼내기 */
        String memId = request.getParameter("memId");

        System.out.println("memId : " + memId);

        /* 사번을 이용해 사원 정보를 조회하는 비지니스 로직 호출 */
        MemberService memService = new MemberService();
        MemberDTO selectedMem = memService.selectOneMemByCode(memId);

        System.out.println("selectedMem : " + selectedMem);

        /* 비지니스 로직 실행 결과에 따라 뷰 연결 */
        String path = "";
        if(selectedMem != null) {
            path = "/WEB-INF/views/member/showMemInfo.jsp";
            request.setAttribute("selectedMem", selectedMem);
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            request.setAttribute("message", "선수 정보 조회 실패!");
        }

        request.getRequestDispatcher(path).forward(request, response);

    }

}
