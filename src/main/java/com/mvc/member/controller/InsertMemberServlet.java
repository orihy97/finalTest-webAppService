package com.mvc.member.controller;

import com.mvc.member.model.dto.MemberDTO;
import com.mvc.member.model.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/member/insert")
public class InsertMemberServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String memberName = request.getParameter("memberName");
        String memberCode = request.getParameter("memCode");
        String birthDate = request.getParameter("birthDate");
        String divisionCode = request.getParameter("divisionCode");
        String detailInfo = request.getParameter("detailInfo");
        String contact = request.getParameter("contact");
        int teamCode	= Integer.parseInt(request.getParameter("teamCode"));
        String activeStatus	= request.getParameter("activeStatus");
        int salary = Integer.parseInt(request.getParameter("salary"));
        double bonus = Double.parseDouble(request.getParameter("bonus"));
        Date hireDate = Date.valueOf(request.getParameter("hireDate"));

        MemberService memberService = new MemberService();
        List<MemberDTO> newMemId = memberService.selectAllMembers();

        MemberDTO mem = new MemberDTO();
        if(newMemId != null) mem.setMemberCode(newMemId);
        mem.setMemberName(memberName);
        mem.setMemberCode(String.valueOf(Integer.parseInt(memberCode)));
        mem.setBirthDate(birthDate);
        mem.setDivisionCode(divisionCode);
        mem.setDetailInfo(detailInfo);
        mem.setContact(contact);
        mem.setTeamCode(String.valueOf(teamCode));
        mem.setActiveStatus(activeStatus);

        System.out.println("insert request mem : " + mem);

        boolean result = memberService.insertMember(mem);

        String path = "";
        if(result) {
            path = "/WEB-INF/view/common/successPage.jsp";
//			request.setAttribute("message", "신규 선수 등록에 성공하셨습니다.");
//			response.sendRedirect(request.getContextPath() + "/WEB-INF/view/common/successPage.jsp");

            request.setAttribute("successCode", "insertMem");
        } else {
            path = "/WEB-INF/view/common/errorPage.jsp";
            request.setAttribute("message", "신규 선수 등록에 실패하셨습니다.");
        }

        request.getRequestDispatcher(path).forward(request, response);
    }

}