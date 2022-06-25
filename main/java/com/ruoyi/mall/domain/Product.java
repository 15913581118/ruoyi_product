package com.ruoyi.mall.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品管理对象 product
 * 
 * @author ruoyi
 * @date 2022-06-25
 */
public class Product extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long pid;

    /** 名称 */
    @Excel(name = "名称")
    private String pname;

    /** 种类 */
    @Excel(name = "种类")
    private String kinds;

    /** 价格 */
    @Excel(name = "价格")
    private Long price;

    /** 颜色 */
    @Excel(name = "颜色")
    private String color;

    /** 品牌 */
    @Excel(name = "品牌")
    private String brand;

    public void setPid(Long pid) 
    {
        this.pid = pid;
    }

    public Long getPid() 
    {
        return pid;
    }
    public void setPname(String pname) 
    {
        this.pname = pname;
    }

    public String getPname() 
    {
        return pname;
    }
    public void setKinds(String kinds) 
    {
        this.kinds = kinds;
    }

    public String getKinds() 
    {
        return kinds;
    }
    public void setPrice(Long price) 
    {
        this.price = price;
    }

    public Long getPrice() 
    {
        return price;
    }
    public void setColor(String color) 
    {
        this.color = color;
    }

    public String getColor() 
    {
        return color;
    }
    public void setBrand(String brand) 
    {
        this.brand = brand;
    }

    public String getBrand() 
    {
        return brand;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pid", getPid())
            .append("pname", getPname())
            .append("kinds", getKinds())
            .append("price", getPrice())
            .append("color", getColor())
            .append("createTime", getCreateTime())
            .append("brand", getBrand())
            .toString();
    }
}
