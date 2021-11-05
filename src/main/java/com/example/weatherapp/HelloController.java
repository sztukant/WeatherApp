package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    public Label temperature;
    @FXML
    public Label pressure;
    @FXML
    public Label windspeed;
    @FXML
    public Label winddirection;
    @FXML
    public Label humidity;
    @FXML
    public Label date;
    @FXML
    public Label stationid;

    DataGetter dg = new DataGetter();
    @FXML
    public ComboBox cityChoice;

    @FXML
    public void initialize() {
        List<String> cityList = new ArrayList<>(dg.cities.keySet());
        cityList.sort(String::compareToIgnoreCase);
        cityChoice.getItems().addAll(cityList);
        }
    @FXML
    protected void getOnAction() throws IOException {
        dg.getData(cityChoice.getValue().toString());
        StringBuilder sb = new StringBuilder();
        sb.append("  ").append(dg.showData().getString("godzina_pomiaru")+":00");
        String dateHour = sb.toString();
        temperature.setText(dg.showData().getString("temperatura"));
        pressure.setText(dg.showData().getString("cisnienie"));
        windspeed.setText(dg.showData().getString("predkosc_wiatru"));
        winddirection.setText(dg.showData().getString("kierunek_wiatru"));
        humidity.setText(dg.showData().getString("wilgotnosc_wzgledna"));
        date.setText(dg.showData().getString("data_pomiaru")+dateHour);
        stationid.setText(dg.showData().getString("id_stacji"));
    }
}