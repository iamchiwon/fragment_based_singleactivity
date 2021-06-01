package com.dcode.example.fragmentexp.pages.colors

import android.widget.Button
import com.dcode.example.fragmentexp.R
import com.dcode.example.fragmentexp.databinding.PageBlueBinding
import com.dcode.example.fragmentexp.databinding.PageRedBinding
import com.dcode.example.fragmentexp.system.BaseDataBindinPage
import com.dcode.example.fragmentexp.system.BasePage
import com.dcode.example.fragmentexp.system.Navigatable
import com.dcode.example.fragmentexp.system.NavigationPage

class OrangePage : BasePage(R.layout.page_orange) {

    override fun viewDidLoad() {
        super.viewDidLoad()

        view?.findViewById<Button>(R.id.internalButton)?.setOnClickListener {
            navigationPage?.pushPage(PurplePage())
        }

        view?.findViewById<Button>(R.id.globalButton)?.setOnClickListener {
            (navigationPage as? NavigationPage)?.navigationPage?.pushPage(PurplePage())
        }
    }
}