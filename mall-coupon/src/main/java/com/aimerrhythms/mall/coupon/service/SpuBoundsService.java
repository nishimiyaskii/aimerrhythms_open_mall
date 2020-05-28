package com.aimerrhythms.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.aimerrhythms.common.utils.PageUtils;
import com.aimerrhythms.mall.coupon.entity.SpuBoundsEntity;

import java.util.Map;

/**
 * 商品spu积分设置
 *
 * @author aimerrhythms
 * @email nishimiyaskii@163.com
 * @date 2020-05-28 22:43:20
 */
public interface SpuBoundsService extends IService<SpuBoundsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

