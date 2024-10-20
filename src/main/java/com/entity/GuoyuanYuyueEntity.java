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
 * 果园预约
 *
 * @author 
 * @email
 */
@TableName("guoyuan_yuyue")
public class GuoyuanYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GuoyuanYuyueEntity() {

	}

	public GuoyuanYuyueEntity(T t) {
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
     * 报名编号
     */
    @ColumnInfo(comment="报名编号",type="varchar(200)")
    @TableField(value = "guoyuan_yuyue_uuid_number")

    private String guoyuanYuyueUuidNumber;


    /**
     * 果园
     */
    @ColumnInfo(comment="果园",type="int(11)")
    @TableField(value = "guoyuan_id")

    private Integer guoyuanId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 报名理由
     */
    @ColumnInfo(comment="报名理由",type="longtext")
    @TableField(value = "guoyuan_yuyue_text")

    private String guoyuanYuyueText;


    /**
     * 报名状态
     */
    @ColumnInfo(comment="报名状态",type="int(11)")
    @TableField(value = "guoyuan_yuyue_yesno_types")

    private Integer guoyuanYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "guoyuan_yuyue_yesno_text")

    private String guoyuanYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "guoyuan_yuyue_shenhe_time")

    private Date guoyuanYuyueShenheTime;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="预约时间",type="timestamp")
    @TableField(value = "guoyuan_yuyue_time")

    private Date guoyuanYuyueTime;


    /**
     * 活动报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="活动报名时间",type="timestamp")
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
	 * 获取：报名编号
	 */
    public String getGuoyuanYuyueUuidNumber() {
        return guoyuanYuyueUuidNumber;
    }
    /**
	 * 设置：报名编号
	 */

    public void setGuoyuanYuyueUuidNumber(String guoyuanYuyueUuidNumber) {
        this.guoyuanYuyueUuidNumber = guoyuanYuyueUuidNumber;
    }
    /**
	 * 获取：果园
	 */
    public Integer getGuoyuanId() {
        return guoyuanId;
    }
    /**
	 * 设置：果园
	 */

    public void setGuoyuanId(Integer guoyuanId) {
        this.guoyuanId = guoyuanId;
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
	 * 获取：报名理由
	 */
    public String getGuoyuanYuyueText() {
        return guoyuanYuyueText;
    }
    /**
	 * 设置：报名理由
	 */

    public void setGuoyuanYuyueText(String guoyuanYuyueText) {
        this.guoyuanYuyueText = guoyuanYuyueText;
    }
    /**
	 * 获取：报名状态
	 */
    public Integer getGuoyuanYuyueYesnoTypes() {
        return guoyuanYuyueYesnoTypes;
    }
    /**
	 * 设置：报名状态
	 */

    public void setGuoyuanYuyueYesnoTypes(Integer guoyuanYuyueYesnoTypes) {
        this.guoyuanYuyueYesnoTypes = guoyuanYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getGuoyuanYuyueYesnoText() {
        return guoyuanYuyueYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setGuoyuanYuyueYesnoText(String guoyuanYuyueYesnoText) {
        this.guoyuanYuyueYesnoText = guoyuanYuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getGuoyuanYuyueShenheTime() {
        return guoyuanYuyueShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setGuoyuanYuyueShenheTime(Date guoyuanYuyueShenheTime) {
        this.guoyuanYuyueShenheTime = guoyuanYuyueShenheTime;
    }
    /**
	 * 获取：预约时间
	 */
    public Date getGuoyuanYuyueTime() {
        return guoyuanYuyueTime;
    }
    /**
	 * 设置：预约时间
	 */

    public void setGuoyuanYuyueTime(Date guoyuanYuyueTime) {
        this.guoyuanYuyueTime = guoyuanYuyueTime;
    }
    /**
	 * 获取：活动报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：活动报名时间
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
        return "GuoyuanYuyue{" +
            ", id=" + id +
            ", guoyuanYuyueUuidNumber=" + guoyuanYuyueUuidNumber +
            ", guoyuanId=" + guoyuanId +
            ", yonghuId=" + yonghuId +
            ", guoyuanYuyueText=" + guoyuanYuyueText +
            ", guoyuanYuyueYesnoTypes=" + guoyuanYuyueYesnoTypes +
            ", guoyuanYuyueYesnoText=" + guoyuanYuyueYesnoText +
            ", guoyuanYuyueShenheTime=" + DateUtil.convertString(guoyuanYuyueShenheTime,"yyyy-MM-dd") +
            ", guoyuanYuyueTime=" + DateUtil.convertString(guoyuanYuyueTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
