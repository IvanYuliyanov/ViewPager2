package com.example.viewpager2presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2presentation.databinding.ViewPagerItemBinding

class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

	private val actorsList = ArrayList<Actor>()

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder.from(parent)

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val actor = actorsList[position]
		holder.bind(actor)
	}

	override fun getItemCount(): Int = actorsList.size

	override fun getItemId(position: Int): Long = actorsList[position].imageId.toLong()

	fun setItems(newActorsList: ArrayList<Actor>) {
		actorsList.clear()
		actorsList.addAll(newActorsList)
		notifyDataSetChanged()
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