package com.mvc.member.model.dao;

import com.mvc.common.config.ConfigLocation;
import com.mvc.member.model.dto.MemberDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.mvc.common.jdbc.JDBCTemplate.close;

public class MemberDAO {

    private final Properties prop;

    public MemberDAO() {

        prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "member-mapper.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public MemberDTO selectMemByCode(Connection con, String memberCode) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        MemberDTO selectedMem = null;

        String query = prop.getProperty("selectMemByCode");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, memberCode);

            rset = pstmt.executeQuery();

            if (rset.next()) {
                selectedMem = new MemberDTO();

                selectedMem.setMemberCode(rset.getString("MEMBER_CODE"));
                selectedMem.setMemberName(rset.getString("MEMBER_NAME"));
                selectedMem.setBirthDate(rset.getString("BIRTH_DATE"));
                selectedMem.setDivisionCode(rset.getString("DIVISION_CODE"));
                selectedMem.setDetailInfo(rset.getString("DETAIL_INFO"));
                selectedMem.setContact(rset.getString("CONTACT"));
                selectedMem.setTeamCode(rset.getString("TEAM_CODE"));
                selectedMem.setActiveStatus(rset.getString("ACTIVE_STATUS"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }

        return selectedMem;
    }

    /* member 테이블의 전체 목록 조회 */
    public List<MemberDTO> selectAllMemList(Connection con) {

        Statement stmt = null;
        ResultSet rset = null;

        List<MemberDTO> memList = null;

        String query = prop.getProperty("selectAllMemList");

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            memList = new ArrayList<>();

            while (rset.next()) {
                MemberDTO mem = new MemberDTO();
                mem.setMemberCode(rset.getString("MEMBER_CODE"));
                mem.setMemberName(rset.getString("MEMBER_NAME"));
                mem.setBirthDate(rset.getString("BIRTH_DATE"));
                mem.setDivisionCode(rset.getString("DIVISION_CODE"));
                mem.setDetailInfo(rset.getString("DETAIL_INFO"));
                mem.setContact(rset.getString("Contact"));
                mem.setTeamCode(rset.getString("TEAM_CODE"));
                mem.setActiveStatus(rset.getString("ACTIVE_STATUS"));


                memList.add(mem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(stmt);
        }

        return memList;
    }

    public String selectNewMemCode(Connection con) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String newMemCode = null;

        String query = prop.getProperty("selectNewMemCode");

        try {
            pstmt = con.prepareStatement(query);

            rset = pstmt.executeQuery();

            if (rset.next()) {
                newMemCode = rset.getString("MEMBER_CODE");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }

        return newMemCode;
    }

    /* memloyee 테이블에 insert 하는 메소드 */
    public int insertMem(Connection con, MemberDTO mem) {

        PreparedStatement pstmt = null;

        int result = 0;

        String query = prop.getProperty("insertMem");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, mem.getMemberCode());
            pstmt.setString(2, mem.getMemberName());
            pstmt.setString(4, mem.getBirthDate());
            pstmt.setString(5, mem.getDivisionCode());
            pstmt.setString(6, mem.getDetailInfo());
            pstmt.setString(7, mem.getContact());
            pstmt.setString(8, mem.getTeamCode());
            pstmt.setString(9, mem.getActiveStatus());


            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }


    public int updateMem(Connection con, MemberDTO mem) {

        PreparedStatement pstmt = null;

        int result = 0;

        String query = prop.getProperty("updateMem");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, mem.getMemberCode());
            pstmt.setString(2, mem.getBirthDate());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }


    public int deleteMem(Connection con, String memCode) {

        PreparedStatement pstmt = null;

        int result = 0;

        String query = prop.getProperty("deleteMem");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, memCode);

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }

}