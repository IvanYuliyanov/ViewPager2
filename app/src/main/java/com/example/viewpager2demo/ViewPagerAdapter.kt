package com.example.viewpager2demo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2demo.databinding.ViewPagerItemBinding

class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

	private var actorsList = arrayListOf<Actor>()

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder.from(parent)

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val actor = actorsList[position]
		holder.bind(actor)
	}

	override fun getItemCount(): Int = actorsList.size

	override fun getItemId(position: Int): Long = actorsList[position].imageId.toLong()

	fun setItems(newActorsList: ArrayList<Actor>) {
		val pageDiffUtil = PageDiffUtil(actorsList, newActorsList)
		val result = DiffUtil.calculateDiff(pageDiffUtil)
		actorsList = newActorsList
		result.dispatchUpdatesTo(this)
	}

	class ViewHolder(private val binding: ViewPagerItemBinding) : RecyclerView.ViewHolder(binding.root) {

		fun bind(actor: Actor) {
			binding.actorNameTextView.text = actor.name
			binding.actorImageView.setImageResource(actor.imageId)
		}

		companion object {

			fun from(parent: ViewGroup): ViewHolder {
				val binding = ViewPagerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

				return ViewHolder(binding)
			}
		}
	}
}