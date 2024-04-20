/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import Models.ProductCategory;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Locale.Category;
/**
 *
 * @author Ayedi
 */
public class Product  {
   private int productId;
    private String productName;
    private String description;
    private byte[] image; // Representing BLOB as a byte array
    private double price;
    private int quantityInStock;
    private ProductCategory idc_id;
 private List<Product> products;
    public Product(int productId, String productName, String description, byte[] image, double price, int quantityInStock,ProductCategory idc_id) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.image = image;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.idc_id=idc_id;
    }

    public Product(int productId, String productName, String description, byte[] image, double price, int quantityInStock) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.image = image;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public Product(int productId, String productName, String description, byte[] image, double price, int quantityInStock, ProductCategory idc_id, List<Product> products) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.image = image;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.idc_id = idc_id;
        this.products = products;
    }

    public Product(String productName, String description, byte[] image, double price, int quantityInStock,ProductCategory idc_id) {
        this.productName = productName;
        this.description = description;
        this.image = image;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public Product(String productName, String description, byte[] image, double price, int quantityInStock) {
        this.productName = productName;
        this.description = description;
        this.image = image;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public Product() {
    }

    public Product(List<Product> products) {
        this.products = products;
    }

    public Product(String productName, String description, byte[] image, double price, int quantityInStock, ProductCategory idc_id, List<Product> products) {
        this.productName = productName;
        this.description = description;
        this.image = image;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.idc_id = idc_id;
        this.products = products;
    }

    public Product(String productId, String productName, String description, byte[] imageBytes, double price, int quantityInStock, ProductCategory selectedCategory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public ProductCategory getIdc_id() {
        return idc_id;
    }

    public void setIdc_id(ProductCategory idc_id) {
        this.idc_id = idc_id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
     /* public void addCart(Product cart) {
        if (!this.products.contains(cart)) {
            this.products.add(cart);
            cart.addProduct(this);
        }
    }

    public void removeCart(Cart cart) {
        this.carts.remove(cart);
        cart.removeProduct(this);
    }
*/

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productName=" + productName + ", description=" + description + ", image=" + image + ", price=" + price + ", quantityInStock=" + quantityInStock + ", idc_id=" + idc_id + ", products=" + products + '}';
    }



    
}
