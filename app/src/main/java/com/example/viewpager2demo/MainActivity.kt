package com.example.viewpager2demo

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpager2demo.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

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
		//val adapter = ViewPagerAdapter()
		val adapter = ViewPagerFragmentStateAdapter(this)
		binding.viewPager.let { viewPager ->
			viewPager.adapter = adapter
			adapter.setItems(actorsArray)
			//viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
			//viewPager.layoutDirection = ViewPager2.LAYOUT_DIRECTION_RTL
			TabLayoutMediator(binding.tabLayout, viewPager) { tab, position ->
				tab.text = position.toString()
			}.attach()

			viewPager.setPageTransformer { page, position ->
				val scaleFactor = 1 - Math.abs(position)
				page.scaleX = scaleFactor
				page.scaleY = scaleFactor
			}

			Handler(Looper.getMainLooper()).postDelayed({
				val actors = Constants.getActors()
				//actors[0].name = "Ivan Ivonov"
				actors.removeAt(0)
				adapter.setItems(actors)
			}, 2000)
		}
	}
}