import kotlinx.html.id
import react.*
import react.dom.*
import react.dom.header

external interface HeaderProps : RProps {
    var x: Boolean
}

data class HeaderState(val unused: String) : RState

external class ScrollListener

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
//                img(alt = "logo", src = "img/logo-light.png", classes = "logo-light") {}
//                img(alt = "logo", src = "img/logo-light.png", classes = "logo-dark") {}
                img(alt = "logo", src = "img/logo-dark.svg", classes = "logo-light") {}
                img(alt = "logo", src = "img/logo-light.svg", classes = "logo-dark") {}
            }
            a("#", classes = "mob-menu") {
                span {}
                span { }
                span { }
            }
            nav("navigation onepage") {
                ul {
                    li {
                        a {
                            attrs { href = "#home" }
                            +"Home"
                        }
                    }
                    li {
                        a {
                            attrs { href = "#about" }
                            +"About"
                        }
                    }
                    li {
                        a {
                            attrs { href = "#portfolio" }
                            +"Portfolio"
                        }
                    }
                    li {
                        a {
                            attrs { href = "#skills" }
                            +"What we do"
                        }
                    }
                    li {
                        a {
                            attrs { href = "#services" }
                            +"Services"
                        }
                    }
                    li {
                        a {
                            attrs { href = "#process" }
                            +"Process"
                        }
                    }
                    li {
                        a {
                            attrs { href = "#clients" }
                            +"Clients"
                        }
                    }
                    li {
                        a {
                            attrs { href = "#contact" }
                            +"Contact"
                        }
                    }

                }
            }
        }
    }

}


fun RBuilder.header(handler: HeaderProps.() -> Unit): ReactElement {
    return child(Header::class) {
        this.attrs(handler)
    }
}