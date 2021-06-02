package com.shamaich.worldchampionship.admin;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;
import com.shamaich.worldchampionship.R;
import com.shamaich.worldchampionship.model.Country;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    //Country country = new Country("2","mycountry","mycity", "1111", "flag", "5");

    private static String TAG = AdminActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        // Add a new document with a generated ID
        //db.collection("countries").document("LA").set(country);

        ArrayList<Country> countries = reader();

        for (int i = 0; i < countries.size(); i++){

            Log.d(TAG, countries.get(i).toString());

            db.collection("countries").document(countries.get(i).getCountryName()).set(countries.get(i));

        }

    }


    private ArrayList<Country> reader() {

        ArrayList<Country> countries = new ArrayList<>();

        try {
            InputStream is = this.getResources().openRawResource(R.raw.countries);
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.ISO_8859_1));
            String readLine = "";

            // While the BufferedReader readLine is not null
            while ((readLine = br.readLine()) != null) {
                //Log.d("TEXT", readLine);

                String[] line = readLine.split(",");
                //id,countryName,capitalCity,flag,population,score
                Country country = new Country();
                country.setCountryName(line[0]);
                country.setCapitalCity(line[1]);
                country.setFlag(line[2]);
                country.setPopulation(line[3]);
                country.setScore(0);

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

