package tech.tedycoding.sepatuku.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import tech.tedycoding.sepatuku.R
import tech.tedycoding.sepatuku.model.HomeModel

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val arrayList = ArrayList<HomeModel>()
        arrayList.add(HomeModel(1,"Tedy","New","10%","url"))
        arrayList.add(HomeModel(2,"Tedy","New","10%","url"))
        arrayList.add(HomeModel(3,"Tedy","New","10%","url"))
        arrayList.add(HomeModel(4,"Tedy","New","10%","url"))
        arrayList.add(HomeModel(5,"Tedy","New","10%","url"))

        rv_sport.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_sport.adapter = HomeSportAdapter(arrayList) {
            view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_homeFragment_to_detailFragment) }
        }
    }

}