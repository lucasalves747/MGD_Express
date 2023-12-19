package com.example.mgdexpress.ui.pedidosEmAndamento

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mgdexpress.databinding.FragmentMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class PedidosEmAndamento : Fragment(){

    private lateinit var binding: FragmentMapBinding
    private lateinit var googleMap: GoogleMap
    private lateinit var mapView: MapView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMapBinding.inflate(inflater,container,false)

        mapView = binding.mapaView
        mapView.onCreate(savedInstanceState)
        mapView.onResume()
        activity?.let { MapsInitializer.initialize(it.applicationContext) }

        mapView.getMapAsync {
            googleMap = it
            val latLng = LatLng(-20.0544674,-44.2788579)
            val options = MarkerOptions()
                .position(latLng)
                .title("lucas")

            googleMap.addMarker(options)
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,13.0F))
        }


        return binding.root

    }




}