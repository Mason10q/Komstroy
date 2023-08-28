package com.example.feature_construction.ui

import android.content.Context
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.core_android.ui.BaseAdapter
import com.example.feature_construction.R
import com.example.feature_construction.databinding.ItemStateBinding
import javax.inject.Inject
import com.example.core_android.R as androidR

private sealed class State(@ColorRes val bgColor: Int, @DrawableRes val icon: Int, val name: String) {

    class Done(name: String) : State(androidR.color.main_green, R.drawable.ic_confirm, name)
    class InProgress(name: String) : State(androidR.color.orange, R.drawable.ic_hammer, name)
    class InExpectation(name: String) : State(androidR.color.light_gray, R.drawable.ic_clock, name)

}

class RoadMap @Inject constructor() {

    var states = listOf<String>()

    fun createRecycler(context: Context, currentState: String) =
        RecyclerView(context).apply {
            val adapter = StateAdapter()
            this.adapter = adapter
            layoutManager = object: GridLayoutManager(context, 3) {
                override fun canScrollVertically(): Boolean = false
            }
            adapter.addItems(mapStates(states, currentState))
        }

    private fun mapStates(constrStates: List<String>, currentState: String): List<State> {
        var isAfterCurrent = false
        val states = ArrayList<State>()

        for (constrState in constrStates) {
            if (constrState == currentState) {
                states.add(State.InProgress(constrState))
                isAfterCurrent = true
                continue
            }

            states.add(if (isAfterCurrent) State.InExpectation(constrState) else State.Done(
                constrState
            )
            )
        }

        return states
    }

    private class StateAdapter : BaseAdapter<State, ItemStateBinding>(ItemStateBinding::inflate) {
        override fun bindViews(binding: ItemStateBinding, item: State, position: Int) {
            with(binding) {
                icon.setImageResource(item.icon)
                background.setImageResource(item.bgColor)
                name.text = item.name
            }
        }

        override fun onViewClicked(view: View, item: State) {}
    }

}