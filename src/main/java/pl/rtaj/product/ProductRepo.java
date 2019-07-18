package pl.rtaj.product;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class ProductRepo {

    private Set<Product> prodList;

    public ProductRepo() {
        prodList = new HashSet<>();
        this.prodList.add(new Product("Filodendron", 24.99));
        this.prodList.add(new Product("Gumowa Kaczuszka", 10.50));
        this.prodList.add(new Product("Maskotka Żubr", 44.50));
        this.prodList.add(new Product("Czekolada", 4.99));
    }

    public Set<Product> getAll() {
        return prodList;
    }

    public void add(Product product) {
        prodList.add(product);
    }

    public double totalPrice() {
        double sum = 0;
        for (Product product : prodList) {
            sum += product.getProdPrice();
        }
        return sum;
    }


}
