import kotlinx.html.id
import react.*
import react.dom.attrs
import react.dom.div
import react.dom.h5
import react.dom.section

external interface OficesProps : RProps {
    var x: Boolean
}

class Ofices(props: OficesProps) : RComponent<OficesProps, RState>(props) {

    override fun RBuilder.render() {
        section {
            attrs {
                id = "offices"
                setProp("data-background", "#888")
            }
            div("container text-light py-7") {
                div("row") {
                    div("col-lg-12") {
                        h5("p-3") { +"UK Office" }
                        div("google-map map-column") {
                            attrs {
                                setProp("data-api-key", "")
                                setProp("data-latitude", "53.5891881")
                                setProp("data-longitude", "-2.3204524")
                                setProp("data-zoom", "7")
                                setProp("data-marker", "/img/map-marker-check.svg")
                            }
                        }
                    }
                }
                div("row mt-3") {
                    div("col-lg-12") {

                        h5("p-3") { +"French Office" }
                        div("google-map map-column") {
                            attrs {
                                setProp("data-api-key", "")
                                setProp("data-latitude", "45.9318746")
                                setProp("data-longitude", "6.859057")
                                setProp("data-zoom", "9")
                                setProp("data-marker", "/img/map-marker-check.svg")
                            }
                        }
                    }

                }
            }
        }
    }

}


fun RBuilder.offices(handler: OficesProps.() -> Unit): ReactElement {
    return child(Ofices::class) {
        this.attrs(handler)
    }
}