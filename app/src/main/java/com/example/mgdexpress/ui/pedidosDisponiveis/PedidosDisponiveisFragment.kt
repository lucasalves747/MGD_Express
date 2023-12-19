package com.example.mgdexpress.ui.pedidosDisponiveis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mgdexpress.databinding.FragmentPedidosDisponiveisBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class PedidosDisponiveisFragment : Fragment() {

    private lateinit var binding: FragmentPedidosDisponiveisBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPedidosDisponiveisBinding.inflate(inflater,container,false)
        return binding.root
    }
}