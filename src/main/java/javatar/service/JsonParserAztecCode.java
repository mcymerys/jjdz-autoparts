package javatar.service;


import com.google.gson.Gson;
import javatar.model.Car;
import javatar.model.CarFromAztec;
import javatar.model.CarsBrands;
import javatar.model.CarsModels;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class JsonParserAztecCode {

    private final static String USER_KEY = "qY2?0Pw!";
    public static final String ERROR_BAD_SESSION_FROM_ATENA = "-4";
    private String sessionKey = null;


    private static OkHttpClient client = new OkHttpClient();

    public JsonParserAztecCode() {
    }

    public JsonParserAztecCode(String session) {
        this.sessionKey = session;
    }

    private String getCarFromRest(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String getUserCar() {

        String json = null;
        try {
            json = getCarFromRest("https://aztec.atena.pl/PWM2/rest/aztec/getbysession?sessionKey=" + sessionKey + "&userKey=" + USER_KEY);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    public Car getUserCarData(String jsonString) throws NumberFormatException {
        Gson gson = new Gson();

        CarFromAztec jsonCar = gson.fromJson(jsonString, CarFromAztec.class);
        String aztecError = jsonCar.getCarFromAztecData().getError();

        if (aztecError.equals(ERROR_BAD_SESSION_FROM_ATENA)) {
            System.out.println("Błędny kod sesji");
            System.exit(-1);
            return null;
        }

        CarsBrands cb = new CarsBrands(jsonCar);
        CarsModels cm = new CarsModels(jsonCar);

        return new Car(cb, cm, jsonCar);

    }


}
