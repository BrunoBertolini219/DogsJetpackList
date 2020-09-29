package com.example.dogs.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.dogs.R
import com.example.dogs.databinding.ItemDogBinding
import com.example.dogs.model.DogBreed
import com.example.dogs.util.getProgressDrawable
import com.example.dogs.util.loadImage
import kotlinx.android.synthetic.main.fragment_list.view.*
import kotlinx.android.synthetic.main.item_dog.view.*

class DogsListAdapter(val dogsList: ArrayList<DogBreed>): RecyclerView.Adapter<DogsListAdapter.DogViewHolder>(),
DogClickListener{

    fun updateDogList(newDogsList: List<DogBreed>){
        dogsList.clear()
        dogsList.addAll(newDogsList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater: LayoutInflater =  LayoutInflater.from(parent.context)
       // val view = inflater.inflate(R.layout.item_dog, parent, false)
        val view = DataBindingUtil.inflate<ItemDogBinding>(inflater, R.layout.item_dog, parent, false)
        return DogViewHolder(view)
    }

    override fun getItemCount() = dogsList.size

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.view.dog = dogsList[position]
        holder.view.listener = this
        /*
        holder.view.lifespan.text = dogsList[position].lifeSpan
        holder.view.setOnClickListener {

        }
        holder.view.imageView.loadImage(dogsList[position].imgUrl, getProgressDrawable(holder.view.imageView.context))
   */
    }
    override fun onDogClick(view: View){
        val uuid: Int = view.dogId.text.toString().toInt()
        val action = ListFragmentDirections.ationDetailFragment()
        action.dogUuid = uuid
        Navigation.findNavController(view).navigate(action)
    }

    class DogViewHolder(var view: ItemDogBinding): RecyclerView.ViewHolder(view.root){

    }

}
