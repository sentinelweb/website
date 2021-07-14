import kotlinx.html.UL
import kotlinx.html.id
import react.*
import react.dom.*
import react.dom.header
import react.router.dom.navLink

external interface HeaderProps : RProps {
    var isHome: Boolean
}

data class HeaderState(val unused: String) : RState

class Header(props: HeaderProps) : RComponent<HeaderProps, HeaderState>(props) {

    init {
        state = HeaderState("xxx")
    }

    override fun RBuilder.render() {
        header {
            attrs {
                id = "header"
            }

            a("index.html", classes = "logo") {
                img(alt = "logo", src = "img/logo-dark.svg", classes = "logo-light") {}
                img(alt = "logo", src = "img/logo-light.svg", classes = "logo-dark") {}
            }
            a("#", classes = "mob-menu") {
                span {}
                span {}
                span {}
            }
            if (props.isHome) {
                // onepage nav
                nav("navigation onepage") {
                    ul {
                        menuItem("#home", "Home")
                        menuItem("#about", "About")
                        menuItem("#portfolio", "Portfolio")
                        menuItem("#skills", "What we do")
                        menuItem("#services", "Services")
                        menuItem("#process", "Process")
                        menuItem("#clients", "Clients")
                        menuItem("#contact", "Contact")
                        menuItem("/blog.html", "Blog")
//                        menuItemNav(BLOG_PATH,"Blog")
                    }
                }
            } else {
                nav("navigation") {
                    ul {
                        menuItem("/", "Home")
                        menuItem(BLOG_PATH, "Blog", true)
//                        menuItemNav("/","Home")
//                        menuItemNav(BLOG_PATH,"Blog")
                    }
                }
            }
        }
    }

    private fun RDOMBuilder<UL>.menuItem(link: String, title: String, active:Boolean = false) {
        li {
            a(if(active)"active" else "") {
                attrs { href = link }
                +title
            }
        }
    }

    private fun RDOMBuilder<UL>.menuItemNav(link: String, title: String) {
        li {
            navLink<RProps>(link) {
                +title
            }
        }
    }

}


fun RBuilder.header(handler: HeaderProps.() -> Unit): ReactElement {
    return child(Header::class) {
        this.attrs(handler)
    }
}