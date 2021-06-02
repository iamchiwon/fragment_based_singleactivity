package com.dcode.example.fragmentexp

import com.dcode.example.fragmentexp.pages.colors.GreenPage
import com.dcode.example.fragmentexp.system.PageActivity

class OtherActivity : PageActivity() {
    override fun viewDidLoad() {
        super.viewDidLoad()

        // START PAGE
        pushPage(GreenPage())
    }
}