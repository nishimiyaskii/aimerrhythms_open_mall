package com.aimerrhythms.mall.product.controller;

import com.aimerrhythms.common.utils.R;
import com.aimerrhythms.mall.product.entity.CategoryEntity;
import com.aimerrhythms.mall.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * 商品三级分类
 *
 * @author aimerrhythms
 * @email nishimiyaskii@163.com
 * @date 2020-05-28 22:08:54
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 查出所有分类以及子分类
     * 以树形结构显示
     */
    @RequestMapping("/list/tree")
    //@RequiresPermissions("product:category:list")
    public R list(){
        List<CategoryEntity> categoryEntities = categoryService.listWithTree();
        return R.ok().put("page", categoryEntities);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    //@RequiresPermissions("product:category:info")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:category:save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 批量修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:category:update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);
        return R.ok();
    }

    @RequestMapping("/update/sort")
    public R updateBatch(@RequestBody CategoryEntity[] categoryEntities) {
        categoryService.updateBatchById(Arrays.asList(categoryEntities));
        return R.ok();
    }

    /**
     * 删除
     * @RequestBody ：获取请求体，必须是POST请求
     * SpringMVC自动将请求体的数据(json)转为对应的对象
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:category:delete")
    public R delete(@RequestBody Long[] catIds){
        categoryService.removeBatchByIds(Arrays.asList(catIds));
        return R.ok();
    }

}
