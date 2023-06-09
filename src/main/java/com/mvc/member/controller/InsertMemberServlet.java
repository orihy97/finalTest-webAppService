package com.mvc.member.controller;

import com.mvc.member.model.dto.MemberDTO;
import com.mvc.member.model.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/member/insert")
public class InsertMemberServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String memberName = request.getParameter("memberName");
        String birthDate = request.getParameter("birthDate");
        String divisionCode = request.getParameter("divisionCode");
        String detailInfo = request.getParameter("detailInfo");
        String contact = request.getParameter("contact");
        String teamCode	= String.valueOf(Integer.parseInt(request.getParameter("teamCode")));
        String activeStatus	= request.getParameter("activeStatus");

        MemberService memberService = new MemberService();
        List<MemberDTO> newmemberCode = memberService.selectAllMembers();

        MemberDTO member = new MemberDTO();
        if(newmemberCode != null) member.setMemberCode(newmemberCode.toString());
        member.setMemberName(memberName);
        member.setBirthDate(birthDate);
        member.setDivisionCode(divisionCode);
        member.setDetailInfo(detailInfo);
        member.setContact(contact);
        member.setTeamCode(String.valueOf(teamCode));
        member.setActiveStatus(activeStatus);

        System.out.println("insert request member : " + member);

        boolean result = memberService.insertMember(member);

        String path = "";
        if(result) {
            path = "/view/common/successPage.jsp";

            request.setAttribute("successCode", "insertMem");
        } else {
            path = "/view/common/errorPage.jsp";
            request.setAttribute("message", "신규 선수 등록에 실패하셨습니다.");
        }

        request.getRequestDispatcher(path).forward(request, response);
    }

}