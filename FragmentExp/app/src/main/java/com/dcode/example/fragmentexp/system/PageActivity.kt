package com.dcode.example.fragmentexp.system

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

open class PageActivity : AppCompatActivity(), Navigatable {
    private val contentViewId = View.generateViewId()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(FrameLayout(this).apply {
            id = contentViewId
            layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
            setBackgroundColor(Color.BLACK)
        })
    }

    /** Navigatable **/

    override fun pushPage(page: BasePage, animation: Boolean, animationSetter: (FragmentTransaction) -> Unit) {
        page.navigationPage = this

        supportFragmentManager.beginTransaction()
                .apply { if (animation) animationSetter(this) }
                .add(contentViewId, page)
                .addToBackStack(null)
                .commit()
    }

    override fun replacePage(page: BasePage, animation: Boolean, animationSetter: (FragmentTransaction) -> Unit) {
        page.navigationPage = this

        supportFragmentManager.beginTransaction()
                .apply { if (animation) animationSetter(this) }
                .replace(contentViewId, page)
                .addToBackStack(null)
                .commit()
    }

    override fun popPage() {
        if (supportFragmentManager.backStackEntryCount <= 1) {
            finish()
            return
        }
        supportFragmentManager.popBackStack()
    }

    override fun popToRoot() {
        val root = supportFragmentManager.getBackStackEntryAt(0)
        supportFragmentManager.popBackStack(root.id, 0)
    }
}