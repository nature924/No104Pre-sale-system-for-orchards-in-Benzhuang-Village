package com.entity.model;

import com.entity.GuoshuOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 果树订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GuoshuOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单编号
     */
    private String guoshuOrderUuidNumber;


    /**
     * 果树
     */
    private Integer guoshuId;


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
    private Double guoshuOrderTruePrice;


    /**
     * 订单类型
     */
    private Integer guoshuOrderTypes;


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
    public String getGuoshuOrderUuidNumber() {
        return guoshuOrderUuidNumber;
    }


    /**
	 * 设置：订单编号
	 */
    public void setGuoshuOrderUuidNumber(String guoshuOrderUuidNumber) {
        this.guoshuOrderUuidNumber = guoshuOrderUuidNumber;
    }
    /**
	 * 获取：果树
	 */
    public Integer getGuoshuId() {
        return guoshuId;
    }


    /**
	 * 设置：果树
	 */
    public void setGuoshuId(Integer guoshuId) {
        this.guoshuId = guoshuId;
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
    public Double getGuoshuOrderTruePrice() {
        return guoshuOrderTruePrice;
    }


    /**
	 * 设置：实付价格
	 */
    public void setGuoshuOrderTruePrice(Double guoshuOrderTruePrice) {
        this.guoshuOrderTruePrice = guoshuOrderTruePrice;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getGuoshuOrderTypes() {
        return guoshuOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setGuoshuOrderTypes(Integer guoshuOrderTypes) {
        this.guoshuOrderTypes = guoshuOrderTypes;
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
