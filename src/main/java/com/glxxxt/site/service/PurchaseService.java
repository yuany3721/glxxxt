package com.glxxxt.site.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.glxxxt.site.entity.Purchase;
import com.glxxxt.site.entity.PurchaseList;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lcl
 * @since 2019-10-20
 */
public interface PurchaseService extends IService<Purchase> {
    int purchase(Integer id, BigDecimal price, BigDecimal quantity);

    List<PurchaseList> getList();
}
