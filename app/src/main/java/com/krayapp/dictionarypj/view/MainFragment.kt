package com.krayapp.dictionarypj.view

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.krayapp.dictionarypj.data.AboutLetter
import com.krayapp.dictionarypj.data.LetterRepoImpl
import com.krayapp.dictionarypj.data.retrofit2.ApiHolder
import com.krayapp.dictionarypj.databinding.MainFragmentBinding
import com.krayapp.dictionarypj.presenter.MainFragmentPresenter
import com.krayapp.dictionarypj.view.adapter.MainFragmentAdapter

class MainFragment:IMainFragment, Fragment(){
    companion object{
        fun newInstance() = MainFragment()
    }
    private val presenter by lazy { MainFragmentPresenter(this,LetterRepoImpl(ApiHolder.api)) }
    private val viewBinding:MainFragmentBinding by viewBinding()
    private val mainFragmentAdapter = MainFragmentAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.letterRecycler.adapter = mainFragmentAdapter
        viewBinding.letterRecycler.visibility = View.INVISIBLE
        viewBinding.loadButton.setOnClickListener{
            if (viewBinding.inputText.text != null){
                viewBinding.loadButton.visibility = View.INVISIBLE
                viewBinding.inputText.visibility = View.INVISIBLE
                presenter.loadLetterInfo(
                    viewBinding.inputText.text.toString())
            }else{
                viewBinding.inputText.hint = "Letter is empty"
            }

        }
    }

    override fun showLetterInfo(list: List<AboutLetter>) {
        TODO("Not yet implemented")
    }

    override fun showRecycler() {
        viewBinding.letterRecycler.visibility = View.VISIBLE
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }
}