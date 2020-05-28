package com.aimerrhythms.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.aimerrhythms.common.utils.PageUtils;
import com.aimerrhythms.mall.order.entity.OrderReturnApplyEntity;

import java.util.Map;

/**
 * 订单退货申请
 *
 * @author aimerrhythms
 * @email nishimiyaskii@163.com
 * @date 2020-05-28 22:52:56
 */
public interface OrderReturnApplyService extends IService<OrderReturnApplyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

