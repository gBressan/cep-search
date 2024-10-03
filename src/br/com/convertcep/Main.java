package br.com.convertcep;

import br.com.convertcep.models.Adress;
import br.com.convertcep.operations.FileGenerator;
import br.com.convertcep.operations.GetCep;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GetCep cepConsult = new GetCep();

        System.out.println("Digite seu CEP");

        var cep = scanner.nextLine();

        try {
            Adress newAdress = cepConsult.search(cep);
            System.out.println(newAdress);
            FileGenerator generator = new FileGenerator();
            generator.saveJson(newAdress);
            System.out.println("Salvo com sucesso");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }



    }
}
