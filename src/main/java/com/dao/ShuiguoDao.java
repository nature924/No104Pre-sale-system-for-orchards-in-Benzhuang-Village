package com.dao;

import com.entity.ShuiguoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShuiguoView;

/**
 * 水果预售 Dao 接口
 *
 * @author 
 */
public interface ShuiguoDao extends BaseMapper<ShuiguoEntity> {

   List<ShuiguoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
