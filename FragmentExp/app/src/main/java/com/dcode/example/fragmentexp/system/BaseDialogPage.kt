package com.dcode.example.fragmentexp.system

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity

open class BaseDialogPage(protected val contentViewId: Int) : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        isCancelable = true
        return inflater.inflate(contentViewId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
    }

    open fun viewDidAppear() {
    }

    open fun viewWillHide() {
    }

    fun show(activity: FragmentActivity?, tag: String? = null) {
        activity?.supportFragmentManager?.let { fragmentManager ->
            show(fragmentManager, tag ?: this::class.java.simpleName)
        }
    }

    fun executeDelayed(delay: Long = 0, execution: () -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed(execution, delay)
    }
}