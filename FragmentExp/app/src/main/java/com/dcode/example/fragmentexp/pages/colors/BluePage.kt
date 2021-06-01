package com.dcode.example.fragmentexp.pages.colors

import com.dcode.example.fragmentexp.R
import com.dcode.example.fragmentexp.databinding.PageBlueBinding
import com.dcode.example.fragmentexp.system.BaseDataBindinPage
import com.dcode.example.fragmentexp.system.Navigatable
import com.dcode.example.fragmentexp.system.NavigationPage

class BluePage : BaseDataBindinPage<PageBlueBinding>(R.layout.page_blue) {

    override fun viewDidLoad() {
        super.viewDidLoad()

        binding.internalButton.setOnClickListener {
            navigationPage?.pushPage(PurplePage(), true, Navigatable::setFadeAnimation)
        }

        binding.globalButton.setOnClickListener {
            (navigationPage as? NavigationPage)?.navigationPage?.pushPage(PurplePage(), true, Navigatable::setSideUpAnimation)
        }
    }
}