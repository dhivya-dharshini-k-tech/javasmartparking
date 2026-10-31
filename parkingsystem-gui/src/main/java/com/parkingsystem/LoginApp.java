package com.parkingsystem;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LoginApp extends Application {

    @Override
    public void start(Stage stage) {

        Label title = new Label("ParkingSystem");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        title.setTextFill(Color.web("#1D4ED8"));

        Label subtitle = new Label(
                "Parking System");
        subtitle.setStyle("-fx-text-fill: #64748b;");

        Label welcome = new Label("Welcome Back!");
        welcome.setFont(Font.font("Arial", FontWeight.BOLD, 21));

        Label emailLabel = new Label("Email Address");

        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email");
        emailField.setMaxWidth(300);

        Label passwordLabel = new Label("Password");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
        passwordField.setMaxWidth(300);

        Button loginButton = new Button("Login");
        loginButton.setMaxWidth(300);
        loginButton.setDefaultButton(true);
        loginButton.setStyle(
                "-fx-background-color: #2563eb;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 15px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 8px;" +
                "-fx-padding: 10px;"
        );

        Label message = new Label();
        message.setWrapText(true);

        loginButton.setOnAction(event -> {

            String email = emailField.getText().trim();
            String password = passwordField.getText();

            if (email.isEmpty() || password.isEmpty()) {
                message.setText("Please enter email and password.");
                message.setTextFill(Color.RED);

            } else if (email.equals("park@gmail.com")
                    && password.equals("park")) {

                stage.close();

                parkingsystem.Main.main(new String[0]);

                message.setText("Login successful!");
                message.setTextFill(Color.GREEN);

            } else {
                message.setText(
                        "Invalid email or password. Try again.");
                message.setTextFill(Color.RED);
            }
        });

        VBox root = new VBox(12);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(35));
        root.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 15px;"
        );

        root.getChildren().addAll(
                title,
                subtitle,
                welcome,
                emailLabel,
                emailField,
                passwordLabel,
                passwordField,
                loginButton,
                message
        );

        VBox page = new VBox(root);
        page.setAlignment(Pos.CENTER);
        page.setPadding(new Insets(25));
        page.setStyle("-fx-background-color: #eaf1fb;");

        Scene scene = new Scene(page, 500, 580);

        stage.setTitle("JobMatch - Login");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}