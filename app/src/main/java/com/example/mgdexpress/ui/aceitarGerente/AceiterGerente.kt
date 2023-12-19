package com.example.mgdexpress.ui.aceitarGerente

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mgdexpress.MainActivity
import com.example.mgdexpress.R
import com.example.mgdexpress.databinding.FragmentAceiterGerenteBinding
import com.example.mgdexpress.request.ReqSolicitacoes

class AceiterGerente(context: Context) : Fragment() {

    private lateinit var binding: FragmentAceiterGerenteBinding

     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAceiterGerenteBinding.inflate(inflater,container,false)



         val recyclerView = binding.recicleyViewAceitarGerente
         val adapter = Adapter(requireContext(),ReqSolicitacoes().reqSolicitarGerentes(MainActivity().buscarTokenUsuario()))
         recyclerView.adapter =  adapter

         return binding.root
    }


}