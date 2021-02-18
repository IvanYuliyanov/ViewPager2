package com.example.viewpager2demo

import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil

class PageDiffUtil(private val oldActorsList: List<Actor>, private val newActorsList: List<Actor>) : DiffUtil.Callback() {

	override fun getOldListSize(): Int {
		return oldActorsList.size
	}

	override fun getNewListSize(): Int {
		return newActorsList.size
	}

	override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
		return oldActorsList[oldItemPosition].imageId == newActorsList[newItemPosition].imageId
	}

	override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
		return oldActorsList[oldItemPosition].name == newActorsList[newItemPosition].name
	}

	override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
		return Bundle()
	}
}