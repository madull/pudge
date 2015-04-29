package com.pudge.service.weixin;

import java.io.IOException;

import com.pudge.controller.weixin.AbstractWeixinmpController;
import com.pudge.entity.weixin.base.GlobalError;
import com.pudge.entity.weixin.merchant.bean.ProductRequest;
import com.pudge.entity.weixin.merchant.bean.StockRequest;
import com.pudge.entity.weixin.merchant.builder.StockBuilder;
import com.pudge.exception.weixin.WeixinException;
import com.pudge.util.CommonUtils;

/**
 * <pre>
 * 库存管理接口
 * @author jianqing.cai@qq.com, 2014年6月9日 下午8:51:29, https://github.com/caijianqing/weixinmp4java/
 * </pre>
 */
public class MerchantStockService {

    /** 微信公众平台API控制器实例 */
    private final AbstractWeixinmpController controller;

    public MerchantStockService(AbstractWeixinmpController controller) {
        this.controller = controller;
    }

    /**
     * 增加库存
     * 
     * @param stockRequest 使用{@link StockBuilder#build(cjc.weixinmp.ModelBuilder.RequriedType)}方法构造
     * @throws WeixinException 如果发生错误
     */
    public void addStock(StockRequest stockRequest) throws WeixinException {
        String url = controller.getProperty("merchant_stock_add_url", null, false);
        try {
            // 发送请求
            GlobalError error = controller.postWithJson(url, stockRequest, ProductRequest.Response.class, "addStock");
            controller.logInfo("增加库存结果：" + error);
        } catch (WeixinException e) {
            controller.logError(e.getMessage());
            if (e.isNeedLog()) {
                controller.saveToFile(e.getLogFilename(), e.getLogContent());
            }
            throw e;
        } catch (IOException e) {
            throw new WeixinException(CommonUtils.getNextId() + "_addStockError", e.getMessage(), e);
        }
    }

    /**
     * 减少库存
     * 
     * @param stockRequest 使用{@link StockBuilder#build(cjc.weixinmp.ModelBuilder.RequriedType)}方法构造
     * @throws WeixinException 如果发生错误
     */
    public void reduceStock(StockRequest stockRequest) throws WeixinException {
        String url = controller.getProperty("merchant_stock_reduce_url", null, false);
        try {
            // 发送请求
            GlobalError error = controller.postWithJson(url, stockRequest, ProductRequest.Response.class, "reduceStock");
            controller.logInfo("减少库存结果：" + error);
        } catch (WeixinException e) {
            controller.logError(e.getMessage());
            if (e.isNeedLog()) {
                controller.saveToFile(e.getLogFilename(), e.getLogContent());
            }
            throw e;
        } catch (IOException e) {
            throw new WeixinException(CommonUtils.getNextId() + "_reduceStockError", e.getMessage(), e);
        }
    }

}
