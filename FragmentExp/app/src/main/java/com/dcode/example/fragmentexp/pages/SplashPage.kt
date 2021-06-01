package com.dcode.example.fragmentexp.pages

import com.dcode.example.fragmentexp.R
import com.dcode.example.fragmentexp.databinding.PageMainBinding
import com.dcode.example.fragmentexp.system.BaseDataBindinPage
import com.dcode.example.fragmentexp.system.Navigatable

class SplashPage : BaseDataBindinPage<PageMainBinding>(R.layout.page_splash) {

    override fun viewDidLoad() {
        super.viewDidLoad()
        executeDelayed(1500) {
            navigationPage?.replacePage(MainPage(), true, Navigatable::setFadeAnimation)
        }
    }
}