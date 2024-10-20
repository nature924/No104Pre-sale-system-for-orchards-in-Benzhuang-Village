package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.GuoyuanYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 果园预约
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("guoyuan_yuyue")
public class GuoyuanYuyueView extends GuoyuanYuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 报名状态的值
	*/
	@ColumnInfo(comment="报名状态的字典表值",type="varchar(200)")
	private String guoyuanYuyueYesnoValue;

	//级联表 果园
		/**
		* 果园名称
		*/

		@ColumnInfo(comment="果园名称",type="varchar(200)")
		private String guoyuanName;
		/**
		* 果园照片
		*/

		@ColumnInfo(comment="果园照片",type="varchar(200)")
		private String guoyuanPhoto;
		/**
		* 果园类型
		*/
		@ColumnInfo(comment="果园类型",type="int(11)")
		private Integer guoyuanTypes;
			/**
			* 果园类型的值
			*/
			@ColumnInfo(comment="果园类型的字典表值",type="varchar(200)")
			private String guoyuanValue;
		/**
		* 果园地点
		*/

		@ColumnInfo(comment="果园地点",type="varchar(200)")
		private String guoyuanAddress;
		/**
		* 果园介绍
		*/

		@ColumnInfo(comment="果园介绍",type="longtext")
		private String guoyuanContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer guoyuanDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;



	public GuoyuanYuyueView() {

	}

	public GuoyuanYuyueView(GuoyuanYuyueEntity guoyuanYuyueEntity) {
		try {
			BeanUtils.copyProperties(this, guoyuanYuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 报名状态的值
	*/
	public String getGuoyuanYuyueYesnoValue() {
		return guoyuanYuyueYesnoValue;
	}
	/**
	* 设置： 报名状态的值
	*/
	public void setGuoyuanYuyueYesnoValue(String guoyuanYuyueYesnoValue) {
		this.guoyuanYuyueYesnoValue = guoyuanYuyueYesnoValue;
	}


	//级联表的get和set 果园

		/**
		* 获取： 果园名称
		*/
		public String getGuoyuanName() {
			return guoyuanName;
		}
		/**
		* 设置： 果园名称
		*/
		public void setGuoyuanName(String guoyuanName) {
			this.guoyuanName = guoyuanName;
		}

		/**
		* 获取： 果园照片
		*/
		public String getGuoyuanPhoto() {
			return guoyuanPhoto;
		}
		/**
		* 设置： 果园照片
		*/
		public void setGuoyuanPhoto(String guoyuanPhoto) {
			this.guoyuanPhoto = guoyuanPhoto;
		}
		/**
		* 获取： 果园类型
		*/
		public Integer getGuoyuanTypes() {
			return guoyuanTypes;
		}
		/**
		* 设置： 果园类型
		*/
		public void setGuoyuanTypes(Integer guoyuanTypes) {
			this.guoyuanTypes = guoyuanTypes;
		}


			/**
			* 获取： 果园类型的值
			*/
			public String getGuoyuanValue() {
				return guoyuanValue;
			}
			/**
			* 设置： 果园类型的值
			*/
			public void setGuoyuanValue(String guoyuanValue) {
				this.guoyuanValue = guoyuanValue;
			}

		/**
		* 获取： 果园地点
		*/
		public String getGuoyuanAddress() {
			return guoyuanAddress;
		}
		/**
		* 设置： 果园地点
		*/
		public void setGuoyuanAddress(String guoyuanAddress) {
			this.guoyuanAddress = guoyuanAddress;
		}

		/**
		* 获取： 果园介绍
		*/
		public String getGuoyuanContent() {
			return guoyuanContent;
		}
		/**
		* 设置： 果园介绍
		*/
		public void setGuoyuanContent(String guoyuanContent) {
			this.guoyuanContent = guoyuanContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getGuoyuanDelete() {
			return guoyuanDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setGuoyuanDelete(Integer guoyuanDelete) {
			this.guoyuanDelete = guoyuanDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}


	@Override
	public String toString() {
		return "GuoyuanYuyueView{" +
			", guoyuanYuyueYesnoValue=" + guoyuanYuyueYesnoValue +
			", guoyuanName=" + guoyuanName +
			", guoyuanPhoto=" + guoyuanPhoto +
			", guoyuanAddress=" + guoyuanAddress +
			", guoyuanContent=" + guoyuanContent +
			", guoyuanDelete=" + guoyuanDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", newMoney=" + newMoney +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
