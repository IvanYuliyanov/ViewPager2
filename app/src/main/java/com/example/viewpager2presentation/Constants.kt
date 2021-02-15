package com.example.viewpager2presentation

object Constants {

	fun getActors(): ArrayList<Actor> {
		val actorsArray = arrayListOf<Actor>()

		actorsArray.add(Actor("Brat Pitt", R.drawable.brad_pitt))
		actorsArray.add(Actor("Ryan Gosling", R.drawable.ryan_gosling))
		actorsArray.add(Actor("Tom Cruise", R.drawable.tom_cruise))
		actorsArray.add(Actor("Tom Hanks", R.drawable.tom_hanks))
		actorsArray.add(Actor("Will Smith", R.drawable.will_smith))

		return actorsArray
	}
}