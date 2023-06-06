package com.mvc.member.controller;

import com.mvc.member.model.dto.MemberDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/com/mvc/member/update")
public class UpdateMemServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String memId = request.getParameter("memId");
        java.sql.Date entDate = java.sql.Date.valueOf(request.getParameter("entDate"));

        MemberDTO mem = new MemberDTO();
        mem.setMemId(memId);
        mem.setEntDate(entDate);

        int result = new MemberService().updateMem(mem);

        String path = "";
        if(result > 0) {
            path = "/WEB-INF/views/common/successPage.jsp";
            request.setAttribute("successCode", "updateMem");
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            request.setAttribute("message", "회원 정보 수정 실패!");
        }

        request.getRequestDispatcher(path).forward(request, response);
    }

}
