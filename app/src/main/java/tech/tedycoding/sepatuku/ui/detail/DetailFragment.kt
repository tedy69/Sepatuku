package tech.tedycoding.sepatuku.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_detail.*
import tech.tedycoding.sepatuku.R
import tech.tedycoding.sepatuku.model.ColorsModel
import tech.tedycoding.sepatuku.ui.home.HomeSportAdapter

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val arrayList = ArrayList<ColorsModel>()
        arrayList.add(ColorsModel(1,R.color.colorAccent))
        arrayList.add(ColorsModel(2,R.color.colorPink))
        arrayList.add(ColorsModel(3,R.color.colorPrimary))
        arrayList.add(ColorsModel(4,R.color.colorPrimaryDark))
        arrayList.add(ColorsModel(5,R.color.colorGrey))

        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = ColorsAdapter(arrayList) {
            Toast.makeText(context, "Clicked", Toast.LENGTH_LONG).show()
        }
    }

}