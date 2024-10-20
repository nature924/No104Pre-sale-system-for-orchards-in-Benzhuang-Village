package com.entity.vo;

import com.entity.GuoshuOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 果树订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("guoshu_order")
public class GuoshuOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单编号
     */

    @TableField(value = "guoshu_order_uuid_number")
    private String guoshuOrderUuidNumber;


    /**
     * 果树
     */

    @TableField(value = "guoshu_id")
    private Integer guoshuId;


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

    @TableField(value = "guoshu_order_true_price")
    private Double guoshuOrderTruePrice;


    /**
     * 订单类型
     */

    @TableField(value = "guoshu_order_types")
    private Integer guoshuOrderTypes;


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
    public String getGuoshuOrderUuidNumber() {
        return guoshuOrderUuidNumber;
    }


    /**
	 * 获取：订单编号
	 */

    public void setGuoshuOrderUuidNumber(String guoshuOrderUuidNumber) {
        this.guoshuOrderUuidNumber = guoshuOrderUuidNumber;
    }
    /**
	 * 设置：果树
	 */
    public Integer getGuoshuId() {
        return guoshuId;
    }


    /**
	 * 获取：果树
	 */

    public void setGuoshuId(Integer guoshuId) {
        this.guoshuId = guoshuId;
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
    public Double getGuoshuOrderTruePrice() {
        return guoshuOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setGuoshuOrderTruePrice(Double guoshuOrderTruePrice) {
        this.guoshuOrderTruePrice = guoshuOrderTruePrice;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getGuoshuOrderTypes() {
        return guoshuOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setGuoshuOrderTypes(Integer guoshuOrderTypes) {
        this.guoshuOrderTypes = guoshuOrderTypes;
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
