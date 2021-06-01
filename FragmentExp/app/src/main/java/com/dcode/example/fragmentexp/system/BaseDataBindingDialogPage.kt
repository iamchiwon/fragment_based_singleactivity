package com.dcode.example.fragmentexp.system

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewbinding.ViewBinding

open class BaseDataBindingDialogPage<T : ViewBinding>(contentViewId: Int) : BaseDialogPage(contentViewId) {

    protected lateinit var binding: T

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        isCancelable = true
        binding = DataBindingUtil.inflate(inflater, contentViewId, container, false)
        return binding.root
    }
}