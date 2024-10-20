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
 * 水果预售
 *
 * @author 
 * @email
 */
@TableName("shuiguo")
public class ShuiguoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShuiguoEntity() {

	}

	public ShuiguoEntity(T t) {
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
     * 水果
     */
    @ColumnInfo(comment="水果",type="int(11)")
    @TableField(value = "guoyuan_id")

    private Integer guoyuanId;


    /**
     * 水果名称
     */
    @ColumnInfo(comment="水果名称",type="varchar(200)")
    @TableField(value = "shuiguo_name")

    private String shuiguoName;


    /**
     * 水果编号
     */
    @ColumnInfo(comment="水果编号",type="varchar(200)")
    @TableField(value = "shuiguo_uuid_number")

    private String shuiguoUuidNumber;


    /**
     * 水果照片
     */
    @ColumnInfo(comment="水果照片",type="varchar(200)")
    @TableField(value = "shuiguo_photo")

    private String shuiguoPhoto;


    /**
     * 水果地点
     */
    @ColumnInfo(comment="水果地点",type="varchar(200)")
    @TableField(value = "shuiguo_address")

    private String shuiguoAddress;


    /**
     * 预售价
     */
    @ColumnInfo(comment="预售价",type="decimal(10,2)")
    @TableField(value = "shuiguo_new_money")

    private Double shuiguoNewMoney;


    /**
     * 水果类型
     */
    @ColumnInfo(comment="水果类型",type="int(11)")
    @TableField(value = "shuiguo_types")

    private Integer shuiguoTypes;


    /**
     * 水果库存
     */
    @ColumnInfo(comment="水果库存",type="int(11)")
    @TableField(value = "shuiguo_kucun_number")

    private Integer shuiguoKucunNumber;


    /**
     * 水果介绍
     */
    @ColumnInfo(comment="水果介绍",type="longtext")
    @TableField(value = "shuiguo_content")

    private String shuiguoContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "shuiguo_delete")

    private Integer shuiguoDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：水果
	 */
    public Integer getGuoyuanId() {
        return guoyuanId;
    }
    /**
	 * 设置：水果
	 */

    public void setGuoyuanId(Integer guoyuanId) {
        this.guoyuanId = guoyuanId;
    }
    /**
	 * 获取：水果名称
	 */
    public String getShuiguoName() {
        return shuiguoName;
    }
    /**
	 * 设置：水果名称
	 */

    public void setShuiguoName(String shuiguoName) {
        this.shuiguoName = shuiguoName;
    }
    /**
	 * 获取：水果编号
	 */
    public String getShuiguoUuidNumber() {
        return shuiguoUuidNumber;
    }
    /**
	 * 设置：水果编号
	 */

    public void setShuiguoUuidNumber(String shuiguoUuidNumber) {
        this.shuiguoUuidNumber = shuiguoUuidNumber;
    }
    /**
	 * 获取：水果照片
	 */
    public String getShuiguoPhoto() {
        return shuiguoPhoto;
    }
    /**
	 * 设置：水果照片
	 */

    public void setShuiguoPhoto(String shuiguoPhoto) {
        this.shuiguoPhoto = shuiguoPhoto;
    }
    /**
	 * 获取：水果地点
	 */
    public String getShuiguoAddress() {
        return shuiguoAddress;
    }
    /**
	 * 设置：水果地点
	 */

    public void setShuiguoAddress(String shuiguoAddress) {
        this.shuiguoAddress = shuiguoAddress;
    }
    /**
	 * 获取：预售价
	 */
    public Double getShuiguoNewMoney() {
        return shuiguoNewMoney;
    }
    /**
	 * 设置：预售价
	 */

    public void setShuiguoNewMoney(Double shuiguoNewMoney) {
        this.shuiguoNewMoney = shuiguoNewMoney;
    }
    /**
	 * 获取：水果类型
	 */
    public Integer getShuiguoTypes() {
        return shuiguoTypes;
    }
    /**
	 * 设置：水果类型
	 */

    public void setShuiguoTypes(Integer shuiguoTypes) {
        this.shuiguoTypes = shuiguoTypes;
    }
    /**
	 * 获取：水果库存
	 */
    public Integer getShuiguoKucunNumber() {
        return shuiguoKucunNumber;
    }
    /**
	 * 设置：水果库存
	 */

    public void setShuiguoKucunNumber(Integer shuiguoKucunNumber) {
        this.shuiguoKucunNumber = shuiguoKucunNumber;
    }
    /**
	 * 获取：水果介绍
	 */
    public String getShuiguoContent() {
        return shuiguoContent;
    }
    /**
	 * 设置：水果介绍
	 */

    public void setShuiguoContent(String shuiguoContent) {
        this.shuiguoContent = shuiguoContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getShuiguoDelete() {
        return shuiguoDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setShuiguoDelete(Integer shuiguoDelete) {
        this.shuiguoDelete = shuiguoDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Shuiguo{" +
            ", id=" + id +
            ", guoyuanId=" + guoyuanId +
            ", shuiguoName=" + shuiguoName +
            ", shuiguoUuidNumber=" + shuiguoUuidNumber +
            ", shuiguoPhoto=" + shuiguoPhoto +
            ", shuiguoAddress=" + shuiguoAddress +
            ", shuiguoNewMoney=" + shuiguoNewMoney +
            ", shuiguoTypes=" + shuiguoTypes +
            ", shuiguoKucunNumber=" + shuiguoKucunNumber +
            ", shuiguoContent=" + shuiguoContent +
            ", shuiguoDelete=" + shuiguoDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
