import kotlinx.css.Color
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
                        h2() {
                            +"We build cross-platform mobile and web experiences"
                        }
                    }
                    div("col-lg-6") {
                        p("lead") {
                            +"Consectetur adipisicing elit. Ipsa cupiditate itaque necessitatibus dolor? Lorem ipsum dolor sit amet, Eaque doloremque id est omnis ut saepe impedit magni vel inventore? Sequi similique magni perspiciatis voluptatem distinctio."
                        }
                        p("opacity-07") {
                            +"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquam consequuntur, blanditiis!"
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

//<section id="about" data-background="#fbfcfd" class="section-borders">
//<div class="container py-8 py-sm-13">
//<div class="row justify-content-between">
//
//<div class="col-lg-5 text-lg-right">
//<h2 class="bold">We Are Torola, Creative Design Agency</h2>
//</div>
//
//<div class="col-lg-6">
//<p class="lead">Consectetur adipisicing elit. Ipsa cupiditate itaque necessitatibus dolor? Lorem ipsum dolor sit amet, Eaque doloremque id est omnis ut saepe impedit magni vel inventore? Sequi similique magni perspiciatis voluptatem distinctio.</p>
//
//<p class="opacity-07">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquam consequuntur, blanditiis!</p>
//
//<p class="small uppercase mt-5">
//Keep scrolling to see our works or
//<a href="#contact">contact us</a>
//</p>
//</div>
//
//</div>
//</div>
//</section>