package com.panda.user.po;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CompanyUserPo implements Serializable{
	/**
	 * 
	 */
	public static Map<String,String> mapDptName=new HashMap<String, String>(); 
	public static Map<String,String> mapPeoNum=new HashMap<String, String>(); 
	public static Map<String,String> mapType=new HashMap<String, String>();
	public static Map<String,String> mapTrade=new HashMap<String, String>();
	static{
		//部门
		mapDptName.put("1", "办公室");
		mapDptName.put("2", "市场部");
		mapDptName.put("3", "采购部");
		mapDptName.put("4", "技术部");
		mapDptName.put("5", "人力资源");
		mapDptName.put("6", "其他");
		//公司人数
		mapPeoNum.put("1", "1-49");
		mapPeoNum.put("2", "50-99");
		mapPeoNum.put("3", "100-499");
		mapPeoNum.put("4", "500-999");
		mapPeoNum.put("5", "1000以上");
		//公司行业
		mapTrade.put("1","计算机硬件及网络设备");
		mapTrade.put("2","计算机软件");
		mapTrade.put("3","IT服务（系统/数据/维护）/多领域经营");
		mapTrade.put("4","互联网/电子商务");
		mapTrade.put("5","网络游戏");
		mapTrade.put("6","通讯/设备/运营/增值服务");
		mapTrade.put("7","电子技术/半导体/集成电路");
		mapTrade.put("8","仪器仪表及工业自动化");
		mapTrade.put("9","金融/银行/投资/基金/证券");
		mapTrade.put("10","保险");
		mapTrade.put("11","房地产/建筑/建材/工程");
		mapTrade.put("12","家居/室内设计/装饰装潢");
		mapTrade.put("13","物业管理/商业中心");
		mapTrade.put("14","广告/会展/公关/市场推广");
		mapTrade.put("15","媒体/出版/影视/文化/艺术");
		mapTrade.put("16","印刷/包装/造纸");
		mapTrade.put("17","咨询/管理产业/法律/财会");
		mapTrade.put("18","教育/培训");
		mapTrade.put("19","检验/检测/认证");
		mapTrade.put("20","中介服务");
		mapTrade.put("21","贸易/进出口");
		mapTrade.put("22","零售/批发");
		mapTrade.put("23","快速消费品（食品/饮料/烟酒/化妆品");
		mapTrade.put("24","耐用消费品（服装服饰/纺织/皮革/家具/家电）");
		mapTrade.put("25","办公用品及设备");
		mapTrade.put("26","礼品/玩具/工艺美术/收藏品");
		mapTrade.put("27","大型设备/机电设备/重工业");
		mapTrade.put("28","加工制造（原料加工/模具）");
		mapTrade.put("29","汽车/摩托车（制造/维护/配件/销售/服务）");
		mapTrade.put("30","交通/运输/物流");
		mapTrade.put("31","医药/生物工程");
		mapTrade.put("32","医疗/护理/美容/保健");
		mapTrade.put("33","医疗设备/器械");
		mapTrade.put("34","酒店/餐饮");
		mapTrade.put("35","娱乐/体育/休闲");
		mapTrade.put("36","旅游/度假");
		mapTrade.put("37","石油/石化/化工");
		mapTrade.put("38","能源/矿产/采掘/冶炼");
		mapTrade.put("39","电气/电力/水利");
		mapTrade.put("40","航空/航天");
		mapTrade.put("41","学术/科研");
		mapTrade.put("42","政府/公共事业/非盈利机构");
		mapTrade.put("43","环保");
		mapTrade.put("44","农/林/牧/渔");
		mapTrade.put("45","跨领域经营");
		mapTrade.put("46","其它");
		mapTrade.put("46","其他");
		//公司类型
		mapType.put("1", "政府机关/事业单位");
		mapType.put("2", "国营");
		mapType.put("3", "私营");
		mapType.put("4", "中外合资");
		mapType.put("5", "外资");
		mapType.put("6", "其他");
	}
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
	private String companyData;//公司相关资料
	private String identify;
	private int status;//1.审核中 2.审核通过
	private Date cTime;//该条记录的创建时间
	private Date uTime;//该条记录的更新时间
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
	public String getCompanyData() {
		return companyData;
	}
	public void setCompanyData(String companyData) {
		this.companyData = companyData;
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
	public void setuTime(Date uTime) {
		this.uTime = uTime;
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
	public CompanyUserPo toPo(){
		if(this!=null){
			this.setDeptName(mapDptName.get(this.getDeptName()));
			this.setDeptName(mapPeoNum.get(this.getCompanyPeoNum()));
			this.setDeptName(mapType.get(this.getCompanyType()));
			this.setDeptName(mapTrade.get(this.getCompanyTrade()));
		}
		return this;
	}
}
