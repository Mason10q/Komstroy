package com.example.feature_construction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.core_android.viewModel.BaseViewModel
import com.example.feature_construction.entities.Construction
import com.example.feature_construction.ui.RoadMap
import javax.inject.Inject

class ConstrViewModel @Inject constructor(
    private val repository: ConstrRepository,
    val roadMap: RoadMap
) : BaseViewModel() {

    private val _construction = MutableLiveData<Construction>()
    val construction: LiveData<Construction> = _construction

    fun getConstruction(constructionId: Int) = composite.add(
        repository.getConstruction(constructionId)
            .subscribe({ construction ->
                _construction.postValue(construction)
            }, {
                _error.postValue(it.message)
            })
    )

    fun getConstrStates() = composite.add(
        repository.getConstrStates()
            .subscribe({ constrStates ->
                roadMap.states = constrStates
            }, {
                _error.postValue(it.message)
            })
    )

}