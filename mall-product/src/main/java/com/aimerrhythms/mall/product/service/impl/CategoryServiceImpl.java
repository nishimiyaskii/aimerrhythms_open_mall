package com.aimerrhythms.mall.product.service.impl;

import com.aimerrhythms.common.utils.PageUtils;
import com.aimerrhythms.common.utils.Query;
import com.aimerrhythms.mall.product.dao.CategoryDao;
import com.aimerrhythms.mall.product.entity.CategoryEntity;
import com.aimerrhythms.mall.product.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {
    /*
     * 1、可以直接注入
     * @Autowired
     * private CategoryDao categoryDao;
     *
     * 2、可以使用父类的成员变量
     * CategoryServiceImpl继承了了ServiceImpl
     * ServiceImpl顾名思义他就是所有Service接口的实现类。
     * 那么具体是实现哪个接口呢？通过它传入的泛型就知道了...
     * 然后就可以利用继承ServiceImpl中的baseMapper属性调用相应的dao层方法了
     */

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        /* 1、查出所有分类 */
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);//没有查询条件，参数传入null



        /*2、组装成父子树形结构*/
        return categoryEntities.stream().filter(item -> item.getParentCid() == 0)

                //重新修改List的内容，然后重新返回
                .peek(menu -> menu.setChildren(getChildren(menu, categoryEntities)))

                //排序一级菜单。m.getSort()返回可能为null
                //sorted((m1, m2) -> (m1 == null ? 0 : 1) - (m2 == null ? 0 : 1))
                .sorted(Comparator.comparingInt(m -> (1)))

                //将数据流中的所有元素收集起来，组装成一个List
                .collect(Collectors.toList());
    }

    /**
     * 根据菜单找到所有的子菜单
     *
     * @param rootCategoryEntity  根菜单
     * @param allCategoryEntities 所有的子菜单
     * @return
     */
    private List<CategoryEntity> getChildren(CategoryEntity rootCategoryEntity, List<CategoryEntity> allCategoryEntities) {
        return allCategoryEntities.stream().filter(item -> item.getParentCid().equals(rootCategoryEntity.getCatId()))
                //递归查询子菜单
                .peek(menu -> menu.setChildren(getChildren(menu, allCategoryEntities)))
                //sorted((m1, m2) -> (m1 == null ? 0 : 1) - (m2 == null ? 0 : 1))
                .sorted(Comparator.comparingInt(m -> (1)))
                .collect(Collectors.toList());
    }

    @Override
    public void removeBatchByIds(List<Long> catIds) {
        //TODO：判断当前菜单是否被引用

        //一般公司中的删除使用的是逻辑删除，而不是全部物理删除
        baseMapper.deleteBatchIds(catIds);
    }

}