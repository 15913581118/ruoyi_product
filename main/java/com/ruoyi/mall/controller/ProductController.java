package com.ruoyi.mall.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.mall.domain.Product;
import com.ruoyi.mall.service.IProductService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品管理Controller
 * 
 * @author ruoyi
 * @date 2022-06-25
 */
@Controller
@RequestMapping("/mall/product")
public class ProductController extends BaseController
{
    private String prefix = "mall/product";

    @Autowired
    private IProductService productService;

    @RequiresPermissions("mall:product:view")
    @GetMapping()
    public String product()
    {
        return prefix + "/product";
    }

    /**
     * 查询商品管理列表
     */
    @RequiresPermissions("mall:product:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Product product)
    {
        startPage();
        List<Product> list = productService.selectProductList(product);
        return getDataTable(list);
    }

    /**
     * 导出商品管理列表
     */
    @RequiresPermissions("mall:product:export")
    @Log(title = "商品管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Product product)
    {
        List<Product> list = productService.selectProductList(product);
        ExcelUtil<Product> util = new ExcelUtil<Product>(Product.class);
        return util.exportExcel(list, "商品管理数据");
    }

    /**
     * 新增商品管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品管理
     */
    @RequiresPermissions("mall:product:add")
    @Log(title = "商品管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Product product)
    {
        return toAjax(productService.insertProduct(product));
    }

    /**
     * 修改商品管理
     */
    @RequiresPermissions("mall:product:edit")
    @GetMapping("/edit/{pid}")
    public String edit(@PathVariable("pid") Long pid, ModelMap mmap)
    {
        Product product = productService.selectProductByPid(pid);
        mmap.put("product", product);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品管理
     */
    @RequiresPermissions("mall:product:edit")
    @Log(title = "商品管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Product product)
    {
        return toAjax(productService.updateProduct(product));
    }

    /**
     * 删除商品管理
     */
    @RequiresPermissions("mall:product:remove")
    @Log(title = "商品管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(productService.deleteProductByPids(ids));
    }
}
