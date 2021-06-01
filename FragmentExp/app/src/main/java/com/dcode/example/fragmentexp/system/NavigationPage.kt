package com.dcode.example.fragmentexp.system

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.FragmentTransaction

class NavigationPage(val rootPage: BasePage) : BasePage(View.generateViewId()), Navigatable {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return activity?.run {
            FrameLayout(this).apply {
                id = contentViewId
                layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                setBackgroundColor(Color.WHITE)
            }
        }
    }

    override fun viewDidLoad() {
        super.viewDidLoad()
        pushPage(rootPage)
    }

    override fun onBackPressed() {
        if (navigationPage != null) {
            navigationPage!!.popPage()
            return
        }
        parentFragmentManager.popBackStack()
    }

    /** Navigatable **/

    override fun pushPage(page: BasePage, animation: Boolean, animationSetter: (FragmentTransaction) -> Unit) {
        page.navigationPage = this

        childFragmentManager.beginTransaction()
                .apply { if (animation) animationSetter(this) }
                .add(contentViewId, page)
                .addToBackStack(null)
                .commit()
    }

    override fun replacePage(page: BasePage, animation: Boolean, animationSetter: (FragmentTransaction) -> Unit) {
        page.navigationPage = this

        childFragmentManager.beginTransaction()
                .apply { if (animation) animationSetter(this) }
                .replace(contentViewId, page)
                .commit()
    }

    override fun popPage() {
        if (childFragmentManager.backStackEntryCount <= 1) {
            navigationPage?.popPage()
            return
        }
        childFragmentManager.popBackStack()
    }

    override fun popToRoot() {
        childFragmentManager.popBackStack(rootPage.id, 0)
    }
}