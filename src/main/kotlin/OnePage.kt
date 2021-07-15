import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.html.id
import kotlinx.html.unsafe
import react.*
import react.dom.*
import styled.styledHeader
import styled.styledNav

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

val LORUM_IPSUM =
    "Lorem ipsum doWeb Desiglor sit amet, consectetur adipisicing elit. Eaque quae, totam mollitia sequi vero eum facilis harum rerum nobis, cum ut quaerat reprehenderit numquam quos, minus perspiciatis perferendis. Enim, perferendis."
