package com.mvc.employee.controller;

import com.mvc.employee.model.dto.EmployeeDTO;
import com.mvc.employee.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/com/mvc/employee/insert")
public class InsertEmpServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String empName = request.getParameter("empName");
        String empNo = request.getParameter("empNo");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String deptCode = request.getParameter("deptCode");
        String jobCode = request.getParameter("jobCode");
        String salLevel	= request.getParameter("salLevel");
        int salary = Integer.parseInt(request.getParameter("salary"));
        double bonus = Double.parseDouble(request.getParameter("bonus"));
        String managerId = request.getParameter("managerId");
        java.sql.Date hireDate = java.sql.Date.valueOf(request.getParameter("hireDate"));

        EmployeeService empService = new EmployeeService();
        String newEmpId = empService.selectNewEmpId();

        EmployeeDTO emp = new EmployeeDTO();
        if(newEmpId != null) emp.setEmpId(newEmpId);
        emp.setEmpName(empName);
        emp.setEmpNo(empNo);
        emp.setEmail(email);
        emp.setPhone(phone);
        emp.setDeptCode(deptCode);
        emp.setJobCode(jobCode);
        emp.setSalLevel(salLevel);
        emp.setSalary(salary);
        emp.setBonus(bonus);
        emp.setManagerId(managerId);
        emp.setHireDate(hireDate);

        System.out.println("insert request emp : " + emp);

        int result = empService.insertEmp(emp);

        String path = "";
        if(result > 0) {
            path = "/WEB-INF/views/common/successPage.jsp";
//			request.setAttribute("message", "신규 직원 등록에 성공하셨습니다.");
//			response.sendRedirect(request.getContextPath() + "/WEB-INF/views/common/successPage.jsp");

            request.setAttribute("successCode", "insertEmp");
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            request.setAttribute("message", "신규 직원 등록에 실패하셨습니다.");
        }

        request.getRequestDispatcher(path).forward(request, response);
    }

}