package tech.tedycoding.sepatuku.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import tech.tedycoding.sepatuku.R
import tech.tedycoding.sepatuku.model.HomeModel

class HomeSportAdapter(private var rvData: List<HomeModel>,
                       private val listener:(HomeModel) -> Unit)
    : RecyclerView.Adapter<HomeSportAdapter.ViewHolder>() {

    lateinit var contextAdapter : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context
        val inflatedView = layoutInflater.inflate(R.layout.item_discount, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(rvData[position], listener, contextAdapter, position)
    }

    override fun getItemCount(): Int {
        return rvData.size
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private val tvDiskon : TextView = v.findViewById(R.id.discount)
        private val ivPoster : ImageView = v.findViewById(R.id.iv_poster)

        fun bindItem(data: HomeModel, listener: (HomeModel) -> Unit, context : Context, position : Int) {
            tvDiskon.text = data.diskonproduct

            Glide.with(context)
                .load(data.imageproduct)
                .into(ivPoster)

            itemView.setOnClickListener {
                listener(data)
            }
        }
    }

}