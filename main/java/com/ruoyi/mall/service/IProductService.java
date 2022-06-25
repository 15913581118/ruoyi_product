package com.ruoyi.mall.service;

import java.util.List;
import com.ruoyi.mall.domain.Product;

/**
 * 商品管理Service接口
 * 
 * @author ruoyi
 * @date 2022-06-25
 */
public interface IProductService 
{
    /**
     * 查询商品管理
     * 
     * @param pid 商品管理主键
     * @return 商品管理
     */
    public Product selectProductByPid(Long pid);

    /**
     * 查询商品管理列表
     * 
     * @param product 商品管理
     * @return 商品管理集合
     */
    public List<Product> selectProductList(Product product);

    /**
     * 新增商品管理
     * 
     * @param product 商品管理
     * @return 结果
     */
    public int insertProduct(Product product);

    /**
     * 修改商品管理
     * 
     * @param product 商品管理
     * @return 结果
     */
    public int updateProduct(Product product);

    /**
     * 批量删除商品管理
     * 
     * @param pids 需要删除的商品管理主键集合
     * @return 结果
     */
    public int deleteProductByPids(String pids);

    /**
     * 删除商品管理信息
     * 
     * @param pid 商品管理主键
     * @return 结果
     */
    public int deleteProductByPid(Long pid);
}
