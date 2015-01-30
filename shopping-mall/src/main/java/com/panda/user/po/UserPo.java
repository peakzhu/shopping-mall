package com.panda.user.po;

import java.io.Serializable;
import java.util.Date;

public class UserPo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5366913504107276038L;
	private int id;
	private String loginName;//登录名 
	private String sex;//性别
	private String birthday;//生日
	private String address;//地址
	private String nickName;//昵称
	private String loginPassWord;//登录密码
	private String payPassWord;//支付密码
	private String phone;//手机
	private String email;//邮箱
	private String identify;
	private int status;//1:生效 2：失效
	private Date cTime;//该条记录的创建时间
	private Date uTime;//该条记录的更新时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getLoginPassWord() {
		return loginPassWord;
	}
	public void setLoginPassWord(String loginPassWord) {
		this.loginPassWord = loginPassWord;
	}
	public String getPayPassWord() {
		return payPassWord;
	}
	public void setPayPassWord(String payPassWord) {
		this.payPassWord = payPassWord;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdentify() {
		return identify;
	}
	public void setIdentify(String identify) {
		this.identify = identify;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getcTime() {
		return cTime;
	}
	public void setcTime(Date cTime) {
		this.cTime = cTime;
	}
	public Date getuTime() {
		return uTime;
	}
	public void setuTime(Date uPdate) {
		this.uTime = uPdate;
	}
	@Override
	public String toString() {
		return "UserPo [id=" + id + ", loginName=" + loginName + ", sex=" + sex
				+ ", birthday=" + birthday + ", address=" + address
				+ ", nickName=" + nickName + ", loginPassWord=" + loginPassWord
				+ ", payPassWord=" + payPassWord + ", phone=" + phone
				+ ", email=" + email + ", identify=" + identify + ", status="
				+ status + "]";
	}
}
