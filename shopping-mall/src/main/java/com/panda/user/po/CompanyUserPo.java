package com.panda.user.po;

import java.io.Serializable;

public class CompanyUserPo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8393228564996939861L;
	private int id;
	private String userName;//用户名
	private String passWord;//密码
	private String contactName;//联系人姓名
	private String deptName;//部门名称
	private String cTel;//固定电话
	private String cellPhone;//移动电话
	private String contactMail;//联系人邮箱
	private String companyName;//公司名称
	private String companyAddress;//公司地址
	private String companyPeoNum;//企业人数
	private String companyTrade;//公司行业
	private String companyType;//公司性质
	private String identify;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getcTel() {
		return cTel;
	}
	public void setcTel(String cTel) {
		this.cTel = cTel;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public String getContactMail() {
		return contactMail;
	}
	public void setContactMail(String contactMail) {
		this.contactMail = contactMail;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyPeoNum() {
		return companyPeoNum;
	}
	public void setCompanyPeoNum(String companyPeoNum) {
		this.companyPeoNum = companyPeoNum;
	}
	public String getCompanyTrade() {
		return companyTrade;
	}
	public void setCompanyTrade(String companyTrade) {
		this.companyTrade = companyTrade;
	}
	public String getCompanyType() {
		return companyType;
	}
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	public String getIdentify() {
		return identify;
	}
	public void setIdentify(String identify) {
		this.identify = identify;
	}
	@Override
	public String toString() {
		return "CompanyUserPo [id=" + id + ", userName=" + userName
				+ ", passWord=" + passWord + ", contactName=" + contactName
				+ ", deptName=" + deptName + ", cTel=" + cTel + ", cellPhone="
				+ cellPhone + ", contactMail=" + contactMail + ", companyName="
				+ companyName + ", companyAddress=" + companyAddress
				+ ", companyPeoNum=" + companyPeoNum + ", companyTrade="
				+ companyTrade + ", companyType=" + companyType + ", identify="
				+ identify + "]";
	}
}
