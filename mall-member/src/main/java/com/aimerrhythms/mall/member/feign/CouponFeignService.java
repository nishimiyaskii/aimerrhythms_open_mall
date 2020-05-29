package com.aimerrhythms.mall.member.feign;

import com.aimerrhythms.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 这个接口是需要调用远程服务的
 *
 * 声明接口中的每一个方法都是需要调用的远程服务的相应的请求
 * @author aimerrhythms
 * @data 2020/5/29 15:27
 */
@FeignClient("mall-coupon")  //声明这个接口中的方法需要调用哪个远程服务
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/member/list")  //声明这个方法需要调用远程服务的哪个请求
    R memberCoupons();

}
