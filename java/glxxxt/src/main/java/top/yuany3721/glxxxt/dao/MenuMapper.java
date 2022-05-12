package top.yuany3721.glxxxt.dao;

import top.yuany3721.glxxxt.entity.Menu;

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
public interface MenuMapper extends BaseMapper<Menu> {
    public List<Menu> getMenu();

    int nodishes(Integer id);

    int yesdishes(Integer id);

    String getDishName(Integer id);

}
