package com.dcode.example.fragmentexp.system

import androidx.fragment.app.FragmentTransaction
import com.dcode.example.fragmentexp.R

interface Navigatable {
    fun pushPage(page: BasePage, animation: Boolean = true, animationSetter: (FragmentTransaction) -> Unit = ::setSlideAnimation)
    fun replacePage(page: BasePage, animation: Boolean = true, animationSetter: (FragmentTransaction) -> Unit = ::setSlideAnimation)
    fun popPage()
    fun popToRoot()

    companion object {
        fun setSlideAnimation(manager: FragmentTransaction) {
            manager.apply {
                setCustomAnimations(
                        R.anim.slide_in_from_right,
                        R.anim.slide_out_to_left,
                        R.anim.slide_in_from_left,
                        R.anim.slide_out_to_right)
            }
        }

        fun setFadeAnimation(manager: FragmentTransaction) {
            manager.apply {
                setCustomAnimations(
                        android.R.anim.fade_in,
                        android.R.anim.fade_out,
                        android.R.anim.fade_in,
                        android.R.anim.fade_out)
            }
        }

        fun setSideUpAnimation(manager: FragmentTransaction) {
            manager.apply {
                setCustomAnimations(
                        R.anim.slide_in_from_bottom,
                        R.anim.stay,
                        R.anim.stay,
                        R.anim.slide_out_to_bottom)
            }
        }
    }

}