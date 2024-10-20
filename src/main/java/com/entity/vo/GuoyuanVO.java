package com.entity.vo;

import com.entity.GuoyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 果园
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("guoyuan")
public class GuoyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 果园名称
     */

    @TableField(value = "guoyuan_name")
    private String guoyuanName;


    /**
     * 果园照片
     */

    @TableField(value = "guoyuan_photo")
    private String guoyuanPhoto;


    /**
     * 果园类型
     */

    @TableField(value = "guoyuan_types")
    private Integer guoyuanTypes;


    /**
     * 果园地点
     */

    @TableField(value = "guoyuan_address")
    private String guoyuanAddress;


    /**
     * 果园介绍
     */

    @TableField(value = "guoyuan_content")
    private String guoyuanContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "guoyuan_delete")
    private Integer guoyuanDelete;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 设置：果园名称
	 */
    public String getGuoyuanName() {
        return guoyuanName;
    }


    /**
	 * 获取：果园名称
	 */

    public void setGuoyuanName(String guoyuanName) {
        this.guoyuanName = guoyuanName;
    }
    /**
	 * 设置：果园照片
	 */
    public String getGuoyuanPhoto() {
        return guoyuanPhoto;
    }


    /**
	 * 获取：果园照片
	 */

    public void setGuoyuanPhoto(String guoyuanPhoto) {
        this.guoyuanPhoto = guoyuanPhoto;
    }
    /**
	 * 设置：果园类型
	 */
    public Integer getGuoyuanTypes() {
        return guoyuanTypes;
    }


    /**
	 * 获取：果园类型
	 */

    public void setGuoyuanTypes(Integer guoyuanTypes) {
        this.guoyuanTypes = guoyuanTypes;
    }
    /**
	 * 设置：果园地点
	 */
    public String getGuoyuanAddress() {
        return guoyuanAddress;
    }


    /**
	 * 获取：果园地点
	 */

    public void setGuoyuanAddress(String guoyuanAddress) {
        this.guoyuanAddress = guoyuanAddress;
    }
    /**
	 * 设置：果园介绍
	 */
    public String getGuoyuanContent() {
        return guoyuanContent;
    }


    /**
	 * 获取：果园介绍
	 */

    public void setGuoyuanContent(String guoyuanContent) {
        this.guoyuanContent = guoyuanContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getGuoyuanDelete() {
        return guoyuanDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setGuoyuanDelete(Integer guoyuanDelete) {
        this.guoyuanDelete = guoyuanDelete;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
