package com.example.viewpager2demo

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.viewpager2demo.databinding.ActivityMainBinding

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
		val adapter = ViewPagerAdapter()
		binding.viewPager.let { viewPager ->
			viewPager.adapter = adapter
			adapter.setItems(actorsArray)
		}
	}
}