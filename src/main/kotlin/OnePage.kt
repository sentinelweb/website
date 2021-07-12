import kotlinx.html.id
import kotlinx.html.unsafe
import react.*
import react.dom.*
import styled.styledHeader
import styled.styledNav

external interface OnePageProps : RProps {
    var lightTheme: Boolean
}

data class OnePageState(val unused: String) : RState

class OnePage(props: OnePageProps) : RComponent<OnePageProps, OnePageState>(props) {

    init {
        state = OnePageState("xxx")
    }

    override fun RBuilder.render() {
        header {}
        main {
            attrs { id = "main" }
            home {}
            about {}
            portfolio {}
            skills{}
            services{}
            process{}
            clients{}
        }
        footer {}
    }
}


fun RBuilder.onePage(handler: OnePageProps.() -> Unit): ReactElement {
    return child(OnePage::class) {
        this.attrs(handler)
    }
}
val LORUM_IPSUM ="Lorem ipsum doWeb Desiglor sit amet, consectetur adipisicing elit. Eaque quae, totam mollitia sequi vero eum facilis harum rerum nobis, cum ut quaerat reprehenderit numquam quos, minus perspiciatis perferendis. Enim, perferendis."