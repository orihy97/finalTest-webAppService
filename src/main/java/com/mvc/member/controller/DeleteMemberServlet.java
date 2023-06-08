package com.mvc.member.controller;

import com.mvc.member.model.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/delete")
public class DeleteMemberServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int memberId = Integer.parseInt(request.getParameter("memberId"));

        boolean result = new MemberService().deleteMember(memberId);

        String path = "";
        if (result) {
            path = "/WEB-INF/view/common/errorPage.jsp";
            request.setAttribute("message", "선수 삭제 실패!");
        } else {
            path = "/WEB-INF/view/common/successPage.jsp";
            request.setAttribute("successCode", "deleteMember");
        }

        request.getRequestDispatcher(path).forward(request, response);
    }

}