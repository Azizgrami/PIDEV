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

import Models.Product;
import Models.ProductCategory;
import util.DataSource;

public class ServiceProductCategory {
    DataSource mycnx = DataSource.getInstance();
    Connection cnx = mycnx.getCnx();

    // Cette méthode ajoute une catégorie de produit
    public void ajouterProductCategory(ProductCategory c) {
        String req = "INSERT INTO Category(category_name) VALUES (?)";

        try (PreparedStatement preparedStatement = cnx.prepareStatement(req, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, c.getCategoryName());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Catégorie de produit ajoutée avec succès !");
            } else {
                System.out.println("Échec de l'ajout de la catégorie de produit.");
            }

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                c.setCategoryId(generatedId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProductCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Cette méthode supprime une catégorie de produit
    public void supprimerProductCategory(int categoryId) {
        String req = "DELETE FROM Category WHERE id = ?";

        try (PreparedStatement preparedStatement = cnx.prepareStatement(req)) {
            preparedStatement.setInt(1, categoryId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Catégorie de produit supprimée avec succès !");
            } else {
                System.out.println("Aucune catégorie de produit trouvée avec l'ID " + categoryId + ". Rien n'a été supprimé.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProductCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
private boolean categoryExists(int categoryId) {
    String query = "SELECT COUNT(*) FROM category WHERE id = ?";
    try (PreparedStatement preparedStatement = cnx.prepareStatement(query)) {
        preparedStatement.setInt(1, categoryId);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); // Gérer les exceptions de manière appropriée dans votre application
    }
    return false;
}

private int insertCategory(ProductCategory category) {
    String query = "INSERT INTO category (id, category_name) VALUES (DEFAULT, ?)";
    try (PreparedStatement preparedStatement = cnx.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
        preparedStatement.setString(1, category.getCategoryName());
        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); // Gérer les exceptions de manière appropriée dans votre application
    }
    return -1; // Retourner une valeur qui indique une insertion échouée
}
    // Cette méthode affiche la liste des catégories de produit
    public List<ProductCategory> afficherCategory() {
        List<ProductCategory> categories = new ArrayList<>();
        String req = "SELECT c.id, c.category_name, p.id, p.product_name, p.description, p.price " +
                     "FROM Category c " +
                     "LEFT JOIN product p ON c.id = p.id";

        try (Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery(req)) {

            while (rs.next()) {
                ProductCategory c = new ProductCategory();
                c.setCategoryId(rs.getInt("id"));
                c.setCategoryName(rs.getString("category_name"));

                Product p = new Product();
                p.setProductId(rs.getInt("id"));
                p.setProductName(rs.getString("product_name"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getDouble("price"));

                c.getProductIds().add(p);

                categories.add(c);
            }
        } catch (SQLException e) {
            Logger.getLogger(ServiceProductCategory.class.getName()).log(Level.SEVERE, null, e);
        }

        return categories;
    }
}
