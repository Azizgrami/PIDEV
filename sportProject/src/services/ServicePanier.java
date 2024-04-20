package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Models.Panier;
import Models.Product;
import util.DataSource;

public class ServicePanier {
    private DataSource mycnx = DataSource.getInstance();
    private Connection cnx = mycnx.getCnx();

   public void addProductToCart(Panier cart, Product product) {
        String query = "INSERT INTO cart (quantity) VALUES ( ?)";

        try (PreparedStatement preparedStatement = cnx.prepareStatement(query)) {
            preparedStatement.setInt(1, cart.getNombreProduitsAchetes());
           

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Produit ajouté au panier avec succès !");
            } else {
                System.out.println("Échec de l'ajout du produit au panier.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicePanier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteCart(int cartId) {
        String query = "DELETE FROM cart WHERE id = ?";

        try (PreparedStatement preparedStatement = cnx.prepareStatement(query)) {
            preparedStatement.setInt(1, cartId);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Cart with ID " + cartId + " deleted successfully.");
            } else {
                System.out.println("No cart found with ID " + cartId + ". Nothing was deleted.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicePanier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public List<Product> viewCart(int cartId) {
    List<Product> cartProducts = new ArrayList<>();
    String query = "SELECT p.id, pr.product_name, pr.image, pr.price, pr.quantity_in_stock FROM cart p " +
            "INNER JOIN product pr ON p.id = pr.id WHERE p.id = ?";

    try (PreparedStatement preparedStatement = cnx.prepareStatement(query)) {
        preparedStatement.setInt(1, cartId);

        try (ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("pr.id"));
                product.setProductName(rs.getString("pr.product_name"));
                product.setImage(rs.getBytes("pr.image"));
                product.setPrice(rs.getDouble("pr.price"));
                product.setQuantityInStock(rs.getInt("pr.quantity_in_stock"));

                cartProducts.add(product);
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(ServicePanier.class.getName()).log(Level.SEVERE, null, ex);
    }

    return cartProducts;
}
}
