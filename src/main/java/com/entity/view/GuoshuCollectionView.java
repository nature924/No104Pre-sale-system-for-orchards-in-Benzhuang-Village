package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.GuoshuCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 果树收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("guoshu_collection")
public class GuoshuCollectionView extends GuoshuCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String guoshuCollectionValue;

	//级联表 果树
							/**
		* 果树名称
		*/

		@ColumnInfo(comment="果树名称",type="varchar(200)")
		private String guoshuName;
		/**
		* 果树编号
		*/

		@ColumnInfo(comment="果树编号",type="varchar(200)")
		private String guoshuUuidNumber;
		/**
		* 果树照片
		*/

		@ColumnInfo(comment="果树照片",type="varchar(200)")
		private String guoshuPhoto;
		/**
		* 果树地点
		*/

		@ColumnInfo(comment="果树地点",type="varchar(200)")
		private String guoshuAddress;
		/**
		* 果树认养费用
		*/
		@ColumnInfo(comment="果树认养费用",type="decimal(10,2)")
		private Double guoshuNewMoney;
		/**
		* 果树类型
		*/
		@ColumnInfo(comment="果树类型",type="int(11)")
		private Integer guoshuTypes;
			/**
			* 果树类型的值
			*/
			@ColumnInfo(comment="果树类型的字典表值",type="varchar(200)")
			private String guoshuValue;
		/**
		* 果树库存
		*/

		@ColumnInfo(comment="果树库存",type="int(11)")
		private Integer guoshuKucunNumber;
		/**
		* 果树介绍
		*/

		@ColumnInfo(comment="果树介绍",type="longtext")
		private String guoshuContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer guoshuDelete;
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



	public GuoshuCollectionView() {

	}

	public GuoshuCollectionView(GuoshuCollectionEntity guoshuCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, guoshuCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getGuoshuCollectionValue() {
		return guoshuCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setGuoshuCollectionValue(String guoshuCollectionValue) {
		this.guoshuCollectionValue = guoshuCollectionValue;
	}


	//级联表的get和set 果树

		/**
		* 获取： 果树名称
		*/
		public String getGuoshuName() {
			return guoshuName;
		}
		/**
		* 设置： 果树名称
		*/
		public void setGuoshuName(String guoshuName) {
			this.guoshuName = guoshuName;
		}

		/**
		* 获取： 果树编号
		*/
		public String getGuoshuUuidNumber() {
			return guoshuUuidNumber;
		}
		/**
		* 设置： 果树编号
		*/
		public void setGuoshuUuidNumber(String guoshuUuidNumber) {
			this.guoshuUuidNumber = guoshuUuidNumber;
		}

		/**
		* 获取： 果树照片
		*/
		public String getGuoshuPhoto() {
			return guoshuPhoto;
		}
		/**
		* 设置： 果树照片
		*/
		public void setGuoshuPhoto(String guoshuPhoto) {
			this.guoshuPhoto = guoshuPhoto;
		}

		/**
		* 获取： 果树地点
		*/
		public String getGuoshuAddress() {
			return guoshuAddress;
		}
		/**
		* 设置： 果树地点
		*/
		public void setGuoshuAddress(String guoshuAddress) {
			this.guoshuAddress = guoshuAddress;
		}

		/**
		* 获取： 果树认养费用
		*/
		public Double getGuoshuNewMoney() {
			return guoshuNewMoney;
		}
		/**
		* 设置： 果树认养费用
		*/
		public void setGuoshuNewMoney(Double guoshuNewMoney) {
			this.guoshuNewMoney = guoshuNewMoney;
		}
		/**
		* 获取： 果树类型
		*/
		public Integer getGuoshuTypes() {
			return guoshuTypes;
		}
		/**
		* 设置： 果树类型
		*/
		public void setGuoshuTypes(Integer guoshuTypes) {
			this.guoshuTypes = guoshuTypes;
		}


			/**
			* 获取： 果树类型的值
			*/
			public String getGuoshuValue() {
				return guoshuValue;
			}
			/**
			* 设置： 果树类型的值
			*/
			public void setGuoshuValue(String guoshuValue) {
				this.guoshuValue = guoshuValue;
			}

		/**
		* 获取： 果树库存
		*/
		public Integer getGuoshuKucunNumber() {
			return guoshuKucunNumber;
		}
		/**
		* 设置： 果树库存
		*/
		public void setGuoshuKucunNumber(Integer guoshuKucunNumber) {
			this.guoshuKucunNumber = guoshuKucunNumber;
		}

		/**
		* 获取： 果树介绍
		*/
		public String getGuoshuContent() {
			return guoshuContent;
		}
		/**
		* 设置： 果树介绍
		*/
		public void setGuoshuContent(String guoshuContent) {
			this.guoshuContent = guoshuContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getGuoshuDelete() {
			return guoshuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setGuoshuDelete(Integer guoshuDelete) {
			this.guoshuDelete = guoshuDelete;
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
		return "GuoshuCollectionView{" +
			", guoshuCollectionValue=" + guoshuCollectionValue +
			", guoshuName=" + guoshuName +
			", guoshuUuidNumber=" + guoshuUuidNumber +
			", guoshuPhoto=" + guoshuPhoto +
			", guoshuAddress=" + guoshuAddress +
			", guoshuNewMoney=" + guoshuNewMoney +
			", guoshuKucunNumber=" + guoshuKucunNumber +
			", guoshuContent=" + guoshuContent +
			", guoshuDelete=" + guoshuDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", newMoney=" + newMoney +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
