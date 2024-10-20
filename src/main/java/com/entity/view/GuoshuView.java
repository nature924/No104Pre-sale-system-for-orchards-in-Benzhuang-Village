package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.GuoshuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 果树
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("guoshu")
public class GuoshuView extends GuoshuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 果树类型的值
	*/
	@ColumnInfo(comment="果树类型的字典表值",type="varchar(200)")
	private String guoshuValue;

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



	public GuoshuView() {

	}

	public GuoshuView(GuoshuEntity guoshuEntity) {
		try {
			BeanUtils.copyProperties(this, guoshuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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


	@Override
	public String toString() {
		return "GuoshuView{" +
			", guoshuValue=" + guoshuValue +
			", guoyuanName=" + guoyuanName +
			", guoyuanPhoto=" + guoyuanPhoto +
			", guoyuanAddress=" + guoyuanAddress +
			", guoyuanContent=" + guoyuanContent +
			", guoyuanDelete=" + guoyuanDelete +
			"} " + super.toString();
	}
}
