/*
 *
 *  *
 *  *  *
 *  *  *  * ===================================
 *  *  *  * Copyright (c) 2016.
 *  *  *  * 作者：安卓猴
 *  *  *  * 微博：@安卓猴
 *  *  *  * 博客：http://sunjiajia.com
 *  *  *  * Github：https://github.com/opengit
 *  *  *  *
 *  *  *  * 注意**：如果您使用或者修改该代码，请务必保留此版权信息。
 *  *  *  * ===================================
 *  *  *
 *  *  *
 *  *
 *
 */

package com.sunjiajia.androidnewwidgetsdemo.bean;

import java.util.List;

/**
 * Created by dawd on 2016/5/img12.
 */
public class ProductAllInfo {
    private String ordername;
    private List<ProductInfo> result;


    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public List<ProductInfo> getResult() {
        return result;
    }

    public void setResult(List<ProductInfo> result) {
        this.result = result;
    }
}
