package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.GuoyuanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 果园
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("guoyuan")
public class GuoyuanView extends GuoyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 果园类型的值
	*/
	@ColumnInfo(comment="果园类型的字典表值",type="varchar(200)")
	private String guoyuanValue;




	public GuoyuanView() {

	}

	public GuoyuanView(GuoyuanEntity guoyuanEntity) {
		try {
			BeanUtils.copyProperties(this, guoyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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




	@Override
	public String toString() {
		return "GuoyuanView{" +
			", guoyuanValue=" + guoyuanValue +
			"} " + super.toString();
	}
}
