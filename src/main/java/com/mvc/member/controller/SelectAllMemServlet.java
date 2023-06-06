package com.mvc.member.controller;

import com.mvc.member.model.dto.MemberDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/com/mvc/member/list")
public class SelectAllMemServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MemberService empService = new MemberService();
        List<MemberDTO> empList = empService.selectAllEmp();

        for(MemberDTO emp : empList) {
            System.out.println(emp);
        }

        /* 조회 결과 성공 여부에 따른 뷰 결정 */
        String path = "";
        if(empList != null) {
            path = "/WEB-INF/views/member/memberList.jsp";
            request.setAttribute("empList", empList);
        } else {
            path = "/WEB-INF/common/errorPage.jsp";
            request.setAttribute("message", "선수 목록 조회 실패!");
        }

        request.getRequestDispatcher(path).forward(request, response);

    }

}