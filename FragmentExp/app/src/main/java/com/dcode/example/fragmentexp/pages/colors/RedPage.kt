package com.dcode.example.fragmentexp.pages.colors

import com.dcode.example.fragmentexp.R
import com.dcode.example.fragmentexp.databinding.PageRedBinding
import com.dcode.example.fragmentexp.system.BaseDataBindinPage

class RedPage : BaseDataBindinPage<PageRedBinding>(R.layout.page_red) {

    val tab1 = OrangePage()
    val tab2 = YellowPage()

    override fun viewDidLoad() {
        super.viewDidLoad()

        binding.tab1.setOnClickListener { showTab(0) }
        binding.tab2.setOnClickListener { showTab(1) }

        listOf(tab1, tab2).forEach {
            it.navigationPage = navigationPage
        }

        childFragmentManager.beginTransaction().apply {
            listOf(tab1, tab2).forEach { add(R.id.tabContent, it) }
            listOf(tab1, tab2).forEach { hide(it) }
            commit()
        }
        showTab(0)
    }

    fun showTab(i: Int) {
        childFragmentManager.beginTransaction().apply {
            listOf(tab1, tab2).forEach {
                hide(it)
            }
            show(listOf(tab1, tab2)[i])
            commit()
        }
    }
}