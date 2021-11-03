package com.example.weatherapp;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class DataGetter {
    private final JSONObject cities = new JSONObject("{\"Białystok\":\"bialystok\",\"Bielsko Biała\":\"bielskobiala\",\"Chojnice\":\"chojnice\",\"Częstochowa\":\"czestochowa\",\"Elbląg\":\"elblag\",\"Gdańsk\":\"gdansk\",\"Gorzów\":\"gorzow\",\"Hel\":\"hel\",\"Jelenia Góra\":\"jeleniagora\",\"Kalisz\":\"kalisz\",\"Kasprowy Wierch\":\"kasprowywierch\",\"Katowice\":\"katowice\",\"Kętrzyn\":\"ketrzyn\",\"Kielce\":\"kielce\",\"Kłodzko\":\"klodzko\",\"Koło\":\"kolo\",\"Kołobrzeg\":\"kolobrzeg\",\"Koszalin\":\"koszalin\",\"Kozienice\":\"kozienice\",\"Kraków\":\"krakow\",\"Krosno\":\"krosno\",\"Legnica\":\"legnica\",\"Lesko\":\"lesko\",\"Leszno\":\"leszno\",\"Lębork\":\"lebork\",\"Lublin\":\"lublin\",\"Łeba\":\"leba\",\"Łódź\":\"lodz\",\"Mikołajki\":\"mikolajki\",\"Mława\":\"mlawa\",\"Nowy Sącz\":\"nowysacz\",\"Olsztyn\":\"olsztyn\",\"Opole\":\"opole\",\"Ostrołęka\":\"ostroleka\",\"Piła\":\"pila\",\"Płock\":\"plock\",\"Poznań\":\"poznan\",\"Przemyśl\":\"przemysl\",\"Racibórz\":\"raciborz\",\"Resko\":\"resko\",\"Rzeszów\":\"rzeszow\",\"Sandomierz\":\"sandomierz\",\"Siedlce\":\"siedlce\",\"Słubice\":\"slubice\",\"Sulejów\":\"sulejow\",\"Suwałki\":\"suwalki\",\"Szczecin\":\"szczecin\",\"Szczecinek\":\"szczecinek\",\"Śnieżka\":\"sniezka\",\"Świnoujście\":\"swinoujscie\",\"Tarnów\":\"tarnow\",\"Terespol\":\"terespol\",\"Toruń\":\"torun\",\"Ustka\":\"ustka\",\"Warszawa\":\"warszawa\",\"Wieluń\":\"wielun\",\"Włodawa\":\"wlodawa\",\"Wrocław\":\"wroclaw\",\"Zakopane\":\"zakopane\",\"Zamość\":\"zamosc\",\"Zielona Góra\":\"zielonagora\"}");
    private JSONObject cityData;

    void getData(String city) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("https://danepubliczne.imgw.pl/api/data/synop/station/").append(cities.getString(city)).append("/format/json");
        try {
            cityData = new JSONObject(IOUtils.toString(new URL(sb.toString()), StandardCharsets.UTF_8));

        } catch (MalformedURLException e){
            System.out.println(e);
        }

    }
    JSONObject showData(){
        return cityData;
    }
}