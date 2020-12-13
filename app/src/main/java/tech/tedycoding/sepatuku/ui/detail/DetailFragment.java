package tech.tedycoding.sepatuku.ui.detail;

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
import tech.tedycoding.sepatuku.model.ColorsModel;
import tech.tedycoding.sepatuku.model.SizeModel;

public class DetailFragment extends Fragment implements ColorAdapter.ItemAdapterCallback, SizeAdapter.ItemAdapterCallback {
    private RecyclerView rvColor, rvSize;
    private List<ColorsModel> listColor;
    private List<SizeModel> listSize;
    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvColor = view.findViewById(R.id.recyclerView);
        rvSize = view.findViewById(R.id.recyclerView2);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listColor = new ArrayList<>();
        listColor.add(new ColorsModel(1, R.color.colorAccent));
        listColor.add(new ColorsModel(2, R.color.colorPink));
        listColor.add(new ColorsModel(3, R.color.colorPrimary));
        listColor.add(new ColorsModel(4, R.color.colorPrimaryDark));
        listColor.add(new ColorsModel(5, R.color.colorGrey));

        ColorAdapter colorAdapter = new ColorAdapter(listColor, this);
        rvColor.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvColor.setAdapter(colorAdapter);

        listSize = new ArrayList<>();
        listSize.add(new SizeModel(1, "38\nEU"));
        listSize.add(new SizeModel(2, "39\nEU"));
        listSize.add(new SizeModel(3, "40\nEU"));
        listSize.add(new SizeModel(4, "41\nEU"));
        listSize.add(new SizeModel(5, "42\nEU"));

        SizeAdapter sizeAdapter = new SizeAdapter(listSize, this);
        rvSize.setLayoutManager(new GridLayoutManager(getContext(), 4));
        rvSize.setAdapter(sizeAdapter);
    }

    @Override
    public void onClick(View view) {

    }
}