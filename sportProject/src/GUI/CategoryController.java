package GUI;

import Models.ProductCategory;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.ServiceProductCategory;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CategoryController implements Initializable {
    @FXML
    private TextField categoryNameField;
    @FXML
    private Button addCategoryBtn;

    private ServiceProductCategory serviceProductCategory;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        serviceProductCategory = new ServiceProductCategory();
        addCategoryBtn.setOnAction(e -> handleAddCategoryBtn());
    }

    @FXML
    private void handleAddCategoryBtn() {
        try {
            String categoryName = categoryNameField.getText();

            if (!categoryName.isEmpty()) {
                ProductCategory newCategory = new ProductCategory();
                newCategory.setCategoryName(categoryName);

                // Appel de la méthode pour ajouter la catégorie
                serviceProductCategory.ajouterProductCategory(newCategory);

                showAlert("Success", "Catégorie de produit ajoutée avec succès !");
            } else {
                showAlert("Error", "Veuillez entrer le nom de la catégorie.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Une erreur s'est produite lors de l'ajout de la catégorie.");
        }
    }

    private void showAlert(String title, String message) {
        // Ajoutez ici le code pour afficher une boîte de dialogue (Alert) avec le titre et le message fournis.
    }
       @FXML
    private void handleRetourBTN() {
        try {
            Stage panierStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("admin.fxml"));
            Parent panierRoot = loader.load();
            Scene panierScene = new Scene(panierRoot);
            panierStage.setTitle("admin");
            panierStage.setScene(panierScene);
            panierStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
