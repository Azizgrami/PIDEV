/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import interfaceProduit.interfaceProduit;
import java.sql.Connection;
import services.ProductService;
import util.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import services.ProductService ;
import services.ServicePanier;
import services.ServiceProductCategory;
import Models.Product;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import services.ProductService;

/**
 *
 * @author Ayedi
 */
public class SportProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // Create a sample Product object with description and image
    /*    Product sampleProduct = new Product("Sampl Prodct", "Sample Desription", null, 10.0, 100);
        // Create a ByteArrayInputStream for the sample image (replace with actual image data)
        byte[] sampleImageData = new byte[]{0x12, 0x34, 0x56, 0x78};
        InputStream imageStream = new ByteArrayInputStream(sampleImageData);

        // Initialize ProductService
        ProductService productService = new ProductService();

        // Add a new product
        productService.addProduct(sampleProduct, "Sampl Description", imageStream);

        // Modify the price of the product with a specific productId
        int productIdToModify = 1; // Replace with the actual productId
        double newPrice = 15.0; // Replace with the new price
        productService.modifyProductPrice(productIdToModify, newPrice);

        // Delete a product with a specific productId
        int productIdToDelete = 1; // Replace with the actual productId
        productService.deleteProduct(productIdToDelete);

        // Display all products
        List<Product> allProducts = productService.displayProducts();
        for (Product product : allProducts) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Product Price: " + product.getPrice());
            // You can handle displaying the image data here
            System.out.println("Product Quantity in Stock: " + product.getQuantityInStock());
            System.out.println();
        }

        // Fetch products by category
        String categoryName = "Sample Category"; // Replace with the actual category name
        List<Product> productsByCategory = productService.chercherProduitsParCategorie(categoryName);
        for (Product product : productsByCategory) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Product Price: " + product.getPrice());
            // You can handle displaying the image data here
            System.out.println("Product Quantity in Stock: " + product.getQuantityInStock());
            System.out.println();
        }*/
      
        // Testing adding a product to the cart
        //Panier cartItem = new Panier();
       // cartItem.setNombreProduitsAchetes(2); // Set the quantity
      //   ServicePanier servicet = new ServicePanier();
      //  product.setProductId(21); // Assuming you have a product with ID 1
      //  cartItem.setProduct(product);
       // servicet.addProductToCart(cartItem);

        // Testing viewing the cart
    /*    List<Product> cartProducts = servicet.viewCart();
        System.out.println("Products in the cart:");
        for (Product p : cartProducts) {
            System.out.println("Product ID: " + p.getProductId());
            System.out.println("Product Name: " + p.getProductName());
            System.out.println("Description: " + p.getDescription());
            System.out.println("Price: " + p.getPrice());
            System.out.println("---------------");
        }*/

   
        // Create an instance of your service or data access class
     //    ServicePanier servicePanier = new ServicePanier();

        // Replace 'yourPanierId' with the actual ID you want to retrieve
    /*    int yourPanierId = 28; // Example panierId

        Product product = servicePanier.getOneProduct(yourPanierId);

        if (product != null) {
            System.out.println("Product details for panierId " + yourPanierId + ":");
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Price: " + product.getPrice());
            // Add more fields as needed
        } else {
            System.out.println("Product not found for panierId " + yourPanierId);
        }
    }}

        // Testing deleting the cart (replace 1 with the actual cart ID you want to delete)
      //  int cartIdToDelete = 1;
       // servicet.deleteCart(cartIdToDelete);
       //  ServiceProductCategory services = new ServiceProductCategory();

        // Testing adding a product category
       // ProductCategory category = new ProductCategory();
       // category.setCategoryName("samir");
       // services.ajouterProductCategory(category);

        // Testing viewing categories and associated products
    /*    List<ProductCategory> categories = services.afficherCategory();
        for (ProductCategory c : categories) {
            System.out.println("Category ID: " + c.getCategoryId());
            System.out.println("Category Name: " + c.getCategoryName());
            System.out.println("Associated Products:");
            for (Product p : c.getProductIds()) {
                System.out.println("Product ID: " + p.getProductId());
                System.out.println("Product Name: " + p.getProductName());
                System.out.println("Description: " + p.getDescription());
                System.out.println("Price: " + p.getPrice());
                System.out.println("---------------");
            }
            System.out.println("---------------");
        }*/

        // Testing deleting a product category (replace 1 with the actual category ID you want to delete)
    //    int categoryIdToDelete = 1;
      //  services.supprimerProductCategory(categoryIdToDelete);
      //   ServiceProductCategory serviceProductCategory = new ServiceProductCategory();

        // Tester la méthode chercherProduits
      //int categoryId = 6; // Remplacez cette valeur par l'identifiant de la catégorie que vous souhaitez tester
 

    // Afficher les produits trouvés
   
   /*
ServiceProductCategory servic = new ServiceProductCategory();

        // Appelez la méthode pour récupérer les catégories avec les produits associés
        List<ProductCategory> categories = servic.afficherCategory();

        // Parcourez la liste de catégories et affichez les détails
        for (ProductCategory categoryS : categories) {
            System.out.println("Catégorie : " + category.getCategoryName());

            // Parcourez les produits associés à cette catégorie
            for (Product produc : categoryS.getProductIds()) {
                System.out.println("   Produit : " + product.getProductName());
                System.out.println("   Description : " + product.getDescription());
                System.out.println("   Prix : " + product.getPrice());
                System.out.println("   ---");
            }
            System.out.println("=================================");
        }

List<Product> productsByCategory = servic.chercherProduitsParCategorie("Electronics");

// Parcourez la liste de produits résultante et affichez-les
for (Product produc : productsByCategory) {
    System.out.println("Produit : " + product.getProductName());
    System.out.println("Description : " + product.getDescription());
    System.out.println("Prix : " + product.getPrice());
    System.out.println(" --- ");
}
 ProductService productService = new ProductService();
    String categoryName = "Electronics"; // Remplacez par le nom de la catégorie que vous recherchez

    List<Product> products = productService.chercherProduitsParCategorie(categoryName);

    if (products.isEmpty()) {
        System.out.println("Aucun produit trouvé pour la catégorie " + categoryName);
    } else {
        System.out.println("Produits trouvés pour la catégorie " + categoryName + ":");
        for (Product produ: products) {
            System.out.println("ID: " + product.getProductId());
            System.out.println("Nom: " + product.getProductName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Prix: " + product.getPrice());
            System.out.println("Quantité en stock: " + product.getQuantityInStock());
            System.out.println("------------------");
        }
    }*/  
   
    // Créer une instance de ProductCategory avec un ID valide
// ...

 /*  ProductService productService = new ProductService();

    // Créez un objet Product avec les valeurs appropriées
    Product product = new Product();
    product.setProductId(13); // Remplacez par l'ID approprié
    product.setProductName("Nom du produit");
    // Définissez d'autres propriétés du produit

    // Créez un objet ProductCategory avec les valeurs appropriées
    ProductCategory productCategory = new ProductCategory();
    productCategory.setCategoryId(6); // Remplacez par l'ID de la catégorie appropriée
    // Définissez d'autres propriétés de la catégorie

    // Ajoutez la catégorie à la table category (assurez-vous que la catégorie n'existe pas déjà)
    ServiceProductCategory serviceProductCategory = new ServiceProductCategory();
    serviceProductCategory.ajouterProductCategory(productCategory);

    // Associez la catégorie au produit
    product.setIdc_id(productCategory);*/

    // Appelez la méthode ajouterProduit de ProductService avec image null
  // productService.ajouterProduit(product, "Description du produit", null);

        // Initialisez votre connexion et créez une instance de ServicePanier
        DataSource mycnx = DataSource.getInstance();
        Connection cnx = mycnx.getCnx();
       /*  Product product = new Product();
        product.setProductId(6);// Set to actual product ID
        product.setProductName("New Product");
        product.setDescription("Product Description");
        product.setPrice(100.0);
        product.setQuantityInStock(10);
        
        // Set the category ID
        ProductCategory category = new ProductCategory();
        category.setCategoryId(5);// Set to actual category ID
        product.setIdc_id(category);

        // Create a new instance of ProductService
        ProductService service = new ProductService();

        // Call the ajouterProduit method with null image
        service.ajouterProduit(product);*/
 /*   ProductService service = new ProductService();

        // Call the afficherProduits method
        
        List<Product> products = service.afficherProduits();

        // Print the products
        for (Product product : products) {
            System.out.println(product);
        }*/
      
        // Create a new instance of ServicePanier
        
        // Create a new instance of ServicePanier
     ProductCategory category = new ProductCategory();
     ProductService service = new ProductService(); 
category.setCategoryId(6); // Remplacez par l'ID de la catégorie réelle
Product product = new Product(122,"Nommm du produit", "Description du produit",null, 10.0, 100, category);
service.ajouterProduit(product) ;
}}

        
        
       


   

    
 
        
    

   
    
    

