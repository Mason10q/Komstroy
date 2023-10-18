package com.example.komstroy.houses

import com.example.core_network.api.houses.HouseApi
import com.example.komstroy.mappers.HousesMapper
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

import javax.inject.Inject

class HousesRepository @Inject constructor(
    private val api: HouseApi,
    private val housesMapper: HousesMapper
) {

    fun getHouses() = api.getHouses()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map(housesMapper::map)


}