import kotlinx.html.id
import react.*
import react.dom.*

external interface ContactProps : RProps {
    var x: Boolean
}

data class ContactState(val unused: String) : RState

class Contact(props: ContactProps) : RComponent<ContactProps, ContactState>(props) {

    init {
        state = ContactState("xxx")
    }

    override fun RBuilder.render() {
        section("background-fixed") {
            attrs {
                id = "contact"
                //https://pixabay.com/illustrations/network-hug-embrace-man-media-4143317/
                setProp("data-background", "img/gallery/network-4143317_1280.jpg")
                setProp("data-overlay", "black; .7")
            }
            div("container text-light py-10") {
                div("row no-gutters") {
                    div("col-md-6") {
                        h3("uppercase") { +"Contact" }
                        h6("uppercase mt-6") {
                            +"Let us know ..."
                        }
                        ul("mt-6 ml-6") {
                            li("mt-3") { +"When you want to start your project" }
                            li("mt-3") { +"What type of business you have" }
                            li("mt-3") { +"You business size" }
                        }
                    }
                    div("col-lg-6 align-self-center") {
                        attrs {
                            id = "contact"
                            // https://pixabay.com/illustrations/finger-network-binary-null-one-5848448/
                            setProp("data-background", "#fff8")
                        }
                        iframe() {
                            attrs {
                                src =
                                    "https://docs.google.com/forms/d/e/1FAIpQLScSPAErD4ROD8CburgmBtoaA0wkZYMPPMmE8fF29MOVojzSww/viewform?embedded=true"
                                width = "100%"
                                height = "1332"
                                setProp("frameborder", "0")
                                setProp("marginheight", "0")
                                setProp("marginwidth", "0")
                            }
                            +"Loading ... "
                        }
                    }
                }
            }
        }
    }

}


fun RBuilder.contact(handler: ContactProps.() -> Unit): ReactElement {
    return child(Contact::class) {
        this.attrs(handler)
    }
}
