package com.kristian.d2025021701;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PlayerFormController {
    private Player player = null;

    @FXML
    protected TextField name;

    @FXML
    protected Spinner<Integer> spinner;
    @FXML
    protected TextField email;


    @FXML
    protected ToggleButton bojovnik;
    @FXML
    protected ToggleButton mag;
    @FXML
    protected ToggleButton strelec;

    @FXML
    protected DatePicker date;


    @FXML
    protected void initialize() {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0, 1);
        spinner.setValueFactory(valueFactory);

        if (player != null) {

        }
    }

    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player p) {
        this.player = p;
    }

    @FXML
    protected void load() {
        name.setText(player.getUsername());
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, player.getLevel(), 1);
        spinner.setValueFactory(valueFactory);

        switch (player.getPlayerClass()) {
            case FIGHTER -> bojovnik.setSelected(true);
            case MAGE -> bojovnik.setSelected(true);
            case ARCHER -> bojovnik.setSelected(true);
        }
        email.setText(player.getEmail());
        date.setValue(player.getRegistered());
    }

    @FXML
    protected void save() {
        PlayerClass role = null;
        if (bojovnik.isSelected()) {
            role = PlayerClass.FIGHTER;
        }
        if (mag.isSelected()) {
            role = PlayerClass.MAGE;
        }
        if (strelec.isSelected()) {
            role = PlayerClass.ARCHER;
        }

        if (player != null) {
            player.setUsername(name.getText());
            player.setLevel(spinner.getValue());
            if (bojovnik.isSelected()) {
                player.setPlayerClass(PlayerClass.FIGHTER);
            }
            if (mag.isSelected()) {
                player.setPlayerClass(PlayerClass.MAGE);
            }
            if (strelec.isSelected()) {
                player.setPlayerClass(PlayerClass.ARCHER);
            }

            player.setEmail(email.getText());
            player.setRegistered(date.getValue());
        } else {
            player = new Player(name.getText(), spinner.getValue(), role, email.getText(), date.getValue());
        }
        close();
    }
    @FXML
    protected void close() {
        name.getScene().getWindow().hide();
    }
}
