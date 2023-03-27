package com.shuklansh.practicejc.NetworkConnectivity

import kotlinx.coroutines.flow.Flow
import java.util.Observer

interface ConnectivityObserver {

    fun observe(): Flow<Status>

    enum class Status{
        Available,Unavailable,Losing,Lost
    }

}