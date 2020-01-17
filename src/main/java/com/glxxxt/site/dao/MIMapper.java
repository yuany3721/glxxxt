package com.glxxxt.site.dao;

import com.glxxxt.site.entity.MI;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lcl
 * @since 2019-10-20
 */
public interface MIMapper extends BaseMapper<MI> {
    List<MI> getRequirement(Integer id);
    List<MI> getMenuId(Integer id);
}
