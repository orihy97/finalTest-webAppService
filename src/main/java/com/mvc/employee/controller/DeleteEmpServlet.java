package com.mvc.employee.controller;

import com.mvc.employee.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/com/mvc/employee/delete")
public class DeleteEmpServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String empId = request.getParameter("empId");

        int result = new EmployeeService().deleteEmp(empId);

        String path = "";
        if(result > 0) {
            path = "/WEB-INF/views/common/successPage.jsp";
            request.setAttribute("successCode", "deleteEmp");
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            request.setAttribute("message", "직원 삭제 실패!");
        }

        request.getRequestDispatcher(path).forward(request, response);
    }

}