package pl.rtaj.product;

import java.util.Objects;

public class Product {

    private String prodName;
    private double prodPrice;


    @Override
    public String toString() {
        return prodName + " " + prodPrice;
    }


    public Product(String prodName, double prodPrice) {

        this.prodName = prodName;
        this.prodPrice = prodPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product produkt = (Product) o;
        return Double.compare(produkt.prodPrice, prodPrice) == 0 &&
                prodName.equals(produkt.prodName);
    }

    @Override
    public int hashCode() {
        return Objects.hash( prodName, prodPrice);
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(double prodPrice) {
        this.prodPrice = prodPrice;
    }
}
