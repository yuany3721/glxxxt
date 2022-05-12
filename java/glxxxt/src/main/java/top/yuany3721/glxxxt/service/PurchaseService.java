package top.yuany3721.glxxxt.service;

import top.yuany3721.glxxxt.entity.Purchase;
import top.yuany3721.glxxxt.entity.PurchaseList;

import java.math.BigDecimal;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lcl
 * @since 2022-05-09
 */
public interface PurchaseService extends IService<Purchase> {
    int purchase(Integer id, BigDecimal price, BigDecimal quantity);

    List<PurchaseList> getList();

}
