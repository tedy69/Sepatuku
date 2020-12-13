package tech.tedycoding.sepatuku.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import tech.tedycoding.sepatuku.R;
import tech.tedycoding.sepatuku.model.HomeModel;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private List<HomeModel> rvData;
    private ItemAdapterCallback itemAdapterCallback;
    private Context context;

    public HomeAdapter(List<HomeModel> listData, ItemAdapterCallback mItemAdapterCallback){
        rvData = listData;
        itemAdapterCallback = mItemAdapterCallback;
    }
    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_diskon, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {
//        holder.tvDiskon.setText(rvData.get(position).getDiskonproduct());
//        Glide.with(context).load(rvData.get(position).getImageproduct()).into(holder.ivPoster);
//        holder.ivPoster.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                itemAdapterCallback.onClick(view);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivPoster;
        public TextView tvDiskon;

        public ViewHolder(View v) {
            super(v);
            tvDiskon = v.findViewById(R.id.diskon);
            ivPoster = v.findViewById(R.id.poster);
        }
    }

    public interface ItemAdapterCallback {
        void onClick(View view);
    }
}
