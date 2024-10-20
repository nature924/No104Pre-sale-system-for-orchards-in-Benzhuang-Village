package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ShuiguoCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 水果收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("shuiguo_collection")
public class ShuiguoCollectionView extends ShuiguoCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String shuiguoCollectionValue;

	//级联表 水果预售
							/**
		* 水果名称
		*/

		@ColumnInfo(comment="水果名称",type="varchar(200)")
		private String shuiguoName;
		/**
		* 水果编号
		*/

		@ColumnInfo(comment="水果编号",type="varchar(200)")
		private String shuiguoUuidNumber;
		/**
		* 水果照片
		*/

		@ColumnInfo(comment="水果照片",type="varchar(200)")
		private String shuiguoPhoto;
		/**
		* 水果地点
		*/

		@ColumnInfo(comment="水果地点",type="varchar(200)")
		private String shuiguoAddress;
		/**
		* 预售价
		*/
		@ColumnInfo(comment="预售价",type="decimal(10,2)")
		private Double shuiguoNewMoney;
		/**
		* 水果类型
		*/
		@ColumnInfo(comment="水果类型",type="int(11)")
		private Integer shuiguoTypes;
			/**
			* 水果类型的值
			*/
			@ColumnInfo(comment="水果类型的字典表值",type="varchar(200)")
			private String shuiguoValue;
		/**
		* 水果库存
		*/

		@ColumnInfo(comment="水果库存",type="int(11)")
		private Integer shuiguoKucunNumber;
		/**
		* 水果介绍
		*/

		@ColumnInfo(comment="水果介绍",type="longtext")
		private String shuiguoContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer shuiguoDelete;
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



	public ShuiguoCollectionView() {

	}

	public ShuiguoCollectionView(ShuiguoCollectionEntity shuiguoCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, shuiguoCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getShuiguoCollectionValue() {
		return shuiguoCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setShuiguoCollectionValue(String shuiguoCollectionValue) {
		this.shuiguoCollectionValue = shuiguoCollectionValue;
	}


	//级联表的get和set 水果预售

		/**
		* 获取： 水果名称
		*/
		public String getShuiguoName() {
			return shuiguoName;
		}
		/**
		* 设置： 水果名称
		*/
		public void setShuiguoName(String shuiguoName) {
			this.shuiguoName = shuiguoName;
		}

		/**
		* 获取： 水果编号
		*/
		public String getShuiguoUuidNumber() {
			return shuiguoUuidNumber;
		}
		/**
		* 设置： 水果编号
		*/
		public void setShuiguoUuidNumber(String shuiguoUuidNumber) {
			this.shuiguoUuidNumber = shuiguoUuidNumber;
		}

		/**
		* 获取： 水果照片
		*/
		public String getShuiguoPhoto() {
			return shuiguoPhoto;
		}
		/**
		* 设置： 水果照片
		*/
		public void setShuiguoPhoto(String shuiguoPhoto) {
			this.shuiguoPhoto = shuiguoPhoto;
		}

		/**
		* 获取： 水果地点
		*/
		public String getShuiguoAddress() {
			return shuiguoAddress;
		}
		/**
		* 设置： 水果地点
		*/
		public void setShuiguoAddress(String shuiguoAddress) {
			this.shuiguoAddress = shuiguoAddress;
		}

		/**
		* 获取： 预售价
		*/
		public Double getShuiguoNewMoney() {
			return shuiguoNewMoney;
		}
		/**
		* 设置： 预售价
		*/
		public void setShuiguoNewMoney(Double shuiguoNewMoney) {
			this.shuiguoNewMoney = shuiguoNewMoney;
		}
		/**
		* 获取： 水果类型
		*/
		public Integer getShuiguoTypes() {
			return shuiguoTypes;
		}
		/**
		* 设置： 水果类型
		*/
		public void setShuiguoTypes(Integer shuiguoTypes) {
			this.shuiguoTypes = shuiguoTypes;
		}


			/**
			* 获取： 水果类型的值
			*/
			public String getShuiguoValue() {
				return shuiguoValue;
			}
			/**
			* 设置： 水果类型的值
			*/
			public void setShuiguoValue(String shuiguoValue) {
				this.shuiguoValue = shuiguoValue;
			}

		/**
		* 获取： 水果库存
		*/
		public Integer getShuiguoKucunNumber() {
			return shuiguoKucunNumber;
		}
		/**
		* 设置： 水果库存
		*/
		public void setShuiguoKucunNumber(Integer shuiguoKucunNumber) {
			this.shuiguoKucunNumber = shuiguoKucunNumber;
		}

		/**
		* 获取： 水果介绍
		*/
		public String getShuiguoContent() {
			return shuiguoContent;
		}
		/**
		* 设置： 水果介绍
		*/
		public void setShuiguoContent(String shuiguoContent) {
			this.shuiguoContent = shuiguoContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getShuiguoDelete() {
			return shuiguoDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setShuiguoDelete(Integer shuiguoDelete) {
			this.shuiguoDelete = shuiguoDelete;
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
		return "ShuiguoCollectionView{" +
			", shuiguoCollectionValue=" + shuiguoCollectionValue +
			", shuiguoName=" + shuiguoName +
			", shuiguoUuidNumber=" + shuiguoUuidNumber +
			", shuiguoPhoto=" + shuiguoPhoto +
			", shuiguoAddress=" + shuiguoAddress +
			", shuiguoNewMoney=" + shuiguoNewMoney +
			", shuiguoKucunNumber=" + shuiguoKucunNumber +
			", shuiguoContent=" + shuiguoContent +
			", shuiguoDelete=" + shuiguoDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", newMoney=" + newMoney +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
