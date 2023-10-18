package com.example.core_android.ui.delegateAdapter

import java.io.Serializable

data class AdaptersState(
    private val adapters: List<DelegateAdapter>,
    val data: List<Any> = emptyList()
) {
    private val adapterPositionsCache = Array(data.size) { -1 }

    fun getAdapterPosition(itemPosition: Int): Int =
        adapterPositionsCache[itemPosition].takeIf {
            it != -1
        } ?: adapters.indexOfFirst {
            it.isForViewType(data, itemPosition)
        }.takeIf {
            it != -1
        }?.also {
            adapterPositionsCache[itemPosition] = it
        } ?: error(
            "Provide adapter for type ${data[itemPosition].javaClass} at position: $itemPosition"
        )

    fun getAdapter(adapterPosition: Int): DelegateAdapter = adapters[adapterPosition]

    fun getAdapterByItemPosition(itemPosition: Int): DelegateAdapter =
        adapters[getAdapterPosition(itemPosition)]
}