package GUI;

import Models.Product;
import Models.ProductCategory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import services.ProductService;

public class AjoutController implements Initializable {
    @FXML
    private Button chooseImageBtn;
    @FXML
    private ImageView imagev;
    @FXML
    private TextField nomAREA;
    @FXML
    private TextField descreptionAREA;
    @FXML
    private TextField prixAREA;
    @FXML
    private TextField stockAREA;
    @FXML
    private ChoiceBox<ProductCategory> categoryChoiceBox;
    @FXML
    private Button validerBtn;
    @FXML
    private Button annulerBtn;

    private File selectedFile;
    private ProductService productService;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        productService = new ProductService();

        List<ProductCategory> categories = productService.getAllCategories();
        categoryChoiceBox.getItems().addAll(categories);

        validerBtn.setOnAction(e -> handleValiderBtn());
        chooseImageBtn.setOnAction(e -> handleChooseImage());
        annulerBtn.setOnAction(e -> handleAnnulerBtn());
    }

    @FXML
 private void handleValiderBtn() {
    try {
        
        String productName = nomAREA.getText();
        String description = descreptionAREA.getText();
        String priceText = prixAREA.getText();
        String stockText = stockAREA.getText();

        double price;
        int quantityInStock;

        try {
            price = Double.parseDouble(priceText);
        } catch (NumberFormatException e) {
            showAlert("Error", "Le prix doit être un nombre valide.");
            return;
        }

        try {
            quantityInStock = Integer.parseInt(stockText);
        } catch (NumberFormatException e) {
            showAlert("Error", "La quantité en stock doit être un nombre entier valide.");
            return;
        }

        ProductCategory selectedCategory = categoryChoiceBox.getValue();

        if (selectedCategory == null) {
            showAlert("Error", "Veuillez sélectionner une catégorie pour le produit.");
        } else {
            if (selectedFile != null) {
                byte[] imageBytes = convertFileToByteArray(selectedFile);

               // ...
Product product = new Product(2555555, productName, description, imageBytes, price, quantityInStock, selectedCategory);
productService.ajouterProduit(product);
// ...


                // Ajout de logs pour identifier où l'erreur se produit
                System.out.println("Avant appel à ajouterProduit");  // Log
                productService.ajouterProduit(product);
                System.out.println("Après appel à ajouterProduit");   // Log

                showAlert("Success", "Produit avec image et description ajouté avec succès !");
            } else {
                showAlert("Error", "Veuillez choisir un fichier image.");
            }
        }
    } catch (Exception e) {
        // Ajout de logs pour afficher la trace de l'exception
        e.printStackTrace();  // Log
        showAlert("Error", "Une erreur s'est produite. Veuillez vérifier les données saisies.");
    }
}


    @FXML
    private void handleChooseImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png"));
        selectedFile = fileChooser.showOpenDialog(new Stage());

        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            imagev.setImage(image);
        }
    }

    private byte[] convertFileToByteArray(File file) throws IOException {
        byte[] imageBytes;
        try (FileInputStream fis = new FileInputStream(file);
             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            int read;
            byte[] buffer = new byte[1024];
            while ((read = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, read);
            }
            imageBytes = bos.toByteArray();
        }
        return imageBytes;
    }

    @FXML
    private void handleAnnulerBtn() {
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

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
