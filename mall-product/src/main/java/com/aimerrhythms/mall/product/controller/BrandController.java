package com.aimerrhythms.mall.product.controller;

import com.aimerrhythms.common.utils.PageUtils;
import com.aimerrhythms.common.utils.R;
import com.aimerrhythms.mall.product.entity.BrandEntity;
import com.aimerrhythms.mall.product.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 品牌
 *
 * @author aimerrhythms
 * @email nishimiyaskii@163.com
 * @date 2020-05-28 22:08:54
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:brand:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    //@RequiresPermissions("product:brand:info")
    public R info(@PathVariable("brandId") Long brandId) {
        BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:brand:save")
    public R save(@RequestBody @Valid BrandEntity brand, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            result.getFieldErrors().forEach(item -> {
                //获取错误消息
                String errorMessage = item.getDefaultMessage();
                //获取错误字段
                String field = item.getField();
                errorMap.put(field, errorMessage);
            });
            System.out.println(errorMap);
            return R.error(400, "提交数据不合法").put("data", errorMap);
        } else {
            brandService.save(brand);
            return R.ok();
        }
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:brand:update")
    public R update(@RequestBody BrandEntity brand) {
        brandService.updateById(brand);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:brand:delete")
    public R delete(@RequestBody Long[] brandIds) {
        brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
