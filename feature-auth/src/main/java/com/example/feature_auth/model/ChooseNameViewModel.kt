package com.example.feature_auth.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.core_android.viewModel.BaseViewModel
import com.example.core_network.api.workers.dtos.WorkerDto
import com.example.feature_auth.entities.Client
import com.example.feature_auth.entities.Foremen
import javax.inject.Inject

class ChooseNameViewModel @Inject constructor(private val repository: ChooseNameRepository) :
    BaseViewModel() {

    private val _clients = MutableLiveData<List<Client>>()
    val clients: LiveData<List<Client>> = _clients

    private val _workers = MutableLiveData<List<WorkerDto>>()
    val workers: LiveData<List<WorkerDto>> = _workers

    private val _foremens = MutableLiveData<List<Foremen>>()
    val foremens: LiveData<List<Foremen>> = _foremens

    fun getClients() = composite.add(
        repository.getAllClients()
            .subscribe({ clients ->
                _clients.postValue(clients)
            }, {
                _error.postValue(it.message)
            })
    )

    fun getWorkers() = composite.add(
        repository.getALlWorkers()
            .subscribe({ workers ->
                _workers.postValue(workers)
            }, {
                _error.postValue(it.message)
            })
    )

    fun getForemens() = composite.add(
        repository.getAllForemens()
            .subscribe({ foremens ->
                _foremens.postValue(foremens)
            }, {
                _error.postValue(it.message)
            })
    )
}