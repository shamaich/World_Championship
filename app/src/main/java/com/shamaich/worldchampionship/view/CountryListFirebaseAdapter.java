package com.shamaich.worldchampionship.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;
import com.shamaich.worldchampionship.R;
import com.shamaich.worldchampionship.databinding.ItemCountryBinding;
import com.shamaich.worldchampionship.model.Country;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CountryListFirebaseAdapter extends FirestoreRecyclerAdapter<
        Country, CountryListFirebaseAdapter.CountryViewHolder> implements CountryClickListener {

    private Context context;
    private String TAG = CountryListFirebaseAdapter.class.getSimpleName();


    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public CountryListFirebaseAdapter(@NonNull @NotNull FirestoreRecyclerOptions<Country> options, Context context) {
        super(options);
        this.context = context;
    }


    @Override
    protected void onBindViewHolder(@NonNull @NotNull CountryViewHolder holder, int position, @NonNull @NotNull Country model) {

        Log.d(TAG, "onBindViewHolder: " + model.getCountryName().toString());

        holder.itemView.setCountry(model);
        holder.itemView.setListener(this);
        Glide.with(context).load(getImage(model.getFlag())).into(holder.itemView.imageViewFlag);

    }

    public int getImage(String imageName) {

        return context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
    }

    @NonNull
    @NotNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemCountryBinding view = DataBindingUtil.inflate(layoutInflater, R.layout.item_country, parent, false);

        return new CountryListFirebaseAdapter.CountryViewHolder(view);
    }

    @Override
    public void OnCountryClicked(Country country) {

        long countryScore;

        Log.d(TAG, "OnCountryClicked: "+ country.getCountryName());

        String test = "";

        DocumentReference query = FirebaseFirestore.getInstance()
                .collection("countries").document(country.getCountryName());


// Atomically increment the population of the city by 50.
        query.update("score", FieldValue.increment(5)).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                //todo: DB call charge user

            }
        });


        Log.d(TAG, "OnCountryClicked: " + test);


    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {

        ItemCountryBinding itemView;

        public CountryViewHolder(@NonNull ItemCountryBinding itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
        }
    }
}
