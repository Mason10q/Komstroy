package com.example.feature_construction.model

import com.example.core_network.api.construction.ConstructionApi
import com.example.feature_construction.mappers.ConstrMapper
import com.example.feature_construction.mappers.StateMapper
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ConstrRepository @Inject constructor(
    private val api: ConstructionApi,
    private val constrMapper: ConstrMapper,
    private val stateMapper: StateMapper,
) {

    fun getConstruction(constructionId: Int) = api.getConstruction(constructionId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map(constrMapper::map)

    fun getConstrStates() = api.getStates()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map(stateMapper::map)

}