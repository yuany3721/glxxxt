package top.yuany3721.glxxxt.dao;

import top.yuany3721.glxxxt.entity.MI;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lcl
 * @since 2022-05-09
 */
public interface MIMapper extends BaseMapper<MI> {
    List<MI> getRequirement(Integer id);

    List<MI> getMenuId(Integer id);

}
