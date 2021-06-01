package com.dcode.example.fragmentexp.pages.colors

import android.widget.Toast
import com.dcode.example.fragmentexp.R
import com.dcode.example.fragmentexp.databinding.PageBlueBinding
import com.dcode.example.fragmentexp.databinding.PageRedBinding
import com.dcode.example.fragmentexp.databinding.PageYellowBinding
import com.dcode.example.fragmentexp.system.BaseDataBindinPage
import com.dcode.example.fragmentexp.system.BasePage

class YellowPage : BaseDataBindinPage<PageYellowBinding>(R.layout.page_yellow) {

    override fun viewDidLoad() {
        super.viewDidLoad()

        binding.toastButton.setOnClickListener {
            Toast.makeText(activity, "TOAST", Toast.LENGTH_SHORT).show()
        }
    }
}