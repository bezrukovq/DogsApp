package com.example.dogsapp.view.fragments.dogsDetail

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.transition.TransitionInflater
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
        this.activity?.let { ActivityCompat.postponeEnterTransition(it) }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setSharedElementEnterTransition(TransitionInflater.from(getContext())
                .inflateTransition(android.R.transition.move));
        }
        /*
        val transition = TransitionInflater.from(context)
            .inflateTransition(R.transition.shared_element_transition)
        sharedElementEnterTransition = transition*/
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(DogsDetailViewModel::class.java)
        viewModel.showProgress.observe(this, Observer { aBoolean ->
            if (aBoolean) {
                showProgress()
            } else {
                hideProgress()
            }
        }
        )
        val dogBreed = arguments?.getString("dog").toString()
        viewModel.getDogPic(dogBreed)
        viewModel.getDogBreed(dogBreed)
        viewModel.dogData.observe(this, Observer { dog -> setImg(dog.message) })
        viewModel.dogBreed.observe(this, Observer { breed -> setText(breed) })

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.activity?.let { ActivityCompat.startPostponedEnterTransition(it) }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tv_breed_det.setTransitionName(arguments?.getString("trId"))
        }
    }

    private fun setImg(img: String) {
        Picasso.get().load(img).into(iv_dog_img)
    }

    private fun setText(text: String) {
        tv_breed_det.text = text
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.dogs_detail_fragment, container, false)

    fun showProgress() {
        pb.visibility = View.VISIBLE
    }

    fun hideProgress() {
        pb.visibility = View.GONE
    }

    companion object {
        fun newInstance(dog: String, transitionId : String): DogsDetailFragment {
            val args = Bundle()
            args.putString("dog", dog)
            args.putString("trId", transitionId)
            val fragment = DogsDetailFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
