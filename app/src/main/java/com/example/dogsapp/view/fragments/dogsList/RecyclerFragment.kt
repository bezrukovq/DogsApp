package com.example.dogsapp.view.fragments.dogsList

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogsapp.R
import com.example.dogsapp.di.component.DaggerDateComponent
import com.example.dogsapp.di.module.DateModule
import com.example.dogsapp.helpers.FragmentHelper
import com.example.dogsapp.model.DogsModel
import com.example.dogsapp.view.MainActivity
import com.example.dogsapp.view.fragments.dogsDetail.DogsDetailFragment
import kotlinx.android.synthetic.main.fragment_recycler.*

@SuppressLint("Registered")
class RecyclerFragment : Fragment() {

    var recyclerAdapter = RecyclerAdapter { onItemClick(it) }


    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerDateComponent
            .builder()
            .appComponent(MainActivity.appComponent)
            .dateModule(DateModule())
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_recycler, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val manager = LinearLayoutManager(context)
        recycler_view.adapter = recyclerAdapter
        recycler_view.layoutManager = manager
        recyclerAdapter.addAll(DogsModel.getBreedList())
    }

    private fun onItemClick(dog: String) =
        FragmentHelper.openFragment(this.activity,R.id.container,DogsDetailFragment.newInstance(dog))

    companion object {
        fun newInstance(): RecyclerFragment {
            val args = Bundle()
            val fragment = RecyclerFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
