package tech.tedycoding.sepatuku.ui.detail;

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
import tech.tedycoding.sepatuku.model.ColorsModel;
import tech.tedycoding.sepatuku.model.HomeModel;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder> {

    private List<ColorsModel> rvData;
    private ItemAdapterCallback itemAdapterCallback;
    private Context context;

    public ColorAdapter(List<ColorsModel> listData, ItemAdapterCallback mItemAdapterCallback){
        rvData = listData;
        itemAdapterCallback = mItemAdapterCallback;
    }
    @NonNull
    @Override
    public ColorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_diskon, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ColorAdapter.ViewHolder holder, int position) {
//        holder.ivColor.setImageResource(rvData.get(position).getColors());
//        holder.ivColor.setOnClickListener(new View.OnClickListener() {
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
        public ImageView ivColor;

        public ViewHolder(View v) {
            super(v);
            ivColor = v.findViewById(R.id.iv_colors);
        }
    }

    public interface ItemAdapterCallback {
        void onClick(View view);
    }
}
