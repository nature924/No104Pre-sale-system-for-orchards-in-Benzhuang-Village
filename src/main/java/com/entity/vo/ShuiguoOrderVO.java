package com.entity.vo;

import com.entity.ShuiguoOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 水果预售订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shuiguo_order")
public class ShuiguoOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单编号
     */

    @TableField(value = "shuiguo_order_uuid_number")
    private String shuiguoOrderUuidNumber;


    /**
     * 收货地址
     */

    @TableField(value = "address_id")
    private Integer addressId;


    /**
     * 水果
     */

    @TableField(value = "shuiguo_id")
    private Integer shuiguoId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 购买数量
     */

    @TableField(value = "buy_number")
    private Integer buyNumber;


    /**
     * 实付价格
     */

    @TableField(value = "shuiguo_order_true_price")
    private Double shuiguoOrderTruePrice;


    /**
     * 快递公司
     */

    @TableField(value = "guoyuan_order_courier_name")
    private String guoyuanOrderCourierName;


    /**
     * 快递单号
     */

    @TableField(value = "guoyuan_order_courier_number")
    private String guoyuanOrderCourierNumber;


    /**
     * 订单类型
     */

    @TableField(value = "shuiguo_order_types")
    private Integer shuiguoOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单编号
	 */
    public String getShuiguoOrderUuidNumber() {
        return shuiguoOrderUuidNumber;
    }


    /**
	 * 获取：订单编号
	 */

    public void setShuiguoOrderUuidNumber(String shuiguoOrderUuidNumber) {
        this.shuiguoOrderUuidNumber = shuiguoOrderUuidNumber;
    }
    /**
	 * 设置：收货地址
	 */
    public Integer getAddressId() {
        return addressId;
    }


    /**
	 * 获取：收货地址
	 */

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 设置：水果
	 */
    public Integer getShuiguoId() {
        return shuiguoId;
    }


    /**
	 * 获取：水果
	 */

    public void setShuiguoId(Integer shuiguoId) {
        this.shuiguoId = shuiguoId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 获取：购买数量
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getShuiguoOrderTruePrice() {
        return shuiguoOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setShuiguoOrderTruePrice(Double shuiguoOrderTruePrice) {
        this.shuiguoOrderTruePrice = shuiguoOrderTruePrice;
    }
    /**
	 * 设置：快递公司
	 */
    public String getGuoyuanOrderCourierName() {
        return guoyuanOrderCourierName;
    }


    /**
	 * 获取：快递公司
	 */

    public void setGuoyuanOrderCourierName(String guoyuanOrderCourierName) {
        this.guoyuanOrderCourierName = guoyuanOrderCourierName;
    }
    /**
	 * 设置：快递单号
	 */
    public String getGuoyuanOrderCourierNumber() {
        return guoyuanOrderCourierNumber;
    }


    /**
	 * 获取：快递单号
	 */

    public void setGuoyuanOrderCourierNumber(String guoyuanOrderCourierNumber) {
        this.guoyuanOrderCourierNumber = guoyuanOrderCourierNumber;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getShuiguoOrderTypes() {
        return shuiguoOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setShuiguoOrderTypes(Integer shuiguoOrderTypes) {
        this.shuiguoOrderTypes = shuiguoOrderTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
