package tech.tedycoding.sepatuku.ui.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import tech.tedycoding.sepatuku.R
import tech.tedycoding.sepatuku.model.ColorsModel

class ColorsAdapter(private var rvData: List<ColorsModel>,
                    private val listener:(ColorsModel) -> Unit) :
    RecyclerView.Adapter<ColorsAdapter.ViewHolder>() {

    lateinit var contextAdapter : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context
        val inflatedView = layoutInflater.inflate(R.layout.item_colors, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(rvData[position], listener, contextAdapter, position)
    }

    override fun getItemCount(): Int {
        return rvData.size
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private val ivColor : ImageView = v.findViewById(R.id.iv_colors)

        fun bindItem(data: ColorsModel, listener: (ColorsModel) -> Unit, context : Context, position : Int) {

            Glide.with(context)
                .load(data.color)
                .into(ivColor)

            itemView.setOnClickListener {
                listener(data)
            }
        }
    }

}