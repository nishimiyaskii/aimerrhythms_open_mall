package com.aimerrhythms.mall.product.dao;

import com.aimerrhythms.mall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author aimerrhythms
 * @email nishimiyaskii@163.com
 * @date 2020-05-28 22:08:54
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
