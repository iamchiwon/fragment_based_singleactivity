package com.dcode.example.fragmentexp.system

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

open class BasePage(protected val contentViewId: Int) : Fragment() {

    var navigationPage: Navigatable? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(contentViewId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.isClickable = true
        viewDidLoad()
    }

    override fun onResume() {
        super.onResume()
        viewDidAppear()
    }

    override fun onPause() {
        viewWillHide()
        super.onPause()
    }

    open fun viewDidLoad() {
        activity?.also { activity ->
            activity.onBackPressedDispatcher.addCallback(activity, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    onBackPressed()
                }
            })
        }
    }

    open fun viewDidAppear() {
    }

    open fun viewWillHide() {
    }

    open fun onBackPressed() {
        navigationPage?.popPage()
    }

    fun executeDelayed(delay: Long = 0, execution: () -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed(execution, delay)
    }
}