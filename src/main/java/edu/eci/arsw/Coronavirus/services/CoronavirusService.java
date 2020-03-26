package edu.eci.arsw.Coronavirus.services;

import edu.eci.arsw.Coronavirus.cache.Cache;
import edu.eci.arsw.Coronavirus.cache.CoronavirusException;
import edu.eci.arsw.Coronavirus.connection.HttpConnectionService;
import edu.eci.arsw.Coronavirus.model.Country;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CoronavirusService {

    @Autowired
    HttpConnectionService conexion = null;
    @Autowired
    Cache cache = null;

    /**
     * Revisa si la informacion del pais con sus regiones se encuentra en el cache o si debe traerla de nuevo
     * @param country nombre del pais
     * @return todas las regiones del pais especificado en una String
     * @throws CoronavirusException si el pais no existe
     */
    public String countryByName(String country) throws CoronavirusException{
        String c = cache.countryByName(country);
        if(c != null){
            return c;
        }else{
            cache.countryByName(country,conexion.connectionByName(country));
            return cache.countryByName(country);
        }
    }

    /**
     * Trae la informacion de un pais del cache
     * @param country nombre del pais
     * @return toda la informacion del pais especificado
     * @throws CoronavirusException si el pais no se encuentra
     */
    public Country infoCountry(String country) throws CoronavirusException{
        return cache.infoCountry(country);
    }

    /**
     * Revisa si la informacion de los paises se encuentra en el cache o si es necesario traerla de nuevo
     * @return toda la informacion de los paises relacionada con el covid19
     */
    public ArrayList<Country> countries() throws CoronavirusException {
        if(cache.countriesEmpty()){
            String data = conexion.connection();
            JSONObject newData = new JSONObject(data);
            JSONObject coronavirus = new JSONObject(newData.get("data").toString());
            JSONArray paises = new JSONArray(coronavirus.get("covid19Stats").toString());
            cache.countriesConnection(paises);
        }

        return cache.getCountries();
    }

}
