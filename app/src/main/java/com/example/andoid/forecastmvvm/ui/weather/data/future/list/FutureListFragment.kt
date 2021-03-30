package com.example.andoid.forecastmvvm.ui.weather.data.future.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.andoid.forecastmvvm.R

class FutureListFragment : Fragment() {

    companion object {
        fun newInstance() = FutureListFragment()
    }

    private lateinit var viewModel: FutureListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.future_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       /* viewModel = ViewModelProvider(this).get(FutureListViewModel::class.java)*/
        // TODO: Use the ViewModel
    }

}