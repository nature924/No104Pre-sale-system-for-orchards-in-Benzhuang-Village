package com.entity.vo;

import com.entity.GuoshuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 果树
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("guoshu")
public class GuoshuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 商家
     */

    @TableField(value = "guoyuan_id")
    private Integer guoyuanId;


    /**
     * 果树名称
     */

    @TableField(value = "guoshu_name")
    private String guoshuName;


    /**
     * 果树编号
     */

    @TableField(value = "guoshu_uuid_number")
    private String guoshuUuidNumber;


    /**
     * 果树照片
     */

    @TableField(value = "guoshu_photo")
    private String guoshuPhoto;


    /**
     * 果树地点
     */

    @TableField(value = "guoshu_address")
    private String guoshuAddress;


    /**
     * 果树认养费用
     */

    @TableField(value = "guoshu_new_money")
    private Double guoshuNewMoney;


    /**
     * 果树类型
     */

    @TableField(value = "guoshu_types")
    private Integer guoshuTypes;


    /**
     * 果树库存
     */

    @TableField(value = "guoshu_kucun_number")
    private Integer guoshuKucunNumber;


    /**
     * 果树介绍
     */

    @TableField(value = "guoshu_content")
    private String guoshuContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "guoshu_delete")
    private Integer guoshuDelete;


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
	 * 设置：商家
	 */
    public Integer getGuoyuanId() {
        return guoyuanId;
    }


    /**
	 * 获取：商家
	 */

    public void setGuoyuanId(Integer guoyuanId) {
        this.guoyuanId = guoyuanId;
    }
    /**
	 * 设置：果树名称
	 */
    public String getGuoshuName() {
        return guoshuName;
    }


    /**
	 * 获取：果树名称
	 */

    public void setGuoshuName(String guoshuName) {
        this.guoshuName = guoshuName;
    }
    /**
	 * 设置：果树编号
	 */
    public String getGuoshuUuidNumber() {
        return guoshuUuidNumber;
    }


    /**
	 * 获取：果树编号
	 */

    public void setGuoshuUuidNumber(String guoshuUuidNumber) {
        this.guoshuUuidNumber = guoshuUuidNumber;
    }
    /**
	 * 设置：果树照片
	 */
    public String getGuoshuPhoto() {
        return guoshuPhoto;
    }


    /**
	 * 获取：果树照片
	 */

    public void setGuoshuPhoto(String guoshuPhoto) {
        this.guoshuPhoto = guoshuPhoto;
    }
    /**
	 * 设置：果树地点
	 */
    public String getGuoshuAddress() {
        return guoshuAddress;
    }


    /**
	 * 获取：果树地点
	 */

    public void setGuoshuAddress(String guoshuAddress) {
        this.guoshuAddress = guoshuAddress;
    }
    /**
	 * 设置：果树认养费用
	 */
    public Double getGuoshuNewMoney() {
        return guoshuNewMoney;
    }


    /**
	 * 获取：果树认养费用
	 */

    public void setGuoshuNewMoney(Double guoshuNewMoney) {
        this.guoshuNewMoney = guoshuNewMoney;
    }
    /**
	 * 设置：果树类型
	 */
    public Integer getGuoshuTypes() {
        return guoshuTypes;
    }


    /**
	 * 获取：果树类型
	 */

    public void setGuoshuTypes(Integer guoshuTypes) {
        this.guoshuTypes = guoshuTypes;
    }
    /**
	 * 设置：果树库存
	 */
    public Integer getGuoshuKucunNumber() {
        return guoshuKucunNumber;
    }


    /**
	 * 获取：果树库存
	 */

    public void setGuoshuKucunNumber(Integer guoshuKucunNumber) {
        this.guoshuKucunNumber = guoshuKucunNumber;
    }
    /**
	 * 设置：果树介绍
	 */
    public String getGuoshuContent() {
        return guoshuContent;
    }


    /**
	 * 获取：果树介绍
	 */

    public void setGuoshuContent(String guoshuContent) {
        this.guoshuContent = guoshuContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getGuoshuDelete() {
        return guoshuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setGuoshuDelete(Integer guoshuDelete) {
        this.guoshuDelete = guoshuDelete;
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
