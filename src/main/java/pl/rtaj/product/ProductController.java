package pl.rtaj.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class ProductController {

    private ProductRepo productRepo; //tworzymy pole prywatne

    public ProductController(ProductRepo productRepo) { //inicjujemy i wstrzykujemy dane
        this.productRepo = productRepo;
    }

    @GetMapping("/tabela")
    public String tabela(Model model) {

        model.addAttribute("products", productRepo.getAll());
        model.addAttribute("totalPrice", productRepo.totalPrice());

        return "tabela";
    }

    @GetMapping("/lista")
    public String lista(Model model) {

        model.addAttribute("products", productRepo.getAll());
        model.addAttribute("totalPrice", productRepo.totalPrice());

        return "lista";
    }

    @GetMapping("/add")
    public String addUsers(
            @RequestParam(name = "prodName") String name,
            @RequestParam(name = "prodPrice", defaultValue = "0") double price) {

        if (name.isEmpty() || price == 0) {

            return "redirect:/error.html";
        } else {
            Set<Product> prodList = productRepo.getAll();
            prodList.add(new Product(name, price));
            return "redirect:/dodano.html";
        }
    }
}