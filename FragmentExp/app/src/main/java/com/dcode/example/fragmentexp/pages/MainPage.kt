package com.dcode.example.fragmentexp.pages

import com.dcode.example.fragmentexp.R
import com.dcode.example.fragmentexp.databinding.PageMainBinding
import com.dcode.example.fragmentexp.pages.colors.*
import com.dcode.example.fragmentexp.system.BaseDataBindinPage
import com.dcode.example.fragmentexp.system.NavigationPage

class MainPage : BaseDataBindinPage<PageMainBinding>(R.layout.page_main) {

    private val redPage = NavigationPage(RedPage())
    private val greenPage = NavigationPage(GreenPage())
    private val bluePage = NavigationPage(BluePage())
    private val orangePage = NavigationPage(OrangePage())
    private val yellowPage = NavigationPage(YellowPage())

    override fun viewDidLoad() {
        super.viewDidLoad()

        listOf(redPage, greenPage, bluePage, orangePage, yellowPage)
                .forEach {
                    it.navigationPage = navigationPage
                }

        binding.button1.setOnClickListener { showTab(0) }
        binding.button2.setOnClickListener { showTab(1) }
        binding.button3.setOnClickListener { showTab(2) }
        binding.button4.setOnClickListener { showTab(3) }
        binding.button5.setOnClickListener { showTab(4) }

        childFragmentManager.beginTransaction()
                .add(R.id.mainContentView, redPage)
                .add(R.id.mainContentView, greenPage)
                .add(R.id.mainContentView, bluePage)
                .add(R.id.mainContentView, orangePage)
                .add(R.id.mainContentView, yellowPage)
                .commit()

        showTab(2)
    }

    private fun showTab(i: Int) {
        childFragmentManager.beginTransaction()
                .apply {
                    listOf(redPage, greenPage, bluePage, orangePage, yellowPage)
                            .forEach {
                                hide(it)
                            }
                }
                .apply {
                    show(
                            listOf(redPage, greenPage, bluePage, orangePage, yellowPage)[i]
                    )
                }
                .commit()
    }
}