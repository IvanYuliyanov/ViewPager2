package com.example.viewpager2presentation

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.viewpager2presentation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.inflate(
			LayoutInflater.from(this), R.layout.activity_main, null, false
		)
		setContentView(binding.root)
		setViewPagerAdapter()
	}

	private fun setViewPagerAdapter() {
		val actorsArray = Constants.getActors()
		binding.viewPager.let {
			val adapter = ViewPagerAdapter()
			it.adapter = adapter
			adapter.setItems(actorsArray)
		}
	}
}