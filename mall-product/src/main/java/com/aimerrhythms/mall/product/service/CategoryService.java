package com.aimerrhythms.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.aimerrhythms.common.utils.PageUtils;
import com.aimerrhythms.mall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author aimerrhythms
 * @email nishimiyaskii@163.com
 * @date 2020-05-28 22:08:54
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 三级分类查询
     * @return
     */
    List<CategoryEntity> listWithTree();


    /**
     * 批量删除菜单
     * @param catIds
     */
    void removeBatchByIds(List<Long> catIds);
}

