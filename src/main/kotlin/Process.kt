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
                setProp("data-background", "/img/gallery/board-2440249_1280.jpg")
                setProp("data-overlay", "black; .7")

            }
            div("container p-0") {
                h5("mb-8") { +"PROCESS" }
                div("row") {
                    div("col-md-3") {
                        attrs { setProp("data-animation", "fade-in-bottom 1.2s .1s") }
                        h1("bold opacity-05"){+"01."}
                        h4("bold"){
                            +"IDEA "
                            span("serif"){+"&"}
                            +" COFFEE"
                        }
                        p{+LORUM_IPSUM}
                    }
                    div("col-md-3") {
                        attrs { setProp("data-animation", "fade-in-bottom 1.2s .2s") }
                        h1("bold opacity-05"){+"02."}
                        h4("bold"){
                            +"PROTOTYPE"
                        }
                        p{+LORUM_IPSUM}
                    }
                    div("col-md-3") {
                        attrs { setProp("data-animation", "fade-in-bottom 1.2s .3s") }
                        h1("bold opacity-05"){+"03."}
                        h4("bold"){
                            +"QUOTE"
                        }
                        p{+LORUM_IPSUM}
                    }
                    div("col-md-3") {
                        attrs { setProp("data-animation", "fade-in-bottom 1.2s .4s") }
                        h1("bold opacity-05"){+"04."}
                        h4("bold"){
                            +"BUILD"
                        }
                        p{+LORUM_IPSUM}
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