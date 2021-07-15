import react.*

external interface TemplateProps : RProps {
    var x: Boolean
}

data class TemplateState(val unused: String) : RState

class Template(props: TemplateProps) : RComponent<TemplateProps, TemplateState>(props) {

    init {
        state = TemplateState("xxx")
    }

    override fun RBuilder.render() {

    }

}

fun RBuilder.template(handler: TemplateProps.() -> Unit): ReactElement {
    return child(Template::class) {
        this.attrs(handler)
    }
}