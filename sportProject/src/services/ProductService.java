package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Product;
import Models.ProductCategory;
import util.DataSource;
import Models.ProductCategory;
import java.sql.Statement;
import services.ServiceProductCategory;

public class ProductService {
    private DataSource mycnx = DataSource.getInstance();
    private Connection cnx = mycnx.getCnx();

    public ProductService() {
    }

    public void ajouterProduit(Product p) {
    String query = "INSERT INTO product(id, product_name, description, image, price, quantity_in_stock, idc_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement preparedStatement = cnx.prepareStatement(query)) {
        preparedStatement.setInt(1, p.getProductId());
        preparedStatement.setString(2, p.getProductName());
        preparedStatement.setString(3, p.getDescription());
        preparedStatement.setBytes(4, p.getImage());
        preparedStatement.setDouble(5, p.getPrice());
        preparedStatement.setInt(6, p.getQuantityInStock());
        
        
        // Assurez-vous que la valeur de idc_id est correcte (remplacez par la valeur appropriée)
      if (p.getIdc_id() != null) {
    preparedStatement.setInt(7, p.getIdc_id().getCategoryId());
} else {
    // Gérez le cas où idc_id est null (remplacez 0 par la valeur par défaut appropriée)
    preparedStatement.setInt(7, 0);
}

       
 // Remplacez getId() par la méthode appropriée pour obtenir l'ID de ProductCategory

        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Produit avec image et description ajouté avec succès !");
        } else {
            System.out.println("Échec de l'ajout du produit avec image et description.");
        }
    } catch (SQLException ex) {
        Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
    }
}


    public void modifierPrixProduit(int productId, double nouveauPrix) {
        String query = "UPDATE product SET price = ? WHERE id  = ?";

        try (PreparedStatement preparedStatement = cnx.prepareStatement(query)) {
            preparedStatement.setDouble(1, nouveauPrix);
            preparedStatement.setInt(2, productId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Prix du produit avec productId " + productId + " modifié avec succès !");
            } else {
                System.out.println("Échec de la modification du prix du produit avec productId " + productId + ".");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void supprimerProduit(int productId) {
        String query = "DELETE FROM product WHERE id = ?";

        try (PreparedStatement preparedStatement = cnx.prepareStatement(query)) {
            preparedStatement.setInt(1, productId);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Produit avec productId " + productId + " supprimé avec succès.");
            } else {
                System.out.println("Aucun produit trouvé avec productId " + productId + ". Rien n'a été supprimé.");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression du produit : " + e.getMessage());
        }
    }
public List<Product> afficherProduits() {
    List<Product> produits = new ArrayList<>();
    String query = "SELECT p.id, p.product_name, p.image, p.price, p.quantity_in_stock, c.category_name FROM product p INNER JOIN category c ON p.idc_id = c.id";

    try (PreparedStatement preparedStatement = cnx.prepareStatement(query);
         ResultSet resultSet = preparedStatement.executeQuery()) {

        while (resultSet.next()) {
            int productId = resultSet.getInt("id");
            String productName = resultSet.getString("product_name");
            byte[] image = resultSet.getBytes("image");
            double price = resultSet.getDouble("price");
            int quantityInStock = resultSet.getInt("quantity_in_stock");
            String categoryName = resultSet.getString("category_name");

            Product produit = new Product(productId, productName, null, image, price, quantityInStock);
           // Assuming you have a setter for category name in your Product class
            produits.add(produit);
        }
    } catch (SQLException e) {
        System.err.println("Erreur lors de l'affichage des produits : " + e.getMessage());
    }

    return produits;
}


  

   /* public List<Product> chercherProduitsParCategorie(String categoryName) {
        List<Product> produits = new ArrayList<>();
        String query = "SELECT p.productId, p.productName, p.image, p.price, p.quantityInStock " +
                "FROM productCategory c " +
                "JOIN productCategory_Products pcp ON c.categoryId = pcp.categoryId " +
                "JOIN product p ON pcp.productId = p.productId " +
                "WHERE c.categoryName = ?";

        try (PreparedStatement preparedStatement = cnx.prepareStatement(query)) {
            preparedStatement.setString(1, categoryName);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int productId = resultSet.getInt("id ");
                String productName = resultSet.getString("product_name");
                String descreption = resultSet.getString("description");
                byte[] image = resultSet.getBytes("image");
                double price = resultSet.getDouble("price");
                int quantityInStock = resultSet.getInt("quantity_in_stock");

             Product produit = new Product(productId, productName, null, image, price, quantityInStock);

                produits.add(produit);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des produits par catégorie : " + e.getMessage());
        }

        return produits;
    }*/
public List<ProductCategory> getAllCategories() {
    List<ProductCategory> categories = new ArrayList<>();
    String req = "SELECT DISTINCT c.id, c.category_name " +
                 "FROM Category c " +
                 "LEFT JOIN product p ON c.id = p.id";

    try (Statement st = cnx.createStatement();
         ResultSet rs = st.executeQuery(req)) {

        while (rs.next()) {
            ProductCategory c = new ProductCategory();
            c.setCategoryId(rs.getInt("id"));
            c.setCategoryName(rs.getString("category_name"));

            categories.add(c);
        }
    } catch (SQLException e) {
        Logger.getLogger(ServiceProductCategory.class.getName()).log(Level.SEVERE, null, e);
    }

    return categories;
}

    public Product obtenirUn(int productId) {
        String query = "SELECT id, product_name, description, image, price, quantity_in_stock FROM product WHERE productId = ?";

        try (PreparedStatement preparedStatement = cnx.prepareStatement(query)) {
            preparedStatement.setInt(1, productId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int retrievedProductId = resultSet.getInt("id");
                    String productName = resultSet.getString("product_name");
                    String description = resultSet.getString("description");
                    byte[] image = resultSet.getBytes("image");
                    double price = resultSet.getDouble("price");
                    int quantityInStock = resultSet.getInt("quantity_in_stock");

                    Product produit = new Product(retrievedProductId, productName, description, image, price, quantityInStock);
                    return produit;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du produit : " + e.getMessage());
        }

        return null; // Retourne null si le produit n'est pas trouvé
    }
}
