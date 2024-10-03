package br.com.convertcep.operations;

import br.com.convertcep.models.Adress;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {

    public void saveJson(Adress adress){

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        FileWriter wrote = null;
        try {
            wrote = new FileWriter(adress.cep() + ".json");
            wrote.write(gson.toJson(adress));
            wrote.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
