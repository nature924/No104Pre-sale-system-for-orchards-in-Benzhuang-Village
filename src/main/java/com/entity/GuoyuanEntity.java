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
 * 果园
 *
 * @author 
 * @email
 */
@TableName("guoyuan")
public class GuoyuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GuoyuanEntity() {

	}

	public GuoyuanEntity(T t) {
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
     * 果园名称
     */
    @ColumnInfo(comment="果园名称",type="varchar(200)")
    @TableField(value = "guoyuan_name")

    private String guoyuanName;


    /**
     * 果园照片
     */
    @ColumnInfo(comment="果园照片",type="varchar(200)")
    @TableField(value = "guoyuan_photo")

    private String guoyuanPhoto;


    /**
     * 果园类型
     */
    @ColumnInfo(comment="果园类型",type="int(11)")
    @TableField(value = "guoyuan_types")

    private Integer guoyuanTypes;


    /**
     * 果园地点
     */
    @ColumnInfo(comment="果园地点",type="varchar(200)")
    @TableField(value = "guoyuan_address")

    private String guoyuanAddress;


    /**
     * 果园介绍
     */
    @ColumnInfo(comment="果园介绍",type="longtext")
    @TableField(value = "guoyuan_content")

    private String guoyuanContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "guoyuan_delete")

    private Integer guoyuanDelete;


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
	 * 获取：果园名称
	 */
    public String getGuoyuanName() {
        return guoyuanName;
    }
    /**
	 * 设置：果园名称
	 */

    public void setGuoyuanName(String guoyuanName) {
        this.guoyuanName = guoyuanName;
    }
    /**
	 * 获取：果园照片
	 */
    public String getGuoyuanPhoto() {
        return guoyuanPhoto;
    }
    /**
	 * 设置：果园照片
	 */

    public void setGuoyuanPhoto(String guoyuanPhoto) {
        this.guoyuanPhoto = guoyuanPhoto;
    }
    /**
	 * 获取：果园类型
	 */
    public Integer getGuoyuanTypes() {
        return guoyuanTypes;
    }
    /**
	 * 设置：果园类型
	 */

    public void setGuoyuanTypes(Integer guoyuanTypes) {
        this.guoyuanTypes = guoyuanTypes;
    }
    /**
	 * 获取：果园地点
	 */
    public String getGuoyuanAddress() {
        return guoyuanAddress;
    }
    /**
	 * 设置：果园地点
	 */

    public void setGuoyuanAddress(String guoyuanAddress) {
        this.guoyuanAddress = guoyuanAddress;
    }
    /**
	 * 获取：果园介绍
	 */
    public String getGuoyuanContent() {
        return guoyuanContent;
    }
    /**
	 * 设置：果园介绍
	 */

    public void setGuoyuanContent(String guoyuanContent) {
        this.guoyuanContent = guoyuanContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getGuoyuanDelete() {
        return guoyuanDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setGuoyuanDelete(Integer guoyuanDelete) {
        this.guoyuanDelete = guoyuanDelete;
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
        return "Guoyuan{" +
            ", id=" + id +
            ", guoyuanName=" + guoyuanName +
            ", guoyuanPhoto=" + guoyuanPhoto +
            ", guoyuanTypes=" + guoyuanTypes +
            ", guoyuanAddress=" + guoyuanAddress +
            ", guoyuanContent=" + guoyuanContent +
            ", guoyuanDelete=" + guoyuanDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
