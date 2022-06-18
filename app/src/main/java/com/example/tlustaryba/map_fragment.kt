package com.example.tlustaryba

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tlustaryba.databinding.FragmentMapFragmentBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback

class map_fragment : Fragment(), OnMapReadyCallback {

    private lateinit var googleMap: GoogleMap

    lateinit var binding: FragmentMapFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.mapView.onCreate(savedInstanceState)
        binding.mapView.onResume()
        binding.mapView.getMapAsync(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map_fragment, container, false)
    }

    override fun onMapReady(map: GoogleMap) {
        map?.let {
            googleMap = it
        }
    }
}