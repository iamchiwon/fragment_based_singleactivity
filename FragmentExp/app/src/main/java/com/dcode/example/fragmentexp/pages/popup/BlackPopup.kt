package com.dcode.example.fragmentexp.pages.popup

import android.widget.Toast
import com.dcode.example.fragmentexp.R
import com.dcode.example.fragmentexp.databinding.PopupBlackBinding
import com.dcode.example.fragmentexp.system.BaseDataBindingDialogPage

class BlackPopup : BaseDataBindingDialogPage<PopupBlackBinding>(R.layout.popup_black) {

    override fun viewDidLoad() {
        super.viewDidLoad()

        isCancelable = false

        binding.buttonCancel.setOnClickListener { dismiss() }
        binding.buttonOK.setOnClickListener {
            Toast.makeText(context, "OK", Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }
}