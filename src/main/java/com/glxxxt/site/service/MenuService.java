package com.glxxxt.site.service;

import com.glxxxt.site.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lcl
 * @since 2019-10-20
 */
public interface MenuService extends IService<Menu> {
    public List<Menu> getMenu();
}
