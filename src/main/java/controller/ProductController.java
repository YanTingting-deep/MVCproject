package controller;

import domain.Product;
import form.ProductForm;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.ProductService;

@Controller
public class ProductController
{
    private static final org.apache.commons.logging.Log logger = LogFactory.getLog(ProductController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product_input")
    public String inputProduct()
    {
        logger.info("inputProduct called");
        return "ProductForm";
    }

    @RequestMapping(value = "/product_save",method = RequestMethod.POST)
    public String saveProduct(ProductForm productForm, RedirectAttributes redirectAttributes)
    {
        logger.info("saveProduct called");
        //no need to create and instantiate a ProductForm
        //create Product
        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        try
        {
            product.setPrice(Float.parseFloat(productForm.getPrice()));
        }catch (NumberFormatException e){}

        Product savedProduct = productService.add(product);
        redirectAttributes.addFlashAttribute("message", "The product was successfully added.");
        //重定向
        return "redirect:/product_view/"+savedProduct.getId();
    }

    //定义了一个名为id的路径变量
    @RequestMapping(value = "/product_view/{id}")
    public String ViewProduct(@PathVariable Long id, Model model)
    {
        Product product = productService.get(id);
        model.addAttribute("product",product);
        return "ProductView";
    }
}
