package com.example.dogs.view

import android.view.View
import androidx.navigation.Navigation

interface DogClickListener {

    fun onDogClick(view: View){

    }

    fun onActionButtonClick(view: View){
        val action = ListFragmentDirections.actionSettingsFragment()
        Navigation.findNavController(view).navigate(action)
    }

}