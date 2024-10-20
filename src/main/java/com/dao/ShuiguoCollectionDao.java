package com.dao;

import com.entity.ShuiguoCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShuiguoCollectionView;

/**
 * 水果收藏 Dao 接口
 *
 * @author 
 */
public interface ShuiguoCollectionDao extends BaseMapper<ShuiguoCollectionEntity> {

   List<ShuiguoCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
