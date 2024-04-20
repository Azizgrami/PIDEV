/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ayedi
 */

public class ProductCategory {
    private int categoryId;
     private String categoryName;
  private   List<Product> productIds;

    public ProductCategory(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }
 public boolean isValid() {
        return this != null && this.getCategoryId() != 0;
    }
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Product> productIds) {
        this.productIds = productIds;
    }

    public ProductCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public ProductCategory() {
    }

    @Override
    public String toString() {
        return "ProductCategory{" + "categoryName=" + categoryName + '}';
    }

  
   

}



    