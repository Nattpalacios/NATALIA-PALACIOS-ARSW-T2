package edu.eci.arsw.Coronavirus.cache;

import edu.eci.arsw.Coronavirus.model.Country;
import org.javatuples.Triplet;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class Cache {

    ArrayList<Country> countries = new ArrayList<>();
    private final CopyOnWriteArrayList<Triplet<String, Timer, String>> countriesList = new CopyOnWriteArrayList<>();

    private void countriesConnection(JSONArray paises){
        JSONObject country = null;
        for(int i = 0; i < paises.length(); i++){
            boolean flag = false;
            country = new JSONObject(paises.get(i).toString());
            for(int j = 0; j < countries.size(); j++){
                if(countries.get(j).getName().equals(country.get("country").toString())){
                    countries.get(j).setMuertos(countries.get(j).getMuertos()+ Integer.parseInt(country.get("deaths").toString()));
                    countries.get(j).setInfectados(countries.get(j).getInfectados()+ Integer.parseInt(country.get("confirmed").toString()));
                    countries.get(j).setCurados(countries.get(j).getCurados()+ Integer.parseInt(country.get("recovered").toString()));
                    flag = true;
                }
            }
            if (!flag){
                Country newCountry = new Country(country.get("country").toString(), Integer.parseInt(country.get("deaths").toString()),Integer.parseInt(country.get("confirmed").toString()),Integer.parseInt(country.get("recovered").toString()));
                countries.add(newCountry);
            }
        }
    }

}
