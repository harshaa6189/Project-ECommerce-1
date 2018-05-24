package Controller;


import com.ecommerce.ECommerce.Service.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class Productcontroller {

    @Autowired
    private ProductServiceInterface productService;


}
