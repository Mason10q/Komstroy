package com.example.core_android.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.core_android.viewModel.BaseListViewModel
import com.example.core_android.viewModel.ViewModelFactory
import javax.inject.Inject


abstract class BaseListFragment<
        DATA : Any,
        B : ViewBinding,
        A : BaseAdapter<DATA, B>,
        VM : BaseListViewModel<DATA>,
        FB : ViewBinding>(
    viewModelClass: Class<VM>,
    inflater: (LayoutInflater) -> FB
) : Fragment() {

    @Inject lateinit var viewModelFactory: ViewModelFactory

    protected val viewModel by lazy { ViewModelProvider(this, viewModelFactory)[viewModelClass] }

    protected val binding: FB by lazy { inflater(layoutInflater) }

    protected abstract val adapter: A

    protected abstract fun getData()

    protected abstract fun onViewClicked(view: View, item: DATA)
    protected open fun inject() {}

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel.data.observe(viewLifecycleOwner) { items ->
            adapter.setItems(items)
        }

        viewModel.error.observe(viewLifecycleOwner) { msg ->
            Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show()
        }

        adapter.setOnViewClicked(::onViewClicked)

        getData()

        return binding.root
    }

    override fun onStop() {
        super.onStop()
        viewModel.onStop()
    }

}
