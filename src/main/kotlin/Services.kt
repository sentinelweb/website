import kotlinx.html.id
import react.*
import react.dom.*

external interface ServicesProps : RProps {
    var x: Boolean
}

class Services(props: ServicesProps) : RComponent<ServicesProps, RState>(props) {
    override fun RBuilder.render() {
        section("bg-lines py-sm-13 py-10 px-7") {
            attrs {
                id = "services"
            }
            div("container p-0") {
                div("row no-gutters") {
                    div("col-md-6") {
                        h4("uppercase") { +"SERVICES" }
                    }
                    div("col-md-6") {
                        service {
                            title = "Design"
                            text = ("We can work with you and your customers to identify needs. " +
                                    "We will help make a plan for strategic implementation. ")
                        }
                        hr("separator-left my-6") {}
                        service {
                            title = "Development"
                            text =
                                ("We use cross-platform technology (Kotlin Multi-platform) and this can help you bring you app to more platforms in a shorter time. "
                                        + "We can build for Mobile, Web and desktop and use the backend that is best for you.")
                        }
                        hr("separator-left my-6") {}
                        service {
                            title = "Deployment"
                            text =
                                ("We can deploy your application on any number of services such as AWS, Firebase, Google Cloud and more."
                                        + "")
                        }
                    }
                }
            }
        }
    }
}


fun RBuilder.services(handler: ServicesProps.() -> Unit): ReactElement {
    return child(Services::class) {
        this.attrs(handler)
    }
}

external interface ServiceProps : RProps {
    var title: String
    var text: String
}

class Service(props: ServiceProps) : RComponent<ServiceProps, RState>(props) {

    override fun RBuilder.render() {
        div(){
            attrs { setProp("data-animation", "fade-in-bottom 1.2s .2s") }
            + props.title
        }
        p("pt-4") { +props.text }
    }

}


fun RBuilder.service(handler: ServiceProps.() -> Unit): ReactElement {
    return child(Service::class) {
        this.attrs(handler)
    }
}

//<section id="services" class="bg-lines py-sm-13 py-10 px-7">
//<div class="container p-0">
//<div class="row no-gutters">
//
//<div class="col-md-6">
//<h5 class="mb-8">SERVICES.</h5>
//</div>
//
//<div class="col-md-6">
//
//<!-- Service Item -->
//<div data-animation="fade-in-bottom 1.2s .2s">
//<h5 class="uppercase">n</h5>
//<p class="small">Lorem ipsum doWeb Desiglor sit amet, consectetur adipisicing elit. Eaque quae, totam mollitia sequi vero eum facilis harum rerum nobis, cum ut quaerat reprehenderit numquam quos, minus perspiciatis perferendis. Enim, perferendis.</p>
//</div>
//<!-- /Service Item -->
//
//<hr class="separator-left my-6">
//
//<!-- Service Item -->
//<div data-animation="fade-in-bottom 1.2s .4s">
//<h5 class="uppercase">Web Development</h5>
//<p class="small">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eaque quae, totam mollitia sequi vero eum facilis harum rerum nobis, cum ut quaerat reprehenderit numquam quos, minus perspiciatis perferendis. Enim, perferendis.</p>
//</div>
//<!-- /Service Item -->
//
//<hr class="separator-left my-6">
//
//<!-- Service Item -->
//<div data-animation="fade-in-bottom 1.2s .6s">
//<h5 class="uppercase">Illustration</h5>
//<p class="small">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eaque quae, totam mollitia sequi vero eum facilis harum rerum nobis, cum ut quaerat reprehenderit numquam quos, minus perspiciatis perferendis. Enim, perferendis.</p>
//</div>
//<!-- /Service Item -->
//
//</div>
//
//</div>
//</div>
//</section>