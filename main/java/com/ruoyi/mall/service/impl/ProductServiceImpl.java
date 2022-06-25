package com.ruoyi.mall.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mall.mapper.ProductMapper;
import com.ruoyi.mall.domain.Product;
import com.ruoyi.mall.service.IProductService;
import com.ruoyi.common.core.text.Convert;

/**
 * 商品管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-25
 */
@Service
public class ProductServiceImpl implements IProductService 
{
    @Autowired
    private ProductMapper productMapper;

    /**
     * 查询商品管理
     * 
     * @param pid 商品管理主键
     * @return 商品管理
     */
    @Override
    public Product selectProductByPid(Long pid)
    {
        return productMapper.selectProductByPid(pid);
    }

    /**
     * 查询商品管理列表
     * 
     * @param product 商品管理
     * @return 商品管理
     */
    @Override
    public List<Product> selectProductList(Product product)
    {
        return productMapper.selectProductList(product);
    }

    /**
     * 新增商品管理
     * 
     * @param product 商品管理
     * @return 结果
     */
    @Override
    public int insertProduct(Product product)
    {
        product.setCreateTime(DateUtils.getNowDate());
        return productMapper.insertProduct(product);
    }

    /**
     * 修改商品管理
     * 
     * @param product 商品管理
     * @return 结果
     */
    @Override
    public int updateProduct(Product product)
    {
        return productMapper.updateProduct(product);
    }

    /**
     * 批量删除商品管理
     * 
     * @param pids 需要删除的商品管理主键
     * @return 结果
     */
    @Override
    public int deleteProductByPids(String pids)
    {
        return productMapper.deleteProductByPids(Convert.toStrArray(pids));
    }

    /**
     * 删除商品管理信息
     * 
     * @param pid 商品管理主键
     * @return 结果
     */
    @Override
    public int deleteProductByPid(Long pid)
    {
        return productMapper.deleteProductByPid(pid);
    }
}
