package com.example.core_android.ui.delegateAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseDelegateAdapter<T: Any, VB: ViewBinding>(
    private val inflater: (LayoutInflater, parent: ViewGroup, attachToParent: Boolean) -> VB
) : DelegateAdapter {

    open fun VB.onCreated() {}
    open fun VB.onRecycled() {}
    open fun VB.onAttachedToWindow() {}
    open fun VB.onDetachedFromWindow() {}
    abstract fun VB.onBind(item: T, position: Int)

    abstract fun T.getItemId(): Any

    abstract fun isForViewType(item: Any): Boolean

    private var listener: (position: Int) -> Unit = {}

    fun setOnViewClicked(listener: (position: Int) -> Unit){
        this.listener = listener
    }

    fun onViewClicked(position: Int) = this.listener(position)

    final override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewBinding = inflater(layoutInflater, parent, false)
        viewBinding.onCreated()
        return ViewBindingHolder(viewBinding)
    }

    @Suppress("UNCHECKED_CAST")
    final override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        items: List<Any>,
        position: Int
    ) = (holder as ViewBindingHolder<VB>).viewBinding.onBind(items[position] as T, position)


    @Suppress("UNCHECKED_CAST")
    override fun onRecycled(holder: RecyclerView.ViewHolder) =
        (holder as ViewBindingHolder<VB>).viewBinding.onRecycled()

    override fun isForViewType(items: List<Any>, position: Int) = isForViewType(items[position])

    @Suppress("UNCHECKED_CAST")
    override fun itemId(item: Any) = (item as T).getItemId()

    override fun itemContent(item: Any): Any = item

    @Suppress("UNCHECKED_CAST")
    final override fun onAttachedToWindow(holder: RecyclerView.ViewHolder) =
        (holder as ViewBindingHolder<VB>).viewBinding.onAttachedToWindow()

    @Suppress("UNCHECKED_CAST")
    final override fun onDetachedFromWindow(holder: RecyclerView.ViewHolder) =
        (holder as ViewBindingHolder<VB>).viewBinding.onDetachedFromWindow()

    private class ViewBindingHolder<VB : ViewBinding>(
        val viewBinding: VB
    ) : RecyclerView.ViewHolder(viewBinding.root)
}