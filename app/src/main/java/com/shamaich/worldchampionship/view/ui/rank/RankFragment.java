package com.shamaich.worldchampionship.view.ui.rank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.shamaich.worldchampionship.R;
import com.shamaich.worldchampionship.databinding.FragmentRankBinding;
import com.shamaich.worldchampionship.model.Country;
import com.shamaich.worldchampionship.view.CountryListFirebaseAdapter;

import org.jetbrains.annotations.NotNull;

public class RankFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentRankBinding binding;
   // private CountryListAdapter countryListAdapter = new CountryListAdapter(new ArrayList<>());
    private String TAG = RankFragment.class.getSimpleName();

    private RecyclerView recyclerView;
    //private CountryListAdapter countryListAdapter;
    //private RecyclerView.LayoutManager layoutManager;*/


    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference countriesRef = db.collection("countries");
    private CountryListFirebaseAdapter countryListFirebaseAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentRankBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        /*final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpRecyclerView(view);

    }

    @Override
    public void onStart() {
        super.onStart();
        countryListFirebaseAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        countryListFirebaseAdapter.stopListening();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    private void setUpRecyclerView(View view) {

        Query query = countriesRef.orderBy("score", Query.Direction.DESCENDING).orderBy("countryName");

        FirestoreRecyclerOptions<Country> options =
                new FirestoreRecyclerOptions.Builder<Country>()
                        .setQuery(query, Country.class)
                        .build();

        countryListFirebaseAdapter = new CountryListFirebaseAdapter(options, getContext());

        recyclerView = view.findViewById(R.id.recycler_view_countryList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(countryListFirebaseAdapter);

    }
}