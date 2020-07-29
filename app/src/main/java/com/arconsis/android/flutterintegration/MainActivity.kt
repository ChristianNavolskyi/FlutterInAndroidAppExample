package com.arconsis.android.flutterintegration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arconsis.android.flutterintegration.ui.main.MainFragment
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.main_activity)
		if (savedInstanceState == null) {
			supportFragmentManager.beginTransaction()
					.replace(R.id.container, MainFragment.newInstance())
					.commitNow()
		}
	}
}