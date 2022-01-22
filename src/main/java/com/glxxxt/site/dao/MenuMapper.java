package com.glxxxt.site.dao;

import com.glxxxt.site.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lcl
 * @since 2019-10-20
 */
@Mapper
@Repository
public interface MenuMapper extends BaseMapper<Menu> {
    public List<Menu> getMenu();

    int nodishes(Integer id);

    int yesdishes(Integer id);

    String getDishName(Integer id);
}
