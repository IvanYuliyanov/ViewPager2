package com.example.viewpager2demo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewpager2demo.databinding.ViewPagerItemBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ActorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ActorFragment : Fragment() {

	// TODO: Rename and change types of parameters
	private var name: String? = null
	private var imageId: Int? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		arguments?.let {
			name = it.getString(ARG_PARAM1)
			imageId = it.getInt(ARG_PARAM2)
		}
	}

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		val binding = ViewPagerItemBinding.inflate(inflater, null, false)
		binding.actorNameTextView.text = name
		imageId?.let { binding.actorImageView.setImageResource(it) }
		// Inflate the layout for this fragment
		return binding.root
	}

	companion object {

		/**
		 * Use this factory method to create a new instance of
		 * this fragment using the provided parameters.
		 *
		 * @param param1 Parameter 1.
		 * @param param2 Parameter 2.
		 * @return A new instance of fragment ActorFragment.
		 */
		// TODO: Rename and change types and number of parameters
		@JvmStatic
		fun newInstance(name: String, imageId: Int) =
			ActorFragment().apply {
				arguments = Bundle().apply {
					putString(ARG_PARAM1, name)
					putInt(ARG_PARAM2, imageId)
				}
			}
	}
}