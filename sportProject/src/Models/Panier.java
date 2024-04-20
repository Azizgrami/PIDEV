/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.List;
import Models.ProductCategory;
import Models.Product;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ayedi
 */

public class Panier {
private int  panierId;
private int nombreProduitsAchetes;
private Product Products[];

    public Panier(int i, Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Panier{" + "panierId=" + panierId + ", nombreProduitsAchetes=" + nombreProduitsAchetes + ", Product=" + Products + '}';
    }

    /*public Panier() {
    }*/

    public Panier(Product[] Product) {
        this.Products = Product;
    }

    public Panier(int panierId, List<Product> products) {
        this.panierId = panierId;
        this.products = products;
    }

    public Panier(int panierId, int nombreProduitsAchetes, Product[] Product) {
        this.panierId = panierId;
        this.nombreProduitsAchetes = nombreProduitsAchetes;
        this.Products = Product;
    }

    public Panier(int nombreProduitsAchetes, Product[] Product) {
        this.nombreProduitsAchetes = nombreProduitsAchetes;
        this.Products = Product;
    }

    public int getPanierId() {
        return panierId;
    }

    public void setPanierId(int panierId) {
        this.panierId = panierId;
    }

    public int getNombreProduitsAchetes() {
        return nombreProduitsAchetes;
    }

    public void setNombreProduitsAchetes(int nombreProduitsAchetes) {
        this.nombreProduitsAchetes = nombreProduitsAchetes;
    }

    public Product[] getProduct() {
        return Products;
    }

    public void setProduct(Product[] Product) {
        this.Products = Product;
    }
    
  /* public void addProduct(Product product,Product[] Products) {
        if (!this.products.contains(product)) {
            this.products.add(product);
        }
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }*/
    private List<Product> products;

    public Panier() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (!this.products.contains(product)) {
            this.products.add(product);
        }
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    public List<Product> getProducts() {
        return this.products;
    }
   
   
}


