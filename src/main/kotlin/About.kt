import kotlinx.html.id
import react.*
import react.dom.*

external interface AboutProps : RProps {
    var x: Boolean
}

data class AboutState(val unused: String) : RState

class About(props: AboutProps) : RComponent<AboutProps, AboutState>(props) {

    init {
        state = AboutState("xxx")
    }

    override fun RBuilder.render() {
        section("section-borders") {
            attrs {
                id = "about"
                setProp("data-background", "#fbfcfd")
            }
            div("container py-8 py-sm-13") {
                div("row justify-content-between") {
                    div("col-lg-5 text-lg-right") {
                        h2 {
                            +"We build cross-platform mobile and web experiences"
                        }
                    }
                    div("col-lg-6") {
                        p("lead") {
                            +"With 25 years experience across many industries and sectors we can help you bring your idea to life. "
                            +"We believe that great software is crafted by great process and attention to detail. "
                        }
                        p("small uppercase mt-5") {
                            +"Keep scrolling to see our works or "
                            a(href = "#contact") {
                                +"contact us"
                            }
                        }
                    }
                }
            }
        }
    }

}


fun RBuilder.about(handler: AboutProps.() -> Unit): ReactElement {
    return child(About::class) {
        this.attrs(handler)
    }
}
