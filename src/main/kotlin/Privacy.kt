import kotlinx.html.id
import react.*
import react.dom.*

external interface PrivacyProps : RProps {
    var changeTheme: () -> Unit
}

data class PrivacyState(override var contentHtml:String?) : ContentState()

class Privacy(props: PrivacyProps) : RComponent<PrivacyProps, PrivacyState>(props) {

    override fun RBuilder.render() {
        div { attrs { id = "preloader" } }
        header {
            isHome = false
            changeTheme = props.changeTheme
        }
        main {
            attrs { id = "main" }
            renderHero("Privacy policy", "img/gallery/404-girl-1208283_1280.jpg", ".5")
            renderContent(state.contentHtml)
            contact {}
        }
        footer {}
    }

    override fun componentDidMount() {
        fetchContent("/content/privacy.html")
    }

}

fun RBuilder.privacy(handler: PrivacyProps.() -> Unit): ReactElement {
    return child(Privacy::class) {
        this.attrs(handler)
    }
}