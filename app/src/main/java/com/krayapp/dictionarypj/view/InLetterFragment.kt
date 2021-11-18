package com.krayapp.dictionarypj.view

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.krayapp.dictionarypj.R
import com.krayapp.datamodule.data.AboutLetter
import com.krayapp.dictionarypj.databinding.InLetterFragmentBinding
import com.krayapp.dictionarypj.viewmodel.InLetterViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

class InLetterFragment : Fragment(R.layout.in_letter_fragment) {
    companion object {
        private const val ARG_KEY = "ARG_KEY"
        fun newInstance(aboutLetter: AboutLetter): Fragment {
            val newFrag = InLetterFragment()
            newFrag.arguments = bundleOf(Pair(ARG_KEY, aboutLetter))
            return newFrag
        }
    }

    private val viewBinding: InLetterFragmentBinding by viewBinding()
    private val inLetterViewModel: InLetterViewModel by viewModel()
    private lateinit var currentAboutLetter: AboutLetter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentAboutLetter = arguments?.getParcelable(ARG_KEY)!!
        inLetterViewModel.mutableLiveData.observe(viewLifecycleOwner, { imagedto ->
            Picasso.get()
                .load(imagedto.photos.first().src.original)
                .placeholder(R.drawable.doge)
                .into(viewBinding.imageContainer)
        })
        init()
    }

    private fun init() {
        viewBinding.originalLetter.text = currentAboutLetter.text
        viewBinding.translatedLetter.text = currentAboutLetter.translation
        inLetterViewModel.getImage(currentAboutLetter.text)
    }

}