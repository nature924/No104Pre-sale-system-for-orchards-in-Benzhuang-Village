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
 * 果树
 *
 * @author 
 * @email
 */
@TableName("guoshu")
public class GuoshuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GuoshuEntity() {

	}

	public GuoshuEntity(T t) {
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
     * 商家
     */
    @ColumnInfo(comment="商家",type="int(11)")
    @TableField(value = "guoyuan_id")

    private Integer guoyuanId;


    /**
     * 果树名称
     */
    @ColumnInfo(comment="果树名称",type="varchar(200)")
    @TableField(value = "guoshu_name")

    private String guoshuName;


    /**
     * 果树编号
     */
    @ColumnInfo(comment="果树编号",type="varchar(200)")
    @TableField(value = "guoshu_uuid_number")

    private String guoshuUuidNumber;


    /**
     * 果树照片
     */
    @ColumnInfo(comment="果树照片",type="varchar(200)")
    @TableField(value = "guoshu_photo")

    private String guoshuPhoto;


    /**
     * 果树地点
     */
    @ColumnInfo(comment="果树地点",type="varchar(200)")
    @TableField(value = "guoshu_address")

    private String guoshuAddress;


    /**
     * 果树认养费用
     */
    @ColumnInfo(comment="果树认养费用",type="decimal(10,2)")
    @TableField(value = "guoshu_new_money")

    private Double guoshuNewMoney;


    /**
     * 果树类型
     */
    @ColumnInfo(comment="果树类型",type="int(11)")
    @TableField(value = "guoshu_types")

    private Integer guoshuTypes;


    /**
     * 果树库存
     */
    @ColumnInfo(comment="果树库存",type="int(11)")
    @TableField(value = "guoshu_kucun_number")

    private Integer guoshuKucunNumber;


    /**
     * 果树介绍
     */
    @ColumnInfo(comment="果树介绍",type="longtext")
    @TableField(value = "guoshu_content")

    private String guoshuContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "guoshu_delete")

    private Integer guoshuDelete;


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
	 * 获取：商家
	 */
    public Integer getGuoyuanId() {
        return guoyuanId;
    }
    /**
	 * 设置：商家
	 */

    public void setGuoyuanId(Integer guoyuanId) {
        this.guoyuanId = guoyuanId;
    }
    /**
	 * 获取：果树名称
	 */
    public String getGuoshuName() {
        return guoshuName;
    }
    /**
	 * 设置：果树名称
	 */

    public void setGuoshuName(String guoshuName) {
        this.guoshuName = guoshuName;
    }
    /**
	 * 获取：果树编号
	 */
    public String getGuoshuUuidNumber() {
        return guoshuUuidNumber;
    }
    /**
	 * 设置：果树编号
	 */

    public void setGuoshuUuidNumber(String guoshuUuidNumber) {
        this.guoshuUuidNumber = guoshuUuidNumber;
    }
    /**
	 * 获取：果树照片
	 */
    public String getGuoshuPhoto() {
        return guoshuPhoto;
    }
    /**
	 * 设置：果树照片
	 */

    public void setGuoshuPhoto(String guoshuPhoto) {
        this.guoshuPhoto = guoshuPhoto;
    }
    /**
	 * 获取：果树地点
	 */
    public String getGuoshuAddress() {
        return guoshuAddress;
    }
    /**
	 * 设置：果树地点
	 */

    public void setGuoshuAddress(String guoshuAddress) {
        this.guoshuAddress = guoshuAddress;
    }
    /**
	 * 获取：果树认养费用
	 */
    public Double getGuoshuNewMoney() {
        return guoshuNewMoney;
    }
    /**
	 * 设置：果树认养费用
	 */

    public void setGuoshuNewMoney(Double guoshuNewMoney) {
        this.guoshuNewMoney = guoshuNewMoney;
    }
    /**
	 * 获取：果树类型
	 */
    public Integer getGuoshuTypes() {
        return guoshuTypes;
    }
    /**
	 * 设置：果树类型
	 */

    public void setGuoshuTypes(Integer guoshuTypes) {
        this.guoshuTypes = guoshuTypes;
    }
    /**
	 * 获取：果树库存
	 */
    public Integer getGuoshuKucunNumber() {
        return guoshuKucunNumber;
    }
    /**
	 * 设置：果树库存
	 */

    public void setGuoshuKucunNumber(Integer guoshuKucunNumber) {
        this.guoshuKucunNumber = guoshuKucunNumber;
    }
    /**
	 * 获取：果树介绍
	 */
    public String getGuoshuContent() {
        return guoshuContent;
    }
    /**
	 * 设置：果树介绍
	 */

    public void setGuoshuContent(String guoshuContent) {
        this.guoshuContent = guoshuContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getGuoshuDelete() {
        return guoshuDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setGuoshuDelete(Integer guoshuDelete) {
        this.guoshuDelete = guoshuDelete;
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
        return "Guoshu{" +
            ", id=" + id +
            ", guoyuanId=" + guoyuanId +
            ", guoshuName=" + guoshuName +
            ", guoshuUuidNumber=" + guoshuUuidNumber +
            ", guoshuPhoto=" + guoshuPhoto +
            ", guoshuAddress=" + guoshuAddress +
            ", guoshuNewMoney=" + guoshuNewMoney +
            ", guoshuTypes=" + guoshuTypes +
            ", guoshuKucunNumber=" + guoshuKucunNumber +
            ", guoshuContent=" + guoshuContent +
            ", guoshuDelete=" + guoshuDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
