package com.example.core_android.ui.delegateAdapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListUpdateCallback
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

open class CompositeDelegateAdapter(
    vararg adapters: DelegateAdapter
) : RecyclerView.Adapter<ViewHolder>(){

    //  Contract is: adapters position is used as ViewType.
    protected open var adapterState = AdaptersState(adapters.toList())
    private var updateCallback: ListUpdateCallback? = null

    fun getData() = adapterState.data
    fun setListUpdateCallback(callback: ListUpdateCallback) {
        updateCallback = callback
    }

    override fun getItemViewType(itemPosition: Int): Int = adapterState.getAdapterPosition(itemPosition)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        adapterState.getAdapter(viewType).onCreateViewHolder(parent, viewType)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        adapterState.getAdapter(getItemViewType(position))
            .onBindViewHolder(holder, adapterState.data, position)

    override fun onViewRecycled(holder: ViewHolder) =
        adapterState.getAdapter(holder.itemViewType).onRecycled(holder)

    open fun setData(data: List<Any>) {
        val newAdapterState = adapterState.copy(data = data)
        val diffCallback = DiffUtilCallback(adapterState, newAdapterState)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        adapterState = newAdapterState
        updateCallback?.let {
            diffResult.dispatchUpdatesTo(it)
        } ?: run {
            diffResult.dispatchUpdatesTo(this)
        }
    }

    override fun onViewAttachedToWindow(holder: ViewHolder) {
        adapterState.getAdapter(holder.itemViewType).onAttachedToWindow(holder)
    }

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        adapterState.getAdapter(holder.itemViewType).onDetachedFromWindow(holder)
    }

    override fun getItemCount(): Int = adapterState.data.size
}