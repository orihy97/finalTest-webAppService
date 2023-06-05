package com.mvc.employee.model.dao;

import com.mvc.common.config.ConfigLocation;
import com.mvc.common.jdbc.JDBCTemplate;
import com.mvc.employee.model.dto.EmployeeDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmployeeDAO {

    private final Properties prop;

    public EmployeeDAO() {
        prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "employee-mapper.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public EmployeeDTO selectEmpById(Connection con, String empId) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        EmployeeDTO selectedEmp = null;
        String query = prop.getProperty("selectEmpById");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empId);
            rset = pstmt.executeQuery();

            if (rset.next()) {
                selectedEmp = new EmployeeDTO();
                selectedEmp.setEmpId(rset.getString("EMP_ID"));
                selectedEmp.setEmpName(rset.getString("EMP_NAME"));
                selectedEmp.setDeptCode(rset.getString("DEPT_CODE"));
                selectedEmp.setJobCode(rset.getString("JOB_CODE"));
                selectedEmp.setSalary(rset.getInt("SALARY"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }

        return selectedEmp;
    }

    public List<EmployeeDTO> selectAllEmpList(Connection con) {
        Statement stmt = null;
        ResultSet rset = null;
        List<EmployeeDTO> empList = null;
        String query = prop.getProperty("selectAllEmpList");

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);
            empList = new ArrayList<>();

            while (rset.next()) {
                EmployeeDTO emp = new EmployeeDTO();
                emp.setEmpId(rset.getString("EMP_ID"));
                emp.setEmpName(rset.getString("EMP_NAME"));
                emp.setEmail(rset.getString("EMAIL"));
                emp.setEmpNo(rset.getString("EMP_NO"));
                emp.setPhone(rset.getString("PHONE"));
                emp.setDeptCode(rset.getString("DEPT_CODE"));
                emp.setJobCode(rset.getString("JOB_CODE"));
                emp.setSalLevel(rset.getString("SAL_LEVEL"));
                emp.setSalary(rset.getInt("SALARY"));
                emp.setBonus(rset.getDouble("BONUS"));
                emp.setManagerId(rset.getString("MANAGER_ID"));
                emp.setHireDate(rset.getDate("HIRE_DATE"));
                emp.setEntDate(rset.getDate("ENT_DATE"));
                emp.setEntYn(rset.getString("ENT_YN"));

                empList.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(stmt);
        }

        return empList;
    }

    public String selectNewEmpId(Connection con) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String newEmpId = null;
        String query = prop.getProperty("selectNewEmpId");

        try {
            pstmt = con.prepareStatement(query);
            rset = pstmt.executeQuery();

            if (rset.next()) {
                newEmpId = rset.getString("EMP_ID");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
    }
}
