import kotlinx.html.id
import react.*
import react.dom.*

external interface OfficesProps : RProps {
    var x: Boolean
}

class Offices(props: OfficesProps) : RComponent<OfficesProps, RState>(props) {

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
                                setProp("data-api-key", SWEBSITE_MAPS_API_KEY)
                                setProp("data-latitude", "53.5891881")
                                setProp("data-longitude", "-2.3204524")
                                setProp("data-zoom", "7")
                                setProp("data-marker", "img/map-marker-check.svg")
                            }
                        }
                    }
                }
                div("row mt-3") {
                    div("col-lg-12") {
                        h5("p-3") { +"French Office" }
                        div("google-map map-column") {
                            attrs {
                                setProp("data-api-key", SWEBSITE_MAPS_API_KEY)
                                setProp("data-latitude", "45.9318746")
                                setProp("data-longitude", "6.859057")
                                setProp("data-zoom", "9")
                                setProp("data-marker", "img/map-marker-check.svg")
                            }
                        }
                    }

                }
            }
        }
    }

}


fun RBuilder.offices(handler: OfficesProps.() -> Unit): ReactElement {
    return child(Offices::class) {
        this.attrs(handler)
    }
}