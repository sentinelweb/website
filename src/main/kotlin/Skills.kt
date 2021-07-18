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
                setProp("data-background", "img/gallery/archer-2345211_1280.jpg")
                setProp("data-overlay", "black; .6")
            }
            div("container text-light py-10") {
                div("row") {
                    div("col-xl-3 col-lg-4") {
                        h4("mt-4") { +"Skills" }
                    }
                    div("col-xl-9 col-lg-8") {
                        skillGroup {
                            title = "Development"
                            list =
                                listOf("Kotlin Multi-Platform", "Android", "iOS", "HTML / CSS / JS", "Node JS", "React")
                        }
                        hr("mb-3") { attrs { setProp("data-background", "#444") } }
                        skillGroup {
                            title = "Devops"
                            list = listOf(
                                "Gradle",
                                "Unit testing",
                                "UI Testing",
                                "Database",
                                "Continuous Integration",
                                "Deployment",
                                "Firebase",
                                "AWS"
                            )
                        }
                        hr("mb-3") { attrs { setProp("data-background", "#444") } }
                        skillGroup {
                            title = "Design"
                            list = listOf(
                                "User Experience",
                                "User Interface",
                                "Photoshop",
                                "Illustrator",
                                "Prototyping",
                                "User Testing"
                            )
                        }
                        hr("mb-3") { attrs { setProp("data-background", "#444") } }
                        skillGroup {
                            title = "Process"
                            list = listOf(
                                "Agile",
                                "Scrum",
                                "Kanban",
                                "Continuous Development",
                                "XP/Pair Programming",
                                "Feature Driven Development",
                                "Behaviour Driven Development",
                                "Test Driven Development",
                                "Continuous Delivery"
                            )
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
                    props.list.forEach { text ->
                        div("col-4 py-4") {
                            +text
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