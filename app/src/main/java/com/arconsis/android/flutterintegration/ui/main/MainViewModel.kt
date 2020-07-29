package com.arconsis.android.flutterintegration.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

enum class Action {
	INITIAL,
	CLICKED,
}

@ExperimentalCoroutinesApi
class MainViewModel : ViewModel() {
	private val actionChannel = Channel<Action>(Channel.CONFLATED)

	val actions = actionChannel.receiveAsFlow()

	fun buttonClicked() {
		Log.d("XXX", "view model received click")
		actionChannel.offer(Action.CLICKED)
	}
}