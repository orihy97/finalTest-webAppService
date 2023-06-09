package com.mvc.member.model.service;

import com.mvc.member.model.dao.MemberDAO;
import com.mvc.member.model.dto.MemberDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.mvc.common.Template.getSqlSession;

public class MemberService {

    private MemberDAO memberDAO;

    public MemberDTO selectOneMemberById(String memberCode) {
        SqlSession sqlSession = getSqlSession();

        memberDAO = sqlSession.getMapper(MemberDAO.class);
        MemberDTO selectedMember = memberDAO.selectMemberById(String.valueOf(Integer.parseInt(memberCode)));
        sqlSession.close();

        return selectedMember;
    }

    public List<MemberDTO> selectAllMembers() {
        SqlSession sqlSession = getSqlSession();

        memberDAO = sqlSession.getMapper(MemberDAO.class);
        List<MemberDTO> memberList = memberDAO.selectAllMembers();
        sqlSession.close();

        return memberList;
    }

    public boolean insertMember(MemberDTO member) {
        SqlSession sqlSession = getSqlSession();

        memberDAO = sqlSession.getMapper(MemberDAO.class);
        boolean result = memberDAO.insertMember(member);

        if (result) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result;
    }

    public boolean updateMember(MemberDTO member) {
        SqlSession sqlSession = getSqlSession();

        memberDAO = sqlSession.getMapper(MemberDAO.class);
        if (member.getMemberName() == null) {
            member.setMemberName("Default Name");
        }
        
        boolean result = memberDAO.updateMember(member);

        if (result) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result;
    }

    public boolean deleteMember(String memberCode) {
        SqlSession sqlSession = getSqlSession();

        memberDAO = sqlSession.getMapper(MemberDAO.class);
        boolean result = memberDAO.deleteMember(Integer.parseInt(memberCode));

        if (result) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result;
    }

}