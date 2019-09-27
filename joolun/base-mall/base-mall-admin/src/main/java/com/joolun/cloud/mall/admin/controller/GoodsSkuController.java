/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.joolun.com
 * 注意：
 * 本软件为www.joolun.com开发研制，未经购买不得使用
 * 购买后可获得全部源代码（禁止转卖、分享、上传到码云、github等开源平台）
 * 一经发现盗用、分享等行为，将追究法律责任，后果自负
 */
package com.joolun.cloud.mall.admin.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.joolun.cloud.common.core.util.R;
import com.joolun.cloud.common.log.annotation.SysLog;
import com.joolun.cloud.mall.common.entity.GoodsSku;
import com.joolun.cloud.mall.admin.service.GoodsSkuService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;

/**
 * 商品sku
 *
 * @author JL
 * @date 2019-08-13 10:18:34
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/goodssku")
@Api(value = "goodssku", tags = "商品sku管理")
public class GoodsSkuController {

    private final GoodsSkuService goodsSkuService;

    /**
    * 分页查询
    * @param page 分页对象
    * @param goodsSku 商品sku
    * @return
    */
    @GetMapping("/page")
    @PreAuthorize("@ato.hasAuthority('mall_goodssku_index')")
    public R getGoodsSkuPage(Page page, GoodsSku goodsSku) {
        return R.ok(goodsSkuService.page(page,Wrappers.query(goodsSku)));
    }


    /**
    * 通过id查询商品sku
    * @param id
    * @return R
    */
    @GetMapping("/{id}")
    @PreAuthorize("@ato.hasAuthority('mall_goodssku_get')")
    public R getById(@PathVariable("id") String id){
        return R.ok(goodsSkuService.getById(id));
    }

    /**
    * 新增商品sku
    * @param goodsSku 商品sku
    * @return R
    */
    @SysLog("新增商品sku")
    @PostMapping
    @PreAuthorize("@ato.hasAuthority('mall_goodssku_add')")
    public R save(@RequestBody GoodsSku goodsSku){
        return R.ok(goodsSkuService.save(goodsSku));
    }

    /**
    * 修改商品sku
    * @param goodsSku 商品sku
    * @return R
    */
    @SysLog("修改商品sku")
    @PutMapping
    @PreAuthorize("@ato.hasAuthority('mall_goodssku_edit')")
    public R updateById(@RequestBody GoodsSku goodsSku){
        return R.ok(goodsSkuService.updateById(goodsSku));
    }

    /**
    * 通过id删除商品sku
    * @param id
    * @return R
    */
    @SysLog("删除商品sku")
    @DeleteMapping("/{id}")
    @PreAuthorize("@ato.hasAuthority('mall_goodssku_del')")
    public R removeById(@PathVariable String id){
        return R.ok(goodsSkuService.removeById(id));
    }

}