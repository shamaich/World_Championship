package com.shamaich.worldchampionship.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.shamaich.worldchampionship.R;
import com.shamaich.worldchampionship.databinding.ItemCountryBinding;
import com.shamaich.worldchampionship.model.Country;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CountryListFirebaseAdapter extends FirestoreRecyclerAdapter<
        Country, CountryListFirebaseAdapter.CountryViewHolder> {

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

    public class CountryViewHolder extends RecyclerView.ViewHolder {

        ItemCountryBinding itemView;

        public CountryViewHolder(@NonNull ItemCountryBinding itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
        }
    }
}
