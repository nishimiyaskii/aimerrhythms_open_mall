package com.aimerrhythms.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.aimerrhythms.common.utils.PageUtils;
import com.aimerrhythms.mall.product.entity.ProductAttrValueEntity;

import java.util.Map;

/**
 * spu属性值
 *
 * @author aimerrhythms
 * @email nishimiyaskii@163.com
 * @date 2020-05-28 22:08:54
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

