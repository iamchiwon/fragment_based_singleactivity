package com.dcode.example.fragmentexp.pages.colors

import android.content.Intent
import com.dcode.example.fragmentexp.OtherActivity
import com.dcode.example.fragmentexp.R
import com.dcode.example.fragmentexp.databinding.PageGreenBinding
import com.dcode.example.fragmentexp.databinding.PageRedBinding
import com.dcode.example.fragmentexp.pages.popup.BlackPopup
import com.dcode.example.fragmentexp.system.BaseDataBindinPage
import com.dcode.example.fragmentexp.system.BasePage

class GreenPage : BaseDataBindinPage<PageGreenBinding>(R.layout.page_green) {

    override fun viewDidLoad() {
        super.viewDidLoad()

        binding.buttonPopup.setOnClickListener {
            BlackPopup().show(activity)
        }

        binding.buttonActivity.setOnClickListener {
            startActivity(Intent(activity, OtherActivity::class.java))
        }
    }
}