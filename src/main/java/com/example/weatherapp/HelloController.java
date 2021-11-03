package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import org.json.JSONObject;

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
    public void initialize(){
        JSONObject city = new JSONObject("{\"Białystok\":\"bialystok\",\"Bielsko Biała\":\"bielskobiala\",\"Chojnice\":\"chojnice\",\"Częstochowa\":\"czestochowa\",\"Elbląg\":\"elblag\",\"Gdańsk\":\"gdansk\",\"Gorzów\":\"gorzow\",\"Hel\":\"hel\",\"Jelenia Góra\":\"jeleniagora\",\"Kalisz\":\"kalisz\",\"Kasprowy Wierch\":\"kasprowywierch\",\"Katowice\":\"katowice\",\"Kętrzyn\":\"ketrzyn\",\"Kielce\":\"kielce\",\"Kłodzko\":\"klodzko\",\"Koło\":\"kolo\",\"Kołobrzeg\":\"kolobrzeg\",\"Koszalin\":\"koszalin\",\"Kozienice\":\"kozienice\",\"Kraków\":\"krakow\",\"Krosno\":\"krosno\",\"Legnica\":\"legnica\",\"Lesko\":\"lesko\",\"Leszno\":\"leszno\",\"Lębork\":\"lebork\",\"Lublin\":\"lublin\",\"Łeba\":\"leba\",\"Łódź\":\"lodz\",\"Mikołajki\":\"mikolajki\",\"Mława\":\"mlawa\",\"Nowy Sącz\":\"nowysacz\",\"Olsztyn\":\"olsztyn\",\"Opole\":\"opole\",\"Ostrołęka\":\"ostroleka\",\"Piła\":\"pila\",\"Płock\":\"plock\",\"Poznań\":\"poznan\",\"Przemyśl\":\"przemysl\",\"Racibórz\":\"raciborz\",\"Resko\":\"resko\",\"Rzeszów\":\"rzeszow\",\"Sandomierz\":\"sandomierz\",\"Siedlce\":\"siedlce\",\"Słubice\":\"slubice\",\"Sulejów\":\"sulejow\",\"Suwałki\":\"suwalki\",\"Szczecin\":\"szczecin\",\"Szczecinek\":\"szczecinek\",\"Śnieżka\":\"sniezka\",\"Świnoujście\":\"swinoujscie\",\"Tarnów\":\"tarnow\",\"Terespol\":\"terespol\",\"Toruń\":\"torun\",\"Ustka\":\"ustka\",\"Warszawa\":\"warszawa\",\"Wieluń\":\"wielun\",\"Włodawa\":\"wlodawa\",\"Wrocław\":\"wroclaw\",\"Zakopane\":\"zakopane\",\"Zamość\":\"zamosc\",\"Zielona Góra\":\"zielonagora\"}");
        List<String> cityList = new ArrayList<>(city.keySet());
        cityList.sort(String::compareToIgnoreCase);
        cityChoice.getItems().addAll(cityList);
        }
    @FXML
    protected void getOnAction() throws IOException {
        //StringBuilder sb = new StringBuilder();
        //sb.append(dg.showData().getString("id_stacji")+"  "+dg.showData().getString("godzina_pomiaru")+":00");
        //String dateHour = sb.toString();
        dg.getData(cityChoice.getValue().toString());
        temperature.setText(dg.showData().getString("temperatura"));
        pressure.setText(dg.showData().getString("cisnienie"));
        windspeed.setText(dg.showData().getString("predkosc_wiatru"));
        winddirection.setText(dg.showData().getString("kierunek_wiatru"));
        humidity.setText(dg.showData().getString("wilgotnosc_wzgledna"));
        date.setText(dg.showData().getString("data_pomiaru"));
        stationid.setText(dg.showData().getString("id_stacji"));
    }
    }