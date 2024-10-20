package com.dao;

import com.entity.GuoyuanLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GuoyuanLiuyanView;

/**
 * 果园留言 Dao 接口
 *
 * @author 
 */
public interface GuoyuanLiuyanDao extends BaseMapper<GuoyuanLiuyanEntity> {

   List<GuoyuanLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
