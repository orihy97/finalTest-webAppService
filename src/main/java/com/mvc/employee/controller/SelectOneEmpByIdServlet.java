package com.mvc.employee.controller;

import com.mvc.employee.model.dto.EmployeeDTO;
import com.mvc.employee.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/com/mvc/employee/select")
public class SelectOneEmpByIdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* 전달한 파라미터 꺼내기 */
        String empId = request.getParameter("empId");

        System.out.println("empId : " + empId);

        /* 사번을 이용해 사원 정보를 조회하는 비지니스 로직 호출 */
        EmployeeService empService = new EmployeeService();
        EmployeeDTO selectedEmp = empService.selectOneEmpById(empId);

        System.out.println("selectedEmp : " + selectedEmp);

        /* 비지니스 로직 실행 결과에 따라 뷰 연결 */
        String path = "";
        if(selectedEmp != null) {
            path = "/WEB-INF/views/employee/showEmpInfo.jsp";
            request.setAttribute("selectedEmp", selectedEmp);
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            request.setAttribute("message", "직원 정보 조회 실패!");
        }

        request.getRequestDispatcher(path).forward(request, response);

    }

}
