package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import Models.Product;
import services.ServicePanier;

import java.io.IOException;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class PanierController {

    @FXML
    private Button afficherPanierBtn;

    @FXML
    private Button retourBtn;

    @FXML
    private Label totalPriceLabel;

    @FXML
    private ListView<Product> cartListView;

    private ServicePanier servicePanier;

    public PanierController() {
        servicePanier = new ServicePanier();
    }

    public void initialize() {
        // Supposez que vous avez un cartId ou récupérez-le de quelque part
        int cartId = 1; // Remplacez par le cartId réel

        // Appelez la méthode viewCart pour récupérer les produits du panier
        List<Product> cartProducts = servicePanier.viewCart(cartId);

        // Remplissez la ListView avec les produits du panier
        cartListView.getItems().setAll(cartProducts);

        // Calculez et affichez le prix total
        double totalPrice = calculateTotalPrice(cartProducts);
        totalPriceLabel.setText("Prix total : $" + totalPrice);
    }

    private double calculateTotalPrice(List<Product> cartProducts) {
        double total = 0.0;
        for (Product product : cartProducts) {
            total += product.getPrice(); // En supposant que Product a une méthode getPrice()
        }
        return total;
    }

    @FXML
    void handleRetourBtn() {
        try {
            // Créez un nouveau stage pour l'interface "EcommerceController"
            Stage ecommerceStage = new Stage();

            // Chargez l'interface "EcommerceController" (FXML) à l'aide de FXMLLoader
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Ecommerce.fxml"));
            Parent ecommerceRoot = loader.load();

            // Configurez la scène avec l'interface "EcommerceController" chargée
            Scene ecommerceScene = new Scene(ecommerceRoot);

            // Définissez le titre de la fenêtre (facultatif)
            ecommerceStage.setTitle("E-commerce");

            // Définissez la scène pour le nouveau stage et affichez-le
            ecommerceStage.setScene(ecommerceScene);
            ecommerceStage.show();

            // Fermez la fenêtre actuelle (Panier) si nécessaire
            Stage currentStage = (Stage) retourBtn.getScene().getWindow();
            currentStage.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            // Gérez l'erreur correctement
        }
    }
}
