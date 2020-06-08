package com.aimerrhythms.mall.product;

import com.aimerrhythms.mall.product.entity.BrandEntity;
import com.aimerrhythms.mall.product.service.BrandService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MallProductApplicationTests {

    @Autowired
    BrandService brandService;


    @Test
    void contextLoads() {

        BrandEntity brandEntity = new BrandEntity();

        brandEntity.setName("华为");

        //插入
        brandService.save(brandEntity);

        //需要修改的字段才进行复制
        //brandService.updateById(brandEntity);

        //查询
        List<BrandEntity> brands = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1));
        brands.forEach(System.out::println);


        System.out.println("成功");

    }

}
