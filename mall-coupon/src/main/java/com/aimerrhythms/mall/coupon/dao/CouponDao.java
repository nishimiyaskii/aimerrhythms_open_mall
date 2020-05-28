package com.aimerrhythms.mall.coupon.dao;

import com.aimerrhythms.mall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author aimerrhythms
 * @email nishimiyaskii@163.com
 * @date 2020-05-28 22:43:20
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
