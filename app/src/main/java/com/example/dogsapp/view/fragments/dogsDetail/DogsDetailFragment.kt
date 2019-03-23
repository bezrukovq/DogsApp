package com.example.dogsapp.view.fragments.dogsDetail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.dogsapp.R
import com.example.dogsapp.vm.DogsDetailViewModel

class DogsDetailFragment() : Fragment() {

    private lateinit var viewModel: DogsDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.dogs_detail_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DogsDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

    companion object {
        fun newInstance(dog : String): DogsDetailFragment {
            val args = Bundle()
            args.putString("dog",dog)
            val fragment = DogsDetailFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
