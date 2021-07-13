import kotlinx.html.id
import react.*
import react.dom.*

external interface HomeProps : RProps {
    var x: Boolean
}

data class HomeState(val unused: String) : RState

class Home(props: HomeProps) : RComponent<HomeProps, HomeState>(props) {

    init {
        state = HomeState("xxx")
    }

    override fun RBuilder.render() {
        section(classes = "hero hero-fullscreen background-parallax d-flex") {
            attrs {
                id = "home"
                // https://pixabay.com/photos/network-social-abstract-hands-4109223/
                setProp("data-background","/img/gallery/network-4109223_1280.jpg")
                setProp("data-overlay","black; .6")
            }
            div("align-self-end pb-10 fullwidth text-center text-light"){
                img(src="/img/icon.svg", classes = "page-title-icon"){}
                h2("page-title-alt"){
                    +"Sentinel Web Technologies"
                }
                p("uppercase small"){
                    +"Mobile / Web Design and Development"
                }
            }
        }
        // scroll down line
        a(href = "#", classes = "scroll-down"){
            span {  }
        }

    }

}

fun RBuilder.home(handler: HomeProps.() -> Unit): ReactElement {
    return child(Home::class) {
        this.attrs(handler)
    }
}