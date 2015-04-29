package com.pudge.entity.bike;

import java.util.Date;

import com.pudge.base.BaseEntity;

public class BikeArea extends BaseEntity{

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bike_area.bike_area_uid
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	private String bikeAreaUid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bike_area.bike_area_no
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	private String bikeAreaNo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bike_area.bike_area_name
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	private String bikeAreaName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bike_area.area_rent_num
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	private Integer areaRentNum;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bike_area.area_return_num
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	private Integer areaReturnNum;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bike_area.service_time
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	private String serviceTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bike_area.area_on_duty
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	private Integer areaOnDuty;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bike_area.area_location
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	private String areaLocation;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bike_area.service_phone
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	private String servicePhone;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bike_area.other_service
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	private String otherService;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bike_area.area_longitude
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	private String areaLongitude;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bike_area.area_latitude
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	private String areaLatitude;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bike_area.update_time
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	private Date updateTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bike_area.remark
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	private String remark;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bike_area.bike_area_uid
	 * @return  the value of bike_area.bike_area_uid
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public String getBikeAreaUid() {
		return bikeAreaUid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bike_area.bike_area_uid
	 * @param bikeAreaUid  the value for bike_area.bike_area_uid
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public void setBikeAreaUid(String bikeAreaUid) {
		this.bikeAreaUid = bikeAreaUid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bike_area.bike_area_no
	 * @return  the value of bike_area.bike_area_no
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public String getBikeAreaNo() {
		return bikeAreaNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bike_area.bike_area_no
	 * @param bikeAreaNo  the value for bike_area.bike_area_no
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public void setBikeAreaNo(String bikeAreaNo) {
		this.bikeAreaNo = bikeAreaNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bike_area.bike_area_name
	 * @return  the value of bike_area.bike_area_name
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public String getBikeAreaName() {
		return bikeAreaName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bike_area.bike_area_name
	 * @param bikeAreaName  the value for bike_area.bike_area_name
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public void setBikeAreaName(String bikeAreaName) {
		this.bikeAreaName = bikeAreaName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bike_area.area_rent_num
	 * @return  the value of bike_area.area_rent_num
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public Integer getAreaRentNum() {
		return areaRentNum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bike_area.area_rent_num
	 * @param areaRentNum  the value for bike_area.area_rent_num
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public void setAreaRentNum(Integer areaRentNum) {
		this.areaRentNum = areaRentNum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bike_area.area_return_num
	 * @return  the value of bike_area.area_return_num
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public Integer getAreaReturnNum() {
		return areaReturnNum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bike_area.area_return_num
	 * @param areaReturnNum  the value for bike_area.area_return_num
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public void setAreaReturnNum(Integer areaReturnNum) {
		this.areaReturnNum = areaReturnNum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bike_area.service_time
	 * @return  the value of bike_area.service_time
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public String getServiceTime() {
		return serviceTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bike_area.service_time
	 * @param serviceTime  the value for bike_area.service_time
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public void setServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bike_area.area_on_duty
	 * @return  the value of bike_area.area_on_duty
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public Integer getAreaOnDuty() {
		return areaOnDuty;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bike_area.area_on_duty
	 * @param areaOnDuty  the value for bike_area.area_on_duty
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public void setAreaOnDuty(Integer areaOnDuty) {
		this.areaOnDuty = areaOnDuty;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bike_area.area_location
	 * @return  the value of bike_area.area_location
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public String getAreaLocation() {
		return areaLocation;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bike_area.area_location
	 * @param areaLocation  the value for bike_area.area_location
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public void setAreaLocation(String areaLocation) {
		this.areaLocation = areaLocation;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bike_area.service_phone
	 * @return  the value of bike_area.service_phone
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public String getServicePhone() {
		return servicePhone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bike_area.service_phone
	 * @param servicePhone  the value for bike_area.service_phone
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public void setServicePhone(String servicePhone) {
		this.servicePhone = servicePhone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bike_area.other_service
	 * @return  the value of bike_area.other_service
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public String getOtherService() {
		return otherService;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bike_area.other_service
	 * @param otherService  the value for bike_area.other_service
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public void setOtherService(String otherService) {
		this.otherService = otherService;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bike_area.area_longitude
	 * @return  the value of bike_area.area_longitude
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public String getAreaLongitude() {
		return areaLongitude;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bike_area.area_longitude
	 * @param areaLongitude  the value for bike_area.area_longitude
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public void setAreaLongitude(String areaLongitude) {
		this.areaLongitude = areaLongitude;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bike_area.area_latitude
	 * @return  the value of bike_area.area_latitude
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public String getAreaLatitude() {
		return areaLatitude;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bike_area.area_latitude
	 * @param areaLatitude  the value for bike_area.area_latitude
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public void setAreaLatitude(String areaLatitude) {
		this.areaLatitude = areaLatitude;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bike_area.update_time
	 * @return  the value of bike_area.update_time
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bike_area.update_time
	 * @param updateTime  the value for bike_area.update_time
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bike_area.remark
	 * @return  the value of bike_area.remark
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bike_area.remark
	 * @param remark  the value for bike_area.remark
	 * @mbggenerated  Sun Apr 19 18:04:28 CST 2015
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
}