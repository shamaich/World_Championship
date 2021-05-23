package com.shamaich.worldchampionship.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.shamaich.worldchampionship.R;
import com.shamaich.worldchampionship.model.Country;
import com.shamaich.worldchampionship.databinding.ItemCountryBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.CountryViewHolder> {

    private ArrayList<Country> countryArrayList;
    private int currentPosition = 0;
    private Context context;
    private String TAG = CountryListAdapter.class.getSimpleName();



    public CountryListAdapter(ArrayList<Country> countryArrayList, Context context) {
        this.countryArrayList = countryArrayList;
        this.context = context;
    }

    public void updateCountryList(ArrayList<Country> list){
        countryArrayList.clear();
        countryArrayList.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public CountryListAdapter.CountryViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemCountryBinding view = DataBindingUtil.inflate(layoutInflater, R.layout.item_country, parent, false);

        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CountryListAdapter.CountryViewHolder holder, int position) {
        currentPosition = position;
        holder.itemView.setCountry(countryArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return countryArrayList.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {

        ItemCountryBinding itemView;
        //ImageView countryFlagImg;

        public CountryViewHolder(@NonNull ItemCountryBinding itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;

            Glide.with(context).load(getImage(countryArrayList.get(currentPosition).getFlag())).into(itemView.imageViewFlag);
        }



        public int getImage(String imageName) {

            int drawableResourceId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());

            return drawableResourceId;
        }

    }
}
