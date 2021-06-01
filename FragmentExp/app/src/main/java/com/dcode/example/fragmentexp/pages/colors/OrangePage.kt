package com.dcode.example.fragmentexp.pages.colors

import android.view.LayoutInflater
import com.dcode.example.fragmentexp.R
import com.dcode.example.fragmentexp.databinding.PageOrangeBinding
import com.dcode.example.fragmentexp.system.BaseViewBindinPage
import com.dcode.example.fragmentexp.system.NavigationPage

class OrangePage : BaseViewBindinPage<PageOrangeBinding>(R.layout.page_orange) {

    override fun viewDidLoad() {
        super.viewDidLoad()

        binding = PageOrangeBinding.inflate(LayoutInflater.from(context))

        binding.internalButton.setOnClickListener {
            navigationPage?.pushPage(PurplePage())
        }

        binding.globalButton.setOnClickListener {
            (navigationPage as? NavigationPage)?.navigationPage?.pushPage(PurplePage())
        }
    }
}