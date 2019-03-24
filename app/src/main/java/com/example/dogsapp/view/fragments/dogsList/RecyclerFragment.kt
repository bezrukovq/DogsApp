package com.example.dogsapp.view.fragments.dogsList

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogsapp.R
import com.example.dogsapp.di.di
import com.example.dogsapp.view.fragments.dogsDetail.DogsDetailFragment
import com.example.dogsapp.vm.BaseViewModelFactory
import com.example.dogsapp.vm.DogsListViewModel
import kotlinx.android.synthetic.main.fragment_recycler.*
import kotlinx.android.synthetic.main.number_item.*
import org.kodein.di.generic.instance


class RecyclerFragment : Fragment() {

    private val viewModelFactory: BaseViewModelFactory by di.instance()
    private var recyclerAdapter = RecyclerAdapter { onItemClick(it) }
    private lateinit var viewModel: DogsListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(DogsListViewModel::class.java)
        observeDogsList()
        viewModel.getBreedList()
    }

    private fun observeDogsList() =
        viewModel.breedList.observe(this, Observer { dogList ->
            updateList(dogList)
        })

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(com.example.dogsapp.R.layout.fragment_recycler, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val manager = LinearLayoutManager(context)
        recycler_view.adapter = recyclerAdapter
        recycler_view.layoutManager = manager
    }

    private fun updateList(dogList: ArrayList<String>) {
        recyclerAdapter.list = dogList
    }

    private fun onItemClick(dog: String) {
        activity?.let {
            ViewCompat.getTransitionName(tv_breed)?.let { it1 ->
                it.supportFragmentManager
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .addSharedElement(tv_breed, it1)
                    .addToBackStack("JoJo")
                    .replace(
                        R.id.container,
                        DogsDetailFragment.newInstance(dog)
                    )
                    .commit()
            }
        }
    }

    companion object {
        fun newInstance(): RecyclerFragment {
            val args = Bundle()
            val fragment = RecyclerFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
