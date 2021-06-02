package com.dcode.example.fragmentexp.pages.colors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dcode.example.fragmentexp.R
import com.dcode.example.fragmentexp.databinding.PageOrangeBinding
import com.dcode.example.fragmentexp.system.BasePage
import com.dcode.example.fragmentexp.system.NavigationPage

class OrangePage : BasePage(R.layout.page_orange) {

    private lateinit var binding: PageOrangeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = PageOrangeBinding.inflate(inflater)
        return binding.root
    }

    override fun viewDidLoad() {
        super.viewDidLoad()

        binding.internalButton.setOnClickListener {
            navigationPage?.pushPage(PurplePage())
        }

        binding.globalButton.setOnClickListener {
            (navigationPage as? NavigationPage)?.navigationPage?.pushPage(PurplePage())
        }
    }
}