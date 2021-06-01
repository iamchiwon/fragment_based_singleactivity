package com.dcode.example.fragmentexp

import com.dcode.example.fragmentexp.pages.SplashPage
import com.dcode.example.fragmentexp.system.NavigationPage
import com.dcode.example.fragmentexp.system.PageActivity

class MainActivity : PageActivity() {
    override fun onStart() {
        super.onStart()

        // START PAGE
        pushPage(NavigationPage(SplashPage()))
    }
}