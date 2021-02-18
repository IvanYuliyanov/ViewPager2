package com.example.viewpager2demo

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder

class ViewPagerFragmentStateAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
	var actorsList = arrayListOf<Actor>()

	override fun getItemCount(): Int {
		return actorsList.size
	}

	override fun createFragment(position: Int): Fragment {
		val actor = actorsList[position]

		return ActorFragment.newInstance(actor.name, actor.imageId)
	}

	override fun getItemId(position: Int): Long {
		return actorsList[position].imageId.toLong()
	}

	override fun onBindViewHolder(holder: FragmentViewHolder, position: Int, payloads: MutableList<Any>) {
		super.onBindViewHolder(holder, position, payloads)
		if(payloads.isNotEmpty()) {
			holder.itemView.findViewById<TextView>(R.id.actor_name_text_view).text = actorsList[position].name
		}
	}

	fun setItems(newActorsList: ArrayList<Actor>) {
		val pageDiffUtil = PageDiffUtil(actorsList, newActorsList)
		val result = DiffUtil.calculateDiff(pageDiffUtil)
		actorsList = newActorsList
		result.dispatchUpdatesTo(this)
	}
}