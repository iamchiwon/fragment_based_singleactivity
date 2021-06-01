# SingleActivity based on fragment

## Mechanism

- `Page` extends Fragment
- `NavigationPage` implements `Navigatable`
- `NavigationPage` contains `Page`s
- `Page` has parent `Navigatable`
- `Page` can be push/replace/pop through `Navigatable`
- `PageActivity` implements `Navigatable`
- When back pressed page call navitionPage's popPage()

## Life cycle

- viewDidLoad() : after created view
- viewDidApear() : on resume
- viewWillDisappear() : on pause

## How to use

### Create Page

```kotlin
class OrangePage : BasePage(R.layout.page_orange) {

    override fun viewDidLoad() {
        super.viewDidLoad()
        ...
    }
}
```

- DataBinding Page

```kotlin
class BluePage : BaseDataBindinPage<PageBlueBinding>(R.layout.page_blue) {

    override fun viewDidLoad() {
        super.viewDidLoad()
        ...
    }
}
```

### Create NavigationPage

> NavigationPage extends Page

```kotlin
val redPage = NavigationPage(rootPage = RedPage())
```

### Navigate

```kotlin
binding.internalButton.setOnClickListener {
    navigationPage?.pushPage(PurplePage())
}
```

### Push Transitions

```kotlin
navigationPage?.pushPage(PurplePage(), true, Navigatable::setSlideAnimation)

navigationPage?.pushPage(PurplePage(), true, Navigatable::setFadeAnimation)

navigationPage?.pushPage(PurplePage(), true, Navigatable::setSideUpAnimation)

//no transition
navigationPage?.pushPage(PurplePage(), false)

//custom transition
navigationPage?.pushPage(PurplePage(), true, (transaction) -> {
    transaction.setCustomAnimations(
                    R.anim.slide_in_from_right,
                    R.anim.slide_out_to_left
                )
})
```

<br/>

# License

```
MIT License

Copyright (c) 2021 iamchiwon

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```
