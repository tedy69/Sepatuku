package tech.tedycoding.sepatuku.ui.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;

import tech.tedycoding.sepatuku.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {

    private Button btnCheckout;
    private ImageView ivProduk;
    private RelativeLayout rlCartDetail;
    private LinearLayout cartCheckout, llEmpty;
    private TextView tvTitle, tvDesc, tvPrice, tvPriceTotal;

//    private CartPreferences cartPreferences;

    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnCheckout = view.findViewById(R.id.btnCheckout);
        ivProduk = view.findViewById(R.id.iv_produk);
        rlCartDetail = view.findViewById(R.id.rl_cart_detail);
        cartCheckout = view.findViewById(R.id.ll_cart_checkout);
        llEmpty = view.findViewById(R.id.ll_empty);
        tvTitle = view.findViewById(R.id.tv_title);
        tvDesc = view.findViewById(R.id.tv_desc);
        tvPrice = view.findViewById(R.id.tv_harga);
        tvPriceTotal = view.findViewById(R.id.tv_price_total);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        cartPreferences = new CartPreferences(getContext());

//        if (cartPreferences.getSPId().isEmpty()) {
//            llEmpty.setVisibility(View.VISIBLE);
//            rlCartDetail.setVisibility(View.GONE);
//            cartCheckout.setVisibility(View.GONE);
//        } else {
//            Glide.with(getContext()).load(cartPreferences.getSPPoster()).into(ivProduk);
//            tvTitle.setText(cartPreferences.getSPTitle());
//            tvDesc.setText(cartPreferences.getSPDesc());
//            tvPrice.setText(new Ektension().convertPrice(cartPreferences.getSPPrice()));
//            tvPriceTotal.setText(new Ektension().convertPrice(cartPreferences.getSPPrice()));
//        }

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_cartFragment_to_shippingFragment);
            }
        });
    }
}
