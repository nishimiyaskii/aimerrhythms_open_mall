package com.aimerrhythms.mall.member.dao;

import com.aimerrhythms.mall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author aimerrhythms
 * @email nishimiyaskii@163.com
 * @date 2020-05-28 22:48:49
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
