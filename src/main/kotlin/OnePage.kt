import kotlinx.browser.document
import kotlinx.html.id
import react.*
import react.dom.*

external interface OnePageProps : RProps {
    var changeTheme: () -> Unit
}

class OnePage(props: OnePageProps) : RComponent<OnePageProps, RState>(props) {

    override fun RBuilder.render() {
        document.title = "Sentinel Web Technologies Ltd"
        div { attrs { id = "preloader" } }
        header {
            isHome = true
            changeTheme = props.changeTheme
        }
        main {
            attrs { id = "main" }
            home {}
            about {}
            portfolio {}
            skills {}
            services {}
            process {}
            clients {}
            contact {}
            offices {}
        }
        footer {}
    }
}

fun RBuilder.onePage(handler: OnePageProps.() -> Unit): ReactElement {
    return child(OnePage::class) {
        this.attrs(handler)
    }
}
