package com.mvc.member.model.dto;

import java.util.List;

public class MemberDTO implements java.io.Serializable {

    private String teamCode;
    private String memberCode;
    private String memberName;
    private String birthDate;
    private String divisionCode;
    private String detailInfo;
    private String contact;
    private String activeStatus;

    public MemberDTO() {

    }

    public MemberDTO(String memberCode, String memberName, String birthDate, String divisionCode, String detailInfo, String contact, String teamCode, String activeStatus) {
        this.memberCode = memberCode;
        this.memberName = memberName;
        this.birthDate = birthDate;
        this.divisionCode = divisionCode;
        this.detailInfo = detailInfo;
        this.contact = contact;
        this.teamCode = teamCode;
        this.activeStatus = activeStatus;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDivisionCode() {
        return divisionCode;
    }

    public void setDivisionCode(String divisionCode) {
        this.divisionCode = divisionCode;
    }

    public String getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(String detailInfo) {
        this.detailInfo = detailInfo;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberCode='" + memberCode + '\'' +
                ", memberName='" + memberName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", divisionCode='" + divisionCode + '\'' +
                ", detailInfo='" + detailInfo + '\'' +
                ", contact='" + contact + '\'' +
                ", teamCode='" + teamCode + '\'' +
                ", activeStatus='" + activeStatus + '\'' +
                '}';
    }

    public void setMemberCode(List<MemberDTO> newmemberCode) {
    }
}
