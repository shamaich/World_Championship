package com.shamaich.worldchampionship.admin;

import android.content.Context;

import com.shamaich.worldchampionship.R;
import com.shamaich.worldchampionship.model.Country;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class TestCountryArrayClass {

    private Context context;

    public TestCountryArrayClass(Context context) {
        this.context = context;
    }

    public ArrayList<Country> reader() {

        ArrayList<Country> countries = new ArrayList<>();

        try {
            InputStream is = context.getResources().openRawResource(R.raw.countries);
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.ISO_8859_1));
            String readLine = "";

            // While the BufferedReader readLine is not null
            while ((readLine = br.readLine()) != null) {
                //Log.d("TEXT", readLine);

                String[] line = readLine.split(",");
                //id,countryName,capitalCity,flag,population,score
                Country country = new Country();
                country.setId(line[0]);
                country.setCountryName(line[1]);
                country.setCapitalCity(line[2]);
                country.setFlag(line[3]);
                country.setPopulation(line[4]);
                country.setScore(line[5]);

                countries.add(country);
            }

// Close the InputStream and BufferedReader
            is.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return countries;
    }
}
