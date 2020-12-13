package tech.tedycoding.sepatuku.ui.categories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tech.tedycoding.sepatuku.R;
import tech.tedycoding.sepatuku.model.CategoriModel;
import tech.tedycoding.sepatuku.model.HomeModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriAllFragment extends Fragment implements CategoriAdapter.ItemAdapterCallback, ShoesAdapter.ItemAdapterCallback {

    private RecyclerView rvCategori;
    private List<CategoriModel> categoriModelList;

    private RecyclerView rvShoes;
    private List<HomeModel> shoesModelList;

    public CategoriAllFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categori_all, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvCategori = view.findViewById(R.id.rv_categori);
        rvShoes = view.findViewById(R.id.rv_shoes);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        categoriModelList = new ArrayList<>();
        categoriModelList.add(new CategoriModel(1, "All"));
        categoriModelList.add(new CategoriModel(2, "Sport"));
        categoriModelList.add(new CategoriModel(3, "Casual"));

        CategoriAdapter categoriAdapter = new CategoriAdapter(categoriModelList, this);
        rvCategori.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvCategori.setAdapter(categoriAdapter);

        shoesModelList = new ArrayList<>();
        shoesModelList.add(new HomeModel(1, "Ariel", "New", "30%", "A"));
        shoesModelList.add(new HomeModel(2, "Ariel", "New", "30%", "A"));
        shoesModelList.add(new HomeModel(3, "Ariel", "New", "30%", "A"));

        ShoesAdapter shoesAdapter= new ShoesAdapter(shoesModelList, this);
        rvShoes.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rvShoes.setAdapter(shoesAdapter);
    }

    @Override
    public void onClick(View view) {
        Navigation.findNavController(view).navigate(R.id.action_categoriFragment_to_detailFragment);
    }
}
