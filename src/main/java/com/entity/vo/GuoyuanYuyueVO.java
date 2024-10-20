package com.entity.vo;

import com.entity.GuoyuanYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 果园预约
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("guoyuan_yuyue")
public class GuoyuanYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名编号
     */

    @TableField(value = "guoyuan_yuyue_uuid_number")
    private String guoyuanYuyueUuidNumber;


    /**
     * 果园
     */

    @TableField(value = "guoyuan_id")
    private Integer guoyuanId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 报名理由
     */

    @TableField(value = "guoyuan_yuyue_text")
    private String guoyuanYuyueText;


    /**
     * 报名状态
     */

    @TableField(value = "guoyuan_yuyue_yesno_types")
    private Integer guoyuanYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "guoyuan_yuyue_yesno_text")
    private String guoyuanYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "guoyuan_yuyue_shenhe_time")
    private Date guoyuanYuyueShenheTime;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "guoyuan_yuyue_time")
    private Date guoyuanYuyueTime;


    /**
     * 活动报名时间
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
	 * 设置：报名编号
	 */
    public String getGuoyuanYuyueUuidNumber() {
        return guoyuanYuyueUuidNumber;
    }


    /**
	 * 获取：报名编号
	 */

    public void setGuoyuanYuyueUuidNumber(String guoyuanYuyueUuidNumber) {
        this.guoyuanYuyueUuidNumber = guoyuanYuyueUuidNumber;
    }
    /**
	 * 设置：果园
	 */
    public Integer getGuoyuanId() {
        return guoyuanId;
    }


    /**
	 * 获取：果园
	 */

    public void setGuoyuanId(Integer guoyuanId) {
        this.guoyuanId = guoyuanId;
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
	 * 设置：报名理由
	 */
    public String getGuoyuanYuyueText() {
        return guoyuanYuyueText;
    }


    /**
	 * 获取：报名理由
	 */

    public void setGuoyuanYuyueText(String guoyuanYuyueText) {
        this.guoyuanYuyueText = guoyuanYuyueText;
    }
    /**
	 * 设置：报名状态
	 */
    public Integer getGuoyuanYuyueYesnoTypes() {
        return guoyuanYuyueYesnoTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setGuoyuanYuyueYesnoTypes(Integer guoyuanYuyueYesnoTypes) {
        this.guoyuanYuyueYesnoTypes = guoyuanYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getGuoyuanYuyueYesnoText() {
        return guoyuanYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setGuoyuanYuyueYesnoText(String guoyuanYuyueYesnoText) {
        this.guoyuanYuyueYesnoText = guoyuanYuyueYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getGuoyuanYuyueShenheTime() {
        return guoyuanYuyueShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setGuoyuanYuyueShenheTime(Date guoyuanYuyueShenheTime) {
        this.guoyuanYuyueShenheTime = guoyuanYuyueShenheTime;
    }
    /**
	 * 设置：预约时间
	 */
    public Date getGuoyuanYuyueTime() {
        return guoyuanYuyueTime;
    }


    /**
	 * 获取：预约时间
	 */

    public void setGuoyuanYuyueTime(Date guoyuanYuyueTime) {
        this.guoyuanYuyueTime = guoyuanYuyueTime;
    }
    /**
	 * 设置：活动报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：活动报名时间
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
