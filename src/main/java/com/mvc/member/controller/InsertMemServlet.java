package com.mvc.member.controller;

import com.mvc.member.model.dto.MemberDTO;
import com.mvc.member.model.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/com/mvc/member/insert")
public class InsertMemServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String memberName = request.getParameter("memberName");
        String memberCode = request.getParameter("memCode");
        String birthDate = request.getParameter("birthDate");
        String divisionCode = request.getParameter("divisionCode");
        String detailInfo = request.getParameter("detailInfo");
        String contact = request.getParameter("contact");
        String teamCode	= request.getParameter("teamCode");
        String activeStatus	= request.getParameter("activeStatus");
        int salary = Integer.parseInt(request.getParameter("salary"));
        double bonus = Double.parseDouble(request.getParameter("bonus"));
        java.sql.Date hireDate = java.sql.Date.valueOf(request.getParameter("hireDate"));

        MemberService memberService = new MemberService();
        String newMemId = memberService.selectNewMemCode();

        MemberDTO mem = new MemberDTO();
        if(newMemId != null) mem.setMemberCode(newMemId);
        mem.setMemberName(memberName);
        mem.setMemberCode(memberCode);
        mem.setBirthDate(birthDate);
        mem.setDivisionCode(divisionCode);
        mem.setDetailInfo(detailInfo);
        mem.setContact(contact);
        mem.setTeamCode(teamCode);
        mem.setActiveStatus(activeStatus);

        System.out.println("insert request mem : " + mem);

        int result = memberService.insertMem(mem);

        String path = "";
        if(result > 0) {
            path = "/WEB-INF/views/common/successPage.jsp";
//			request.setAttribute("message", "신규 선수 등록에 성공하셨습니다.");
//			response.sendRedirect(request.getContextPath() + "/WEB-INF/views/common/successPage.jsp");

            request.setAttribute("successCode", "insertMem");
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            request.setAttribute("message", "신규 선수 등록에 실패하셨습니다.");
        }

        request.getRequestDispatcher(path).forward(request, response);
    }

}