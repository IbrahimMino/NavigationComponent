package com.example.navigationcomponent.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.navigationcomponent.R


class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_first, container, false)
        val btn = view.findViewById<Button>(R.id.btn_first)
        val edt = view.findViewById<EditText>(R.id.edt_first)
        btn.setOnClickListener {
               if (edt.text.isNotEmpty()){
                   val message = edt.text.toString()
                      val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(message)
                      edt.text.clear()
                   Navigation.findNavController(view).navigate(action)
               }else{
                   Toast.makeText(requireContext(), "Please fill up all the field", Toast.LENGTH_SHORT).show()
               }
             }


        return view
    }

}