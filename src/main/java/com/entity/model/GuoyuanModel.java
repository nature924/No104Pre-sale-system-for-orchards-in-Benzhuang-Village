package com.entity.model;

import com.entity.GuoyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 果园
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GuoyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 果园名称
     */
    private String guoyuanName;


    /**
     * 果园照片
     */
    private String guoyuanPhoto;


    /**
     * 果园类型
     */
    private Integer guoyuanTypes;


    /**
     * 果园地点
     */
    private String guoyuanAddress;


    /**
     * 果园介绍
     */
    private String guoyuanContent;


    /**
     * 逻辑删除
     */
    private Integer guoyuanDelete;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
