import kotlinx.html.DIV
import kotlinx.html.id
import react.*
import react.dom.*

external interface ClientsProps : RProps {
    var x: Boolean
}

class Clients(props: ClientsProps) : RComponent<ClientsProps, RState>(props) {

    override fun RBuilder.render() {
        section("section-borders") {
            attrs {
                id = "clients"
                setProp("data-background", "#ffffff")
            }
            div("container text-center py-7") {
                div("row clients") {
                    client("img/portfolio/trainline-logo.png")
                    client("img/portfolio/depop-logo.png")
                    client("img/portfolio/waracle-logo.png")
                }
                div("row clients") {
                    client("img/portfolio/jlc-logo.svg")
                    client("img/portfolio/pwc-logo.jpg")
                    client("img/portfolio/deloitte-logo.png")
                }
                div("row clients") {
                    client("img/portfolio/mgm-logo.svg")
                    client("img/portfolio/roche-logo.jpg")
                    client("img/portfolio/capita-logo.png")
                }
            }
        }

    }

    private fun RDOMBuilder<DIV>.client(url: String) {
        span("col-6 col-md-3 col-lg py-4") {
            img(src = url, classes = "clients-item") {}
        }
    }

}

fun RBuilder.clients(handler: ClientsProps.() -> Unit): ReactElement {
    return child(Clients::class) {
        this.attrs(handler)
    }
}
