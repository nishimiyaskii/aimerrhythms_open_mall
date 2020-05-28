package com.aimerrhythms.mall.order.dao;

import com.aimerrhythms.mall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author aimerrhythms
 * @email nishimiyaskii@163.com
 * @date 2020-05-28 22:52:56
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
