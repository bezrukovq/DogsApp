package com.example.dogsapp.view.fragments.dogsDetail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.dogsapp.R
import com.example.dogsapp.di.di
import com.example.dogsapp.vm.BaseViewModelFactory

import com.example.dogsapp.vm.DogsDetailViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.dogs_detail_fragment.*
import org.kodein.di.generic.instance


class DogsDetailFragment : Fragment() {

    private lateinit var viewModel: DogsDetailViewModel
    private val viewModelFactory: BaseViewModelFactory by di.instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(DogsDetailViewModel::class.java)
        viewModel.showProgress.observe(this, Observer { aBoolean ->
            if (aBoolean) {
                showProgress()
            } else {
                hideProgress()
            }
        }
        )
        viewModel.dogData.observe(this, Observer { dog -> setImg(dog.message) })
        viewModel.getDogPic(arguments?.getString("dog").toString())

    }

    private fun setImg(img: String) {
        Picasso.get().load(img).into(iv_dog_img)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.dogs_detail_fragment, container, false)

    fun showProgress() {
        pb.visibility = View.VISIBLE
    }

    fun hideProgress(){
        pb.visibility = View.GONE
    }

    companion object {
        fun newInstance(dog: String): DogsDetailFragment {
            val args = Bundle()
            args.putString("dog", dog)
            val fragment = DogsDetailFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
