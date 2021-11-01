package com.krayapp.dictionarypj.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.krayapp.dictionarypj.R.layout.main_fragment
import com.krayapp.dictionarypj.data.AboutLetter
import com.krayapp.dictionarypj.data.ILetterRepo
import com.krayapp.dictionarypj.databinding.MainFragmentBinding
import com.krayapp.dictionarypj.presenter.MainFragmentPresenter
import com.krayapp.dictionarypj.view.adapter.MainFragmentAdapter
import com.krayapp.movieapppoplib.view.abs.AbsFragment

class MainFragment : IMainFragment, AbsFragment(main_fragment) {
    companion object {
        fun newInstance(): Fragment {
            return MainFragment()
        }
    }

    private val presenter by lazy { MainFragmentPresenter(this, LetterRepoImpl(ApiHolder.api)) }

    private val viewBinding: MainFragmentBinding by viewBinding()
    private val mainFragmentAdapter = MainFragmentAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.letterRecycler.adapter = mainFragmentAdapter

        viewBinding.loadButton.setOnClickListener {
            showLoading()
            viewBinding.letterRecycler.visibility = View.VISIBLE
            val text = viewBinding.inputText.text.toString()
            if (!text.equals("")) {
                viewBinding.loadButton.visibility = View.INVISIBLE
                viewBinding.inputText.visibility = View.INVISIBLE
                presenter.loadLetterInfo(text)
            } else {
                Toast.makeText(context, "Letter field is empty", Toast.LENGTH_SHORT).show()
                viewBinding.inputText.hint = "Letter is empty"
                viewBinding.load.root.visibility = View.INVISIBLE
            }
        }
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

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }
}