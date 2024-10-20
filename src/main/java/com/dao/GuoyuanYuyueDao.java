package com.dao;

import com.entity.GuoyuanYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GuoyuanYuyueView;

/**
 * 果园预约 Dao 接口
 *
 * @author 
 */
public interface GuoyuanYuyueDao extends BaseMapper<GuoyuanYuyueEntity> {

   List<GuoyuanYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
