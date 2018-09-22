package domain;

import java.io.Serializable;

//实例可以安全的保存到HTTPSession中
public class Product implements Serializable
{
    private static final long serialVersionUID = 748392348L;
    private Long id;
    private String name;
    private String description;
    private float price;

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public float getPrice()
    {
        return price;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }
}
