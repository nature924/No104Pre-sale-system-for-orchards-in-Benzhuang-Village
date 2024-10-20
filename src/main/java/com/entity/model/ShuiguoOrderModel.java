package com.entity.model;

import com.entity.ShuiguoOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 水果预售订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShuiguoOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单编号
     */
    private String shuiguoOrderUuidNumber;


    /**
     * 收货地址
     */
    private Integer addressId;


    /**
     * 水果
     */
    private Integer shuiguoId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 购买数量
     */
    private Integer buyNumber;


    /**
     * 实付价格
     */
    private Double shuiguoOrderTruePrice;


    /**
     * 快递公司
     */
    private String guoyuanOrderCourierName;


    /**
     * 快递单号
     */
    private String guoyuanOrderCourierNumber;


    /**
     * 订单类型
     */
    private Integer shuiguoOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：订单编号
	 */
    public String getShuiguoOrderUuidNumber() {
        return shuiguoOrderUuidNumber;
    }


    /**
	 * 设置：订单编号
	 */
    public void setShuiguoOrderUuidNumber(String shuiguoOrderUuidNumber) {
        this.shuiguoOrderUuidNumber = shuiguoOrderUuidNumber;
    }
    /**
	 * 获取：收货地址
	 */
    public Integer getAddressId() {
        return addressId;
    }


    /**
	 * 设置：收货地址
	 */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 获取：水果
	 */
    public Integer getShuiguoId() {
        return shuiguoId;
    }


    /**
	 * 设置：水果
	 */
    public void setShuiguoId(Integer shuiguoId) {
        this.shuiguoId = shuiguoId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 设置：购买数量
	 */
    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getShuiguoOrderTruePrice() {
        return shuiguoOrderTruePrice;
    }


    /**
	 * 设置：实付价格
	 */
    public void setShuiguoOrderTruePrice(Double shuiguoOrderTruePrice) {
        this.shuiguoOrderTruePrice = shuiguoOrderTruePrice;
    }
    /**
	 * 获取：快递公司
	 */
    public String getGuoyuanOrderCourierName() {
        return guoyuanOrderCourierName;
    }


    /**
	 * 设置：快递公司
	 */
    public void setGuoyuanOrderCourierName(String guoyuanOrderCourierName) {
        this.guoyuanOrderCourierName = guoyuanOrderCourierName;
    }
    /**
	 * 获取：快递单号
	 */
    public String getGuoyuanOrderCourierNumber() {
        return guoyuanOrderCourierNumber;
    }


    /**
	 * 设置：快递单号
	 */
    public void setGuoyuanOrderCourierNumber(String guoyuanOrderCourierNumber) {
        this.guoyuanOrderCourierNumber = guoyuanOrderCourierNumber;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getShuiguoOrderTypes() {
        return shuiguoOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setShuiguoOrderTypes(Integer shuiguoOrderTypes) {
        this.shuiguoOrderTypes = shuiguoOrderTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
