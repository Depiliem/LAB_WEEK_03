package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import android.widget.Button

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
const val COFFEE_ID = "COFFEE_ID"   // const di file ini seperti yang diminta

class DetailFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private val coffeeTitle: TextView?
        get() = view?.findViewById(R.id.coffee_title)
    private val coffeeDesc: TextView?
        get() = view?.findViewById(R.id.coffee_desc)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ambil argumen dan tampilkan data
        val coffeeId = arguments?.getInt(COFFEE_ID, 0) ?: 0
        setCoffeeData(coffeeId)

        // Back button (safe) — pakai popBackStack() untuk kembali ke ListFragment
        val backButton = view.findViewById<Button?>(R.id.back_button)
        backButton?.setOnClickListener {
            // Jika kamu pernah melakukan addToBackStack saat replace ke DetailFragment,
            // popBackStack() akan kembali ke ListFragment.
            parentFragmentManager.popBackStack()
        }
    }

    // PERBAIKAN: gunakan parameter 'id' (bukan coffeeId yang bukan variabel di scope)
    fun setCoffeeData(id: Int) {
        when (id) {
            R.id.affogato -> {
                coffeeTitle?.text = getString(R.string.affogato_title)
                coffeeDesc?.text = getString(R.string.affogato_desc)
            }
            R.id.americano -> {
                coffeeTitle?.text = getString(R.string.americano_title)
                coffeeDesc?.text = getString(R.string.americano_desc)
            }
            R.id.latte -> {
                coffeeTitle?.text = getString(R.string.latte_title)
                coffeeDesc?.text = getString(R.string.latte_desc)
            }
            R.id.espresso -> {
                coffeeTitle?.text = getString(R.string.espresso_title)
                coffeeDesc?.text = getString(R.string.espresso_desc)
            }
            R.id.cappuccino -> {
                coffeeTitle?.text = getString(R.string.cappuccino_title)
                coffeeDesc?.text = getString(R.string.cappuccino_desc)
            }
        }
    }


    companion object {
        fun newInstance(coffeeId: Int) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(COFFEE_ID, coffeeId)
                }
            }
    }
}
