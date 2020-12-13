package tech.tedycoding.sepatuku.ui.categories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tech.tedycoding.sepatuku.R;
import tech.tedycoding.sepatuku.model.CategoriModel;

public class CategoriAdapter extends RecyclerView.Adapter<CategoriAdapter.ViewHolder> {

    private List<CategoriModel> rvData;
    private ItemAdapterCallback itemAdapterCallback;

    public CategoriAdapter(List<CategoriModel> listData, ItemAdapterCallback mItemAdapterCallback){
        rvData = listData;
        itemAdapterCallback = mItemAdapterCallback;
    }

    @NonNull
    @Override
    public CategoriAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categories, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriAdapter.ViewHolder holder, int position) {
        holder.tvLabel.setText(rvData.get(position).getLabels());
    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvLabel;

        public ViewHolder(View v){
            super(v);
            tvLabel = v.findViewById(R.id.tv_label);
        }
    }

    public interface ItemAdapterCallback{
        void onClick(View view);
    }
}
