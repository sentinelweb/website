import kotlinx.html.id
import react.*
import react.dom.*

external interface ProcessProps : RProps {
    var x: Boolean
}

class Process(props: ProcessProps) : RComponent<ProcessProps, RState>(props) {

    override fun RBuilder.render() {
        section("text-light py-sm-13 py-10 px-7") {
            attrs {
                id = "process"
                // https://pixabay.com/photos/archer-archery-sunset-arrow-bow-2345211/
                setProp("data-background", "img/gallery/board-2440249_1280.jpg")
                setProp("data-overlay", "black; .8")

            }
            div("container p-0") {
                h4("mb-5") { +"PROCESS" }
                p("mb-5") {
                    +("In software good process is everything it save time and money and give the best result. " +
                            "It's important to get all the requirements gathered first and test them with customers using different techniques. " +
                            "We can guide you through the complete process and help and grow maintain your app after release.")

                }
                div("row") {
                    div("col-md-4") {
                        attrs { setProp("data-animation", "fade-in-bottom 1.2s .1s") }
                        h1("bold opacity-05") { +"01." }
                        h4("bold uppercase") {
                            +"IDEA"
                            span("serif") { +" & " }
                            +"COFFEE"
                        }
                        p { +"We can meet initially to discuss what you need to do and see what the best strategy is to move ahead." }
                    }
                    div("col-md-4") {
                        attrs { setProp("data-animation", "fade-in-bottom 1.2s .2s") }
                        h1("bold opacity-05") { +"02." }
                        h4("bold uppercase") {
                            +"PROTOTYPE"
                        }
                        p { +("We can test and refine requirements using techniques like paper prototypes, questionaires and online tools with people and customers. "
                                +"This helps to decide which feature are the most important and help set the priorities for the project.") }
                    }
                    div("col-md-4") {
                        attrs { setProp("data-animation", "fade-in-bottom 1.2s .4s") }
                        h1("bold opacity-05") { +"03." }
                        h4("bold uppercase") {
                            +"BUILD, "
                            +"Release"
                            span("serif") { +" & " }
                            +"refine"
                        }
                        p { +("We use an integrated agile software process that constantly delivers working software. " +
                                "By regularly releaasing - we can adapt to changing needs and refine as the project progresses. ") }
                    }
                }
            }

        }
    }

}

fun RBuilder.process(handler: ProcessProps.() -> Unit): ReactElement {
    return child(Process::class) {
        this.attrs(handler)
    }
}
//
//<!-- Process -->
//<section class="text-light py-sm-13 py-10 px-7" data-background="#222">
//<div class="container p-0">
//
//<h5 class="mb-8">PROCESS.</h5>
//
//<div class="row">
//
//<!-- Process Item -->
//<div class="col-md-4" data-animation="fade-in-bottom 1.2s .2s">
//<h1 class="bold opacity-02">01.</h1>
//<h4 class="bold">IDEA <span class="serif">&</span> COFFEE</h4>
//<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Rem officiis soluta nihil explicabo possimus. Maxime reiciendis atque soluta.</p>
//</div>
//<!-- /Process Item -->
//
//<!-- Process Item -->
//<div class="col-md-4" data-animation="fade-in-bottom 1.2s .4s">
//<h1 class="bold opacity-02">02.</h1>
//<h4 class="bold">PROTOTYPE</h4>
//<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Rem officiis soluta nihil explicabo possimus. Maxime reiciendis atque soluta.</p>
//</div>
//<!-- /Process Item -->
//
//<!-- Process Item -->
//<div class="col-md-4" data-animation="fade-in-bottom 1.2s .6s">
//<h1 class="bold opacity-02">03.</h1>
//<h4 class="bold">AWESOMENESS</h4>
//<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Rem officiis soluta nihil explicabo possimus. Maxime reiciendis atque soluta.</p>
//</div>
//<!-- /Process Item -->
//
//</div>
//</div>
//</section>