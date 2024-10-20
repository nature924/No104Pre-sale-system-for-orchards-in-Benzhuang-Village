package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 水果预售订单
 *
 * @author 
 * @email
 */
@TableName("shuiguo_order")
public class ShuiguoOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShuiguoOrderEntity() {

	}

	public ShuiguoOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 订单编号
     */
    @ColumnInfo(comment="订单编号",type="varchar(200)")
    @TableField(value = "shuiguo_order_uuid_number")

    private String shuiguoOrderUuidNumber;


    /**
     * 收货地址
     */
    @ColumnInfo(comment="收货地址",type="int(11)")
    @TableField(value = "address_id")

    private Integer addressId;


    /**
     * 水果
     */
    @ColumnInfo(comment="水果",type="int(11)")
    @TableField(value = "shuiguo_id")

    private Integer shuiguoId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 购买数量
     */
    @ColumnInfo(comment="购买数量",type="int(11)")
    @TableField(value = "buy_number")

    private Integer buyNumber;


    /**
     * 实付价格
     */
    @ColumnInfo(comment="实付价格",type="decimal(10,2)")
    @TableField(value = "shuiguo_order_true_price")

    private Double shuiguoOrderTruePrice;


    /**
     * 快递公司
     */
    @ColumnInfo(comment="快递公司",type="varchar(200)")
    @TableField(value = "guoyuan_order_courier_name")

    private String guoyuanOrderCourierName;


    /**
     * 快递单号
     */
    @ColumnInfo(comment="快递单号",type="varchar(200)")
    @TableField(value = "guoyuan_order_courier_number")

    private String guoyuanOrderCourierNumber;


    /**
     * 订单类型
     */
    @ColumnInfo(comment="订单类型",type="int(11)")
    @TableField(value = "shuiguo_order_types")

    private Integer shuiguoOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="订单创建时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ShuiguoOrder{" +
            ", id=" + id +
            ", shuiguoOrderUuidNumber=" + shuiguoOrderUuidNumber +
            ", addressId=" + addressId +
            ", shuiguoId=" + shuiguoId +
            ", yonghuId=" + yonghuId +
            ", buyNumber=" + buyNumber +
            ", shuiguoOrderTruePrice=" + shuiguoOrderTruePrice +
            ", guoyuanOrderCourierName=" + guoyuanOrderCourierName +
            ", guoyuanOrderCourierNumber=" + guoyuanOrderCourierNumber +
            ", shuiguoOrderTypes=" + shuiguoOrderTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
