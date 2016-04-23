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
            //          System.out.println(json);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //   System.out.println(json);
        return json;
    }

    public Car getUserCarData(String jsonString) throws NumberFormatException {
        Gson gson = new Gson();

        CarFromAztec jsonCar = gson.fromJson(jsonString, CarFromAztec.class);
        String aztecError = jsonCar.getDane().getError();

        if (aztecError.equals("-4")) {
            System.out.println("Błędny kod sesji");
            System.exit(-1);
            return null;
        }

        CarsBrands cb = new CarsBrands();
        cb.setName(jsonCar.getDane().getD1());
        CarsModels cm = new CarsModels();
        cm.setName(jsonCar.getDane().getD5());
        Car carFromAztec = new Car();
        carFromAztec.setProductionYear(Integer.parseInt(jsonCar.getDane().getRok_produkcji()));
        carFromAztec.setCarsBrand(cb);
        carFromAztec.setCarsModel(cm);
        carFromAztec.setEngineCapacity(jsonCar.getDane().getSilnik());
        carFromAztec.setFuelType(jsonCar.getDane().getTyp_paliwa());
        carFromAztec.setEnginePower(jsonCar.getDane().getMoc_silnika());
        //System.out.println(jsonCar.toString());

        return carFromAztec;


//        return new String[]{
//                jsonCar.getDane().getD1(),//Brand
//                jsonCar.getDane().getD5(),//Model
//                jsonCar.getDane().getRok_produkcji()
//        };
    }


    //    public static void main(String[] args) {
//        for (String str : getUserCar("kjsm4")) {
//            System.out.println(str);
//        }
//    }

}