import kotlinx.html.id
import react.*
import react.dom.*

external interface SkillsProps : RProps {
    var x: Boolean
}


class Skills(props: SkillsProps) : RComponent<SkillsProps, RState>(props) {

    override fun RBuilder.render() {
        section("background-fixed") {
            attrs {
                id = "skills"
                // https://pixabay.com/photos/archer-archery-sunset-arrow-bow-2345211/
                setProp("data-background", "/img/gallery/archer-2345211_1280.jpg")
                setProp("data-overlay", "black; .6")
            }
            div("container text-light py-10") {
                div("row") {
                    div("col-xl-6 col-lg-4") {
                        h4("mt-4") { +"Skills" }
                    }
                    div("col-xl-6 col-lg-8") {
                        skillGroup {
                            title = "Development"
                            list = listOf("Kotlin Multi-Platform", "Android", "iOS", "HTML / CSS / JS", "Node JS", "React")
                        }
                        hr("mb-3") { attrs { setProp("data-background", "#444") } }
                        skillGroup {
                            title = "Devops"
                            list = listOf("Gradle", "Unit testing", "UI Testing", "Database", "Continuous Integration", "Deployment")
                        }
                        hr("mb-3") { attrs { setProp("data-background", "#444") } }
                        skillGroup {
                            title = "Design"
                            list = listOf("User Experience","User Interface", "Photoshop", "Illustrator", "Prototyping", "User Testing")
                        }
                        hr("mb-3") { attrs { setProp("data-background", "#444") } }
                        skillGroup {
                            title = "Process"
                            list = listOf("Agile", "Scrum", "Kanban", "Continuous Development", "XP/Pair Programming",
                                "Feature Driven Developemnt","Behaviour Driven Developemnt","Test Driven Developemnt", "Continuous Delivery")
                        }
                    }
                }
            }
        }
    }

}


fun RBuilder.skills(handler: SkillsProps.() -> Unit): ReactElement {
    return child(Skills::class) {
        this.attrs(handler)
    }
}

external interface SkillGroupProps : RProps {
    var title: String
    var list: List<String>
}

class SkillGroup(props: SkillGroupProps) : RComponent<SkillGroupProps, RState>(props) {

    override fun RBuilder.render() {
        div("row") {
            div("col-md-3 pt-4 mb-0") {
                p("opacity-07") {
                    +props.title

                }
            }
            div("col") {
                div("row") {
                    props.list.forEach {
                        div("col-4 py-4") {
                            +it
                        }
                    }
                }
            }
        }
    }

}


fun RBuilder.skillGroup(handler: SkillGroupProps.() -> Unit): ReactElement {
    return child(SkillGroup::class) {
        this.attrs(handler)
    }
}
//
//<!-- Experience -->
//<section id="story" class="background-fixed" data-background="img/gallery/107.jpg" data-overlay="black; .9">
//<div class="container text-light py-10">
//
//<div class="row">
//
//<!-- title column -->
//<div class="col-xl-6 col-lg-4">
//<h5 class="mt-7">OUR STORY</h5>
//</div>
//
//<!-- content column -->
//<div class="col-xl-6 col-lg-8">
//
//<!-- experience item -->
//<div class="row my-7" data-animation="fade-in-left 1s .9s">
//<div class="col-md-3">
//<div class="opacity-04">2018</div>
//</div>
//<div class="col">
//<h5>Consectetur adipisicing elit</h5>
//<p class="small">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Deserunt officia laboriosam assumenda voluptas sed sequi!</p>
//</div>
//</div>
//
//<!-- experience item -->
//<div class="row my-7" data-animation="fade-in-left 1s .4s">
//<div class="col-md-3">
//<div class="opacity-04">2015</div>
//</div>
//<div class="col">
//<h5>Consectetur adipisicing elit</h5>
//<p class="small">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Deserunt officia laboriosam assumenda voluptas sed sequi!</p>
//</div>
//</div>
//
//<!-- experience item -->
//<div class="row my-7" data-animation="fade-in-left 1s .7s">
//<div class="col-md-3">
//<div class="opacity-04">2013</div>
//</div>
//<div class="col">
//<h5>Consectetur adipisicing elit</h5>
//<p class="small">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Deserunt officia laboriosam assumenda voluptas sed sequi!</p>
//</div>
//</div>
//
//</div>
//</div>
//
//<!-- separator -->
//<hr data-background="#444" class="mb-9">
//
//<div class="row">
//
//<!-- title column -->
//<div class="col-xl-6 col-lg-4">
//<h5 class="py-4">SKILLS</h5>
//</div>
//
//<!-- content column -->
//<div class="col-xl-6 col-lg-8">
//
//<!-- group -->
//<div class="row">
//<!-- group title -->
//<div class="col-md-3 pt-4 mb-0">
//<p class="opacity-07">Development</p>
//</div>
//<!-- skills list -->
//<div class="col">
//<div class="row">
//<div class="col-4 py-4">HTML</div>
//<div class="col-4 py-4">CSS</div>
//<div class="col-4 py-4">Javascript</div>
//<div class="col-4 py-4">ES6</div>
//<div class="col-4 py-4">React</div>
//<div class="col-4 py-4">Vue</div>
//</div>
//</div>
//</div>
//<!-- /group -->
//
//<hr data-background="#333">
//
//<!-- group -->
//<div class="row">
//<!-- group title -->
//<div class="col-md-3 pt-4 mb-0">
//<p class="opacity-07">Design</p>
//</div>
//<!-- skills list -->
//<div class="col">
//<div class="row">
//<div class="col-4 py-4">UI/UX</div>
//<div class="col-4 py-4">Photoshop</div>
//<div class="col-4 py-4">Sketch</div>
//</div>
//</div>
//</div>
//<!-- /group -->
//
//
//</div>
//
//</div>
//
//</div>