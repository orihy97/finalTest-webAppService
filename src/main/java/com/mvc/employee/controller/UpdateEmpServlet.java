package com.mvc.employee.controller;

import com.mvc.employee.model.dto.EmployeeDTO;
import com.mvc.employee.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/com/mvc/employee/update")
public class UpdateEmpServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String empId = request.getParameter("empId");
        java.sql.Date entDate = java.sql.Date.valueOf(request.getParameter("entDate"));

        EmployeeDTO emp = new EmployeeDTO();
        emp.setEmpId(empId);
        emp.setEntDate(entDate);

        int result = new EmployeeService().updateEmp(emp);

        String path = "";
        if(result > 0) {
            path = "/WEB-INF/views/common/successPage.jsp";
            request.setAttribute("successCode", "updateEmp");
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            request.setAttribute("message", "회원 정보 수정 실패!");
        }

        request.getRequestDispatcher(path).forward(request, response);
    }

}
