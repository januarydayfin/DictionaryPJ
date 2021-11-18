package com.krayapp.dictionarypj.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.krayapp.dictionarypj.R.layout.about_letter_fragment
import com.krayapp.datamodule.data.AboutLetter
import com.krayapp.dictionarypj.databinding.AboutLetterFragmentBinding
import com.krayapp.dictionarypj.view.adapter.AboutLetterAdapter
import com.krayapp.dictionarypj.viewmodel.AboutLetterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AboutLetterFragment : Fragment(about_letter_fragment),AboutLetterAdapter.Delegate {
    companion object {
        private var localRequestStatus: Boolean = false
        private const val ARG_KEY = "ARG_KEY"
        fun newInstance(letter: String): Fragment {
            localRequestStatus = false
            val newFrag = AboutLetterFragment()
            newFrag.arguments = bundleOf(Pair(ARG_KEY, letter))
            return newFrag
        }

        fun newLocalInstance(letter: String): Fragment {
            localRequestStatus = true
            val newFrag = AboutLetterFragment()
            newFrag.arguments = bundleOf(Pair(ARG_KEY, letter))
            return newFrag
        }
    }

    private val aboutLetterViewModel: AboutLetterViewModel by viewModel()
    private val viewBinding: AboutLetterFragmentBinding by viewBinding()
    private val aboutLetterAdapter = AboutLetterAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (localRequestStatus)
            aboutLetterViewModel.findLetterInLocalBase(arguments?.getString(ARG_KEY)!!)
        //добавить скобку, если не нужно, чтобы подкачивал из сети
        aboutLetterViewModel.getData(arguments?.getString(ARG_KEY)!!)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoading()
        viewBinding.letterRecycler.adapter = aboutLetterAdapter
        aboutLetterViewModel.mutableLiveData.observe(viewLifecycleOwner, {
            showLetterInfo(it)
            showRecycler()
        })
    }

    private fun showLetterInfo(list: List<AboutLetter>) {
        if (!list.isEmpty()) {
            aboutLetterAdapter.submitList(list)
            showRecycler()
        } else {
            Toast.makeText(context, "Не удалось загрузить/нет в истории", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showLoading() {
        viewBinding.load.root.visibility = View.VISIBLE
    }

    private fun showRecycler() {
        viewBinding.letterRecycler.visibility = View.VISIBLE
        viewBinding.load.root.visibility = View.INVISIBLE
    }

    override fun onLetterPicked(aboutLetter: AboutLetter) {
        aboutLetterViewModel.openInLetter(aboutLetter)
    }

}