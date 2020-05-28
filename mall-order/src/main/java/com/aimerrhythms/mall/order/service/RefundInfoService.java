package com.aimerrhythms.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.aimerrhythms.common.utils.PageUtils;
import com.aimerrhythms.mall.order.entity.RefundInfoEntity;

import java.util.Map;

/**
 * 退款信息
 *
 * @author aimerrhythms
 * @email nishimiyaskii@163.com
 * @date 2020-05-28 22:52:56
 */
public interface RefundInfoService extends IService<RefundInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

