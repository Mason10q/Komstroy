package com.example.core_network.api

import com.example.core_network.api.clients.ClientsApi
import com.example.core_network.api.foremens.ForemensApi
import com.example.core_network.api.workers.WorkersApi

interface AuthApi: ClientsApi, WorkersApi, ForemensApi {}