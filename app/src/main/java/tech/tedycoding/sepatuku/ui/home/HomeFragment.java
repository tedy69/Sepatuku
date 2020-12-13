package tech.tedycoding.sepatuku.ui.home;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tech.tedycoding.sepatuku.R;
import tech.tedycoding.sepatuku.model.HomeModel;
import tech.tedycoding.sepatuku.ui.categories.CategoriesActivity;

public class HomeFragment extends Fragment implements HomeAdapter.ItemAdapterCallback {
    private RecyclerView rvSport;
    private List<HomeModel> listData;
    private RecyclerView rvCasual;

    private TextView tvActionLayoutSport, tvActionLayoutCasual, tvHeaderLayoutCasual;
    private TextView tvShopNow;
    private ImageView ivShowNow;

    private ProgressDialog progressDialog;

    public HomeFragment() {
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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvSport = view.findViewById(R.id.rv_sport);
        rvCasual = view.findViewById(R.id.rv_casual);

        View headerLayoutSport = view.findViewById(R.id.layout_header_sport);
        View headerLayoutCasual = view.findViewById(R.id.layout_header_casual);
        View headerLayout = view.findViewById(R.id.layout_header);

        tvActionLayoutSport = headerLayoutSport.findViewById(R.id.tv_action);
        tvActionLayoutCasual = headerLayoutCasual.findViewById(R.id.tv_action);
        tvHeaderLayoutCasual = headerLayoutCasual.findViewById(R.id.tv_title);

        tvShopNow = headerLayout.findViewById(R.id.tv_shop_now);
        ivShowNow = headerLayout.findViewById(R.id.iv_shop_now);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listData = new ArrayList<>();
        listData.add(new HomeModel(1, "Tedy","New", "30%", "https://gdetail.image-gmkt.com/747/718701225/2019/8/546fd4f5-b756-4d48-95a1-0328426d6faa.jpg" ));
        listData.add(new HomeModel(2, "Tedy","New", "40%", "https://gdetail.image-gmkt.com/747/718701225/2019/8/546fd4f5-b756-4d48-95a1-0328426d6faa.jpg" ));
        listData.add(new HomeModel(3, "Tedy","New", "50%", "https://gdetail.image-gmkt.com/747/718701225/2019/8/546fd4f5-b756-4d48-95a1-0328426d6faa.jpg" ));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL , false);
        HomeAdapter homeAdapter = new HomeAdapter(listData, this);
        rvSport.setLayoutManager(linearLayoutManager);
        rvSport.setAdapter(homeAdapter);

        tvHeaderLayoutCasual.setText("Casual Shoes");
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        HomeAdapter homeAdapter1 = new HomeAdapter(listData, this);
        rvCasual.setLayoutManager(linearLayoutManager1);
        rvCasual.setAdapter(homeAdapter1);

        tvShopNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goCategori = new Intent(getActivity(), CategoriesActivity.class);
                startActivity(goCategori);
            }
        });

        ivShowNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goCategori = new Intent(getActivity(), CategoriesActivity.class);
                startActivity(goCategori);
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}