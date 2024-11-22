package com.example.assignment2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(20);
        root.setPadding(new Insets(15));
        root.setAlignment(Pos.TOP_CENTER);

        Text welcomeText = new Text("Welcome to Registration Form");
        welcomeText.setFont(new Font("Arial", 24));
        root.getChildren().add(welcomeText);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(50);
        gridPane.setVgap(15);
        gridPane.setPadding(new Insets(15, 15, 15, 15));

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label fatherNameLabel = new Label("Father Name:");
        TextField fatherNameField = new TextField();

        Label cnicLabel = new Label("CNIC:");
        TextField cnicField = new TextField();

        Label dobLabel = new Label("Date:");
        DatePicker datePicker = new DatePicker();

        Label genderLabel = new Label("Gender:");
        ComboBox<String> genderComboBox = new ComboBox<>();
        genderComboBox.getItems().addAll("Male", "Female", "Other");

        Label cityLabel = new Label("City:");
        ComboBox<String> citynames = new ComboBox<>();
        citynames.getItems().addAll("Lahore", "Karachi", "Islamabad", "Peshawar", "Quetta", "Rahim Yar Khan");

        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameField, 1, 0);

        gridPane.add(fatherNameLabel, 0, 1);
        gridPane.add(fatherNameField, 1, 1);

        gridPane.add(cnicLabel, 0, 2);
        gridPane.add(cnicField, 1, 2);

        gridPane.add(dobLabel, 0, 3);
        gridPane.add(datePicker, 1, 3);

        gridPane.add(genderLabel, 0, 4);
        gridPane.add(genderComboBox, 1, 4);

        gridPane.add(cityLabel, 0, 5);
        gridPane.add(citynames, 1, 5);

        ImageView imageView = new ImageView();
        imageView.setFitWidth(150);
        imageView.setFitHeight(150);
        imageView.setPreserveRatio(true);

        Button choosePhotoButton = new Button("Choose Photo");
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));

        final String[] imageFilePath = {null};

        choosePhotoButton.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                imageFilePath[0] = selectedFile.getAbsolutePath();
                Image image = new Image(selectedFile.toURI().toString());
                imageView.setImage(image);
            }
        });

        VBox imageBox = new VBox(10, imageView, choosePhotoButton);
        imageBox.setAlignment(Pos.CENTER);
        gridPane.add(imageBox, 3, 0, 1, 6);

        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            String name = nameField.getText();
            String fatherName = fatherNameField.getText();
            String cnic = cnicField.getText();
            String dateOfBirth = datePicker.getValue() != null ? datePicker.getValue().toString() : "Not Selected";
            String gender = genderComboBox.getValue() != null ? genderComboBox.getValue() : "Not Selected";
            String city = citynames.getValue() != null ? citynames.getValue() : "Not Selected";
            String imagePath = imageFilePath[0] != null ? imageFilePath[0] : "No image selected";

            System.out.println("Name: " + name);
            System.out.println("Father Name: " + fatherName);
            System.out.println("CNIC: " + cnic);
            System.out.println("Date of Birth: " + dateOfBirth);
            System.out.println("Gender: " + gender);
            System.out.println("City: " + city);
            System.out.println("Image Path: " + imagePath);
        });

        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> primaryStage.close());

        HBox buttonBox = new HBox(10, saveButton, cancelButton);
        buttonBox.setAlignment(Pos.CENTER);
        gridPane.add(buttonBox, 1, 6);

        root.getChildren().add(gridPane);

        Scene scene = new Scene(root, 600, 450);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Person Form with Image");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
