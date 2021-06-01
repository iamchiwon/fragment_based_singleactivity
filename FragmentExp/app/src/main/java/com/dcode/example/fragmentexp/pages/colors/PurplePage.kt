package com.dcode.example.fragmentexp.pages.colors

import com.dcode.example.fragmentexp.R
import com.dcode.example.fragmentexp.databinding.PagePurleBinding
import com.dcode.example.fragmentexp.system.BaseDataBindinPage

class PurplePage : BaseDataBindinPage<PagePurleBinding>(R.layout.page_purle) {

    override fun viewDidLoad() {
        super.viewDidLoad()
        binding.backButton.setOnClickListener {
            navigationPage?.popPage()
        }
    }
    
    override fun onBackPressed() {
        if (binding.modelSwitch.isChecked) return

        super.onBackPressed()
    }
}