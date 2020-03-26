package edu.eci.arsw.Coronavirus.connection;

import org.springframework.stereotype.Service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Service
public class HttpConnectionService {

    public String connection(){
        HttpResponse<String> response = null;
        try{
            response = Unirest.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats")
                    .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                    .header("x-rapidapi-key", "cc65d2a330msha7ea3b2ae24b677p10b31ajsnfc970dcad64d")
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return response.getBody();
    }

    public String connectionByName(String country){
        HttpResponse<String> response = null;
        try{
            response = Unirest.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country="+ country)
                    .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                    .header("x-rapidapi-key", "cc65d2a330msha7ea3b2ae24b677p10b31ajsnfc970dcad64d")
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return response.getBody();
    }

}
