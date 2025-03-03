package com.kristian.d2025021701;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelloController {
    @FXML
    private ListView<Player> players;
    @FXML
    private Label playerInfo;

    @FXML
    protected void initialize() {
        players.getItems().add(new Player("ShadowHunter99", 75, PlayerClass.FIGHTER, "shadow.hunter@email.com", LocalDate.of (2020, 1, 1)));
    }

    @FXML
    protected void addPlayer() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("playerAdd.fxml"));
            VBox form = fxmlLoader.load();

            PlayerFormController controller = fxmlLoader.getController();

            Stage stage = new Stage();
            stage.setTitle("Add Player");
            stage.setScene(new Scene(form));
            stage.showAndWait();

            Player player = controller.getPlayer();

            if (player == null) {
                return;
            }

            players.getItems().add(controller.getPlayer());

        } catch (IOException e) {
            //handle exception
        }
    }
    @FXML
    protected void deletePlayer() {
        Player player = players.getSelectionModel().getSelectedItem();
        players.getItems().remove(player);

    }
    @FXML
    protected void editPlayer() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("playerAdd.fxml"));
            VBox form = fxmlLoader.load();

            PlayerFormController controller = fxmlLoader.getController();

            controller.setPlayer(players.getSelectionModel().getSelectedItem());
            controller.load();

            Stage stage = new Stage();
            stage.setTitle("edit Player");
            stage.setScene(new Scene(form));
            stage.showAndWait();

            Player player = controller.getPlayer();
        } catch (IOException e) {
            //handle exception
        }
    }
    @FXML
    protected void showPlayer() {
        Player player = players.getSelectionModel().getSelectedItem();
        if (player == null) {
            return;
        }

        String output = "Uživatelské jméno: "+ player.getUsername()+"\nLevel: "+player.getLevel()+"\nRole: "+player.getPlayerClass()+"\nEmail: " + player.getEmail()+"\nRegistrace: "+player.getRegistered().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        if (player.getLevel() >= 50) {
            playerInfo.setTextFill(Paint.valueOf("red"));
        } else if (player.getLevel() >= 20) {
            playerInfo.setTextFill(Paint.valueOf("blue"));
        } else {
            playerInfo.setTextFill(Paint.valueOf("green"));
        }

        playerInfo.setText(output);
    }
}