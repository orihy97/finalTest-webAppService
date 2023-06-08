package com.mvc.member.controller;

import com.mvc.member.model.dto.MemberDTO;
import com.mvc.member.model.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Member;


@WebServlet("/member/update")
public class UpdateMemberServlet extends HttpServlet {

    private MemberDTO member;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String memberCode = request.getParameter("memberCode");
        String birthDate=request.getParameter("birthDate");
        MemberDTO member = new MemberDTO();
        member.setMemberCode(memberCode);
        member.setBirthDate(birthDate);
        MemberService memberService=new MemberService();
        boolean result = memberService.updateMember(member);

        String path = "";
        if(result) {
            path = "/view/common/successPage.jsp";
            request.setAttribute("successCode", "updateMember");
        } else {
            path = "/view/common/errorPage.jsp";
            request.setAttribute("message", "회원 정보 수정 실패!");
        }

        request.getRequestDispatcher(path).forward(request, response);
    }

}
