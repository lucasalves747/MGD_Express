package com.example.mgdexpress.ui.map

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mgdexpress.databinding.FragmentMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.Runnable
import java.lang.Exception


class MapaFragment : Fragment(),Runnable {

    private var marcador: Marker? = null
    private lateinit var binding: FragmentMapBinding

    private lateinit var googleMap: GoogleMap
    private lateinit var  mapView: MapView
    private lateinit var options:MarkerOptions
    var longitude = -20.0544674
    var latitude = -44.2788579
    var latLng = LatLng(longitude,latitude )
    var handler = Handler()
    var executar = true



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMapBinding.inflate(inflater,container,false)

        mapView = binding.mapaView
        mapView.onCreate(savedInstanceState)
        mapView.onResume()

        activity?.let { MapsInitializer.initialize(it.applicationContext) }

        mapView.getMapAsync {
            googleMap = it

            options = MarkerOptions()
                .position(latLng)
                .title("lucas")

            marcador = googleMap.addMarker(options)
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13.0F))
        }
        return binding.root
    }

    override fun run() {
        Toast.makeText(activity?.applicationContext,"run",Toast.LENGTH_SHORT).show()
        latitude+=0.01
        longitude+=0.01
        latLng = LatLng(longitude,latitude)
        options.position(latLng)
        marcador?.remove()
        marcador = googleMap.addMarker(options)
        if(executar){handler.postDelayed(this,5000)}
    }


    override fun onResume() {
        executar = true
        mapView.getMapAsync {
            run()
        }
        super.onResume()
    }

    override fun onStop() {
        executar = false
        super.onStop()
    }





}

