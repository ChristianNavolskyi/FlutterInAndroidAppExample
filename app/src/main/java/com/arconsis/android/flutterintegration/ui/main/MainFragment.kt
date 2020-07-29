package com.arconsis.android.flutterintegration.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.arconsis.android.flutterintegration.R
import com.arconsis.android.flutterintegration.databinding.MainFragmentBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect

@ExperimentalCoroutinesApi
class MainFragment : Fragment() {

	companion object {
		fun newInstance() = MainFragment()
	}

	private lateinit var viewModel: MainViewModel

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		val binding = DataBindingUtil.inflate<MainFragmentBinding>(inflater, R.layout.main_fragment, container, false)
		viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

		binding.lifecycleOwner = this
		binding.vm = viewModel

		lifecycleScope.launchWhenStarted {
			viewModel.actions.collect {
				when (it) {
					Action.CLICKED -> Log.d("XXX", "CLICKED")
					Action.INITIAL -> Log.d("XXX", "INITIAL")
				}
			}
		}

		return binding.root
	}

}