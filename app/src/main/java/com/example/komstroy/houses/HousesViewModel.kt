package com.example.komstroy.houses

import com.example.core_android.viewModel.BaseListViewModel
import com.example.komstroy.entities.House
import javax.inject.Inject

class HousesViewModel @Inject constructor(private val repository: HousesRepository): com.example.core_android.viewModel.BaseListViewModel<House>() {


    fun getHouses() = composite.add(repository.getHouses()
        .subscribe({ houses ->
            _data.postValue(houses)
        }, {
            _error.postValue(it.message)
        }))

}