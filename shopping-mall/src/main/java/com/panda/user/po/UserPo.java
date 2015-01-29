package com.panda.user.po;

import java.io.Serializable;

public class UserPo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5366913504107276038L;
	private int id;
	private String loginName;//登录名 
	private String age;//年龄
	private String address;//地址
	private String nickName;//昵称
	private String loginPassWord;//登录密码
	private String payPassWord;//支付密码
	private String phone;//手机
	private String email;//邮箱
	private String identify;
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
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
	@Override
	public String toString() {
		return "UserPo [id=" + id + ", loginName=" + loginName + ", age=" + age
				+ ", address=" + address + ", nickName=" + nickName
				+ ", loginPassWord=" + loginPassWord + ", payPassWord="
				+ payPassWord + ", phone=" + phone + ", email=" + email
				+ ", identify=" + identify + "]";
	}
	
}
