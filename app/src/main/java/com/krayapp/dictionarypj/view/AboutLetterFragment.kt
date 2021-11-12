package com.krayapp.dictionarypj.view

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.krayapp.dictionarypj.R.layout.main_fragment
import com.krayapp.dictionarypj.data.AboutLetter
import com.krayapp.dictionarypj.databinding.MainFragmentBinding
import com.krayapp.dictionarypj.view.adapter.MainFragmentAdapter
import com.krayapp.dictionarypj.viewmodel.AboutLetterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AboutLetterFragment : IMainFragment, Fragment(main_fragment) {
    companion object {
        private const val ARG_KEY = "ARG_KEY"
        fun newInstance(letter:String): Fragment {
            val newFrag = AboutLetterFragment()
            newFrag.arguments = bundleOf(Pair(ARG_KEY, letter))
            return newFrag
        }
    }

    private val aboutLetterViewModel:AboutLetterViewModel by viewModel()
    private val viewBinding: MainFragmentBinding by viewBinding()
    private val mainFragmentAdapter = MainFragmentAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        aboutLetterViewModel.getData(arguments?.getString(ARG_KEY)!!)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoading()
        viewBinding.letterRecycler.adapter = mainFragmentAdapter
        aboutLetterViewModel.mutableLiveData.observe(viewLifecycleOwner, {
            showLetterInfo(it)
            showRecycler()
        })
    }

    override fun showLetterInfo(list: List<AboutLetter>) {
        mainFragmentAdapter.submitList(list)
        showRecycler()
    }

    override fun showLoading() {
        viewBinding.load.root.visibility = View.VISIBLE
    }

    private fun showRecycler() {
        viewBinding.letterRecycler.visibility = View.VISIBLE
        viewBinding.load.root.visibility = View.INVISIBLE
    }

}