package com.entity.vo;

import com.entity.ShuiguoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 水果预售
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shuiguo")
public class ShuiguoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 水果
     */

    @TableField(value = "guoyuan_id")
    private Integer guoyuanId;


    /**
     * 水果名称
     */

    @TableField(value = "shuiguo_name")
    private String shuiguoName;


    /**
     * 水果编号
     */

    @TableField(value = "shuiguo_uuid_number")
    private String shuiguoUuidNumber;


    /**
     * 水果照片
     */

    @TableField(value = "shuiguo_photo")
    private String shuiguoPhoto;


    /**
     * 水果地点
     */

    @TableField(value = "shuiguo_address")
    private String shuiguoAddress;


    /**
     * 预售价
     */

    @TableField(value = "shuiguo_new_money")
    private Double shuiguoNewMoney;


    /**
     * 水果类型
     */

    @TableField(value = "shuiguo_types")
    private Integer shuiguoTypes;


    /**
     * 水果库存
     */

    @TableField(value = "shuiguo_kucun_number")
    private Integer shuiguoKucunNumber;


    /**
     * 水果介绍
     */

    @TableField(value = "shuiguo_content")
    private String shuiguoContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "shuiguo_delete")
    private Integer shuiguoDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：水果
	 */
    public Integer getGuoyuanId() {
        return guoyuanId;
    }


    /**
	 * 获取：水果
	 */

    public void setGuoyuanId(Integer guoyuanId) {
        this.guoyuanId = guoyuanId;
    }
    /**
	 * 设置：水果名称
	 */
    public String getShuiguoName() {
        return shuiguoName;
    }


    /**
	 * 获取：水果名称
	 */

    public void setShuiguoName(String shuiguoName) {
        this.shuiguoName = shuiguoName;
    }
    /**
	 * 设置：水果编号
	 */
    public String getShuiguoUuidNumber() {
        return shuiguoUuidNumber;
    }


    /**
	 * 获取：水果编号
	 */

    public void setShuiguoUuidNumber(String shuiguoUuidNumber) {
        this.shuiguoUuidNumber = shuiguoUuidNumber;
    }
    /**
	 * 设置：水果照片
	 */
    public String getShuiguoPhoto() {
        return shuiguoPhoto;
    }


    /**
	 * 获取：水果照片
	 */

    public void setShuiguoPhoto(String shuiguoPhoto) {
        this.shuiguoPhoto = shuiguoPhoto;
    }
    /**
	 * 设置：水果地点
	 */
    public String getShuiguoAddress() {
        return shuiguoAddress;
    }


    /**
	 * 获取：水果地点
	 */

    public void setShuiguoAddress(String shuiguoAddress) {
        this.shuiguoAddress = shuiguoAddress;
    }
    /**
	 * 设置：预售价
	 */
    public Double getShuiguoNewMoney() {
        return shuiguoNewMoney;
    }


    /**
	 * 获取：预售价
	 */

    public void setShuiguoNewMoney(Double shuiguoNewMoney) {
        this.shuiguoNewMoney = shuiguoNewMoney;
    }
    /**
	 * 设置：水果类型
	 */
    public Integer getShuiguoTypes() {
        return shuiguoTypes;
    }


    /**
	 * 获取：水果类型
	 */

    public void setShuiguoTypes(Integer shuiguoTypes) {
        this.shuiguoTypes = shuiguoTypes;
    }
    /**
	 * 设置：水果库存
	 */
    public Integer getShuiguoKucunNumber() {
        return shuiguoKucunNumber;
    }


    /**
	 * 获取：水果库存
	 */

    public void setShuiguoKucunNumber(Integer shuiguoKucunNumber) {
        this.shuiguoKucunNumber = shuiguoKucunNumber;
    }
    /**
	 * 设置：水果介绍
	 */
    public String getShuiguoContent() {
        return shuiguoContent;
    }


    /**
	 * 获取：水果介绍
	 */

    public void setShuiguoContent(String shuiguoContent) {
        this.shuiguoContent = shuiguoContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getShuiguoDelete() {
        return shuiguoDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setShuiguoDelete(Integer shuiguoDelete) {
        this.shuiguoDelete = shuiguoDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
