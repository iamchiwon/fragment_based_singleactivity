package com.dcode.example.fragmentexp

import com.dcode.example.fragmentexp.pages.SplashPage
import com.dcode.example.fragmentexp.system.NavigationPage
import com.dcode.example.fragmentexp.system.PageActivity

class MainActivity : PageActivity() {

    override fun viewDidLoad() {
        super.viewDidLoad()

        // START PAGE
        pushPage(NavigationPage(SplashPage()))
    }
}