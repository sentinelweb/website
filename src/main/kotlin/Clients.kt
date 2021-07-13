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
                id="clients"
                setProp("data-background", "#ffffff")
            }
            div("container text-center py-7") {
                div("row clients") {
                    span("col-6 col-md-4 col-lg py-4") {
                        img(src = "/img/portfolio/trainline-logo.png", classes = "clients-item") {}
                    }
                    span("col-6 col-md-4 col-lg py-4") {
                        img(src = "/img/portfolio/depop-logo.png", classes = "clients-item") {}
                    }
                    span("col-6 col-md-4 col-lg py-4") {
                        img(src = "/img/portfolio/waracle-logo.png", classes = "clients-item") {}
                    }
                    span("col-6 col-md-4 col-lg py-4") {
                        img(src = "/img/portfolio/jlc-logo.svg", classes = "clients-item") {}
                    }
                }
                div("row clients") {
                    span("col-6 col-md-4 col-lg py-4") {
                        img(src = "/img/portfolio/pwc-logo.jpg", classes = "clients-item") {}
                    }
                    span("col-6 col-md-4 col-lg py-4") {
                        img(src = "/img/portfolio/deloitte-logo.png", classes = "clients-item") {}
                    }
                    span("col-6 col-md-4 col-lg py-4") {
                        img(src = "/img/portfolio/mgm-logo.svg", classes = "clients-item") {}
                    }
                    span("col-6 col-md-4 col-lg py-4") {
                        img(src = "/img/portfolio/capita-logo.png", classes = "clients-item") {}
                    }
                }
            }
        }
    }

}

fun RBuilder.clients(handler: ClientsProps.() -> Unit): ReactElement {
    return child(Clients::class) {
        this.attrs(handler)
    }
}

//<section data-background="#f7f7f7" class="section-borders">
//<div class="container text-center py-6">
//<div class="row">
//<div class="col-6 col-md-4 col-lg py-4">
//<img src="http://placehold.it/200x150" class="w-50" alt="">
//</div>
//<div class="col-6 col-md-4 col-lg py-4">
//<img src="http://placehold.it/200x150" class="w-50" alt="">
//</div>
//<div class="col-6 col-md-4 col-lg py-4">
//<img src="http://placehold.it/200x150" class="w-50" alt="">
//</div>
//<div class="col-6 col-md-4 col-lg py-4">
//<img src="http://placehold.it/200x150" class="w-50" alt="">
//</div>
//<div class="col-6 col-md-4 col-lg py-4">
//<img src="http://placehold.it/200x150" class="w-50" alt="">
//</div>
//<div class="col-6 col-md-4 col-lg py-4">
//<img src="http://placehold.it/200x150" class="w-50" alt="">
//</div>
//</div>
//</div>
//</section>