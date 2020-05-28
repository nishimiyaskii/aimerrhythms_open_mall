package com.aimerrhythms.mall.member.dao;

import com.aimerrhythms.mall.member.entity.MemberLoginLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员登录记录
 * 
 * @author aimerrhythms
 * @email nishimiyaskii@163.com
 * @date 2020-05-28 22:48:49
 */
@Mapper
public interface MemberLoginLogDao extends BaseMapper<MemberLoginLogEntity> {
	
}
