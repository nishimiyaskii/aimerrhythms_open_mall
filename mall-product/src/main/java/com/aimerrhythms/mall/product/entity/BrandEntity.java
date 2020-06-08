package com.aimerrhythms.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 品牌
 * 
 * @author aimerrhythms
 * @email nishimiyaskii@163.com
 * @date 2020-05-28 22:08:54
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@TableId
	private Long brandId;

	/**
	 * 品牌名
	 */
	@NotBlank(message = "品牌名不能为空")
	private String name;
	/**
	 * 品牌logo地址
	 */
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@NotBlank(message = "检索首字母不能为空")
	@Pattern(regexp = "/^[a-zA-Z]$/", message = "检索首字母必须是一个字母")  //使用正则表达式校验
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotNull(message = "排序不能为空")
	@Min(value = 0, message = "排序必须大于等于0")
	private Integer sort;

}
