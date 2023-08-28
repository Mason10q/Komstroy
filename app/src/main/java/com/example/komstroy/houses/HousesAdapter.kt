package com.example.komstroy.houses

import com.example.core_android.ui.BaseAdapter
import com.example.komstroy.databinding.ItemHouseBinding
import com.example.komstroy.entities.House
import com.squareup.picasso.Picasso
import javax.inject.Inject

class HousesAdapter @Inject constructor(private val picasso: Picasso) :
    BaseAdapter<House, ItemHouseBinding>(ItemHouseBinding::inflate) {

    override fun bindViews(binding: ItemHouseBinding, item: House, position: Int) {
        binding.name.text = item.name
        //picasso.load(item.photoUrl).into(binding.image)
    }

}