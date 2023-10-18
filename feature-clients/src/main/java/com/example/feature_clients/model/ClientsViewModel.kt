package com.example.feature_clients.model

import com.example.core_android.viewModel.BaseListViewModel
import com.example.feature_clients.entities.Client
import javax.inject.Inject

class ClientsViewModel @Inject constructor(
    private val repository: ClientsRepository
): BaseListViewModel<Client>() {


    fun getHouseClients(houseId: Int) = composite.add(
        repository.getHouseClients(houseId)
            .subscribe({ clients ->
                _data.postValue(clients)
            }, {
                _error.postValue(it.message)
            })
    )

    fun getForemenClients(foremenId: Int) = composite.add(
        repository.getForemenClients(foremenId)
            .subscribe({ clients ->
                _data.postValue(clients)
            }, {
                _error.postValue(it.message)
            })
    )


    fun getAllClients() = composite.add(
        repository.getAllClients()
            .subscribe({ clients ->
                _data.postValue(clients)
            }, {
                _error.postValue(it.message)
            })
    )


}