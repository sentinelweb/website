import kotlinx.html.id
import react.*
import react.dom.a
import react.dom.attrs
import react.dom.div
import react.dom.small
import react.dom.footer

external interface FooterProps : RProps {
    var x: Boolean
}

class Footer(props: FooterProps) : RComponent<FooterProps, RState>(props) {

    override fun RBuilder.render() {
        footer {
            attrs {
                id = "footer"
            }
            small { +"© Copyright Sentinel Web Technologies Ltd, 2021" }
            div("small text-links") {
                a(href = "/privacy.html") { +"Privacy" }
                a(href = "https://github.com/sentinelweb", target = "_blank") { +"Github" }
                a(href = "https://twitter.com/sentinelwebtech", target = "_blank") { +"Twitter" }
                a(href = "https://play.google.com/store/apps/developer?id=Sentinel+Web+Technologies", target = "_blank") { +"Google play" }
                a(href = "mailto://sentinelwebtechnologies@gmail.com") { +"Email" }
            }
        }

    }
}


fun RBuilder.footer(handler: FooterProps.() -> Unit): ReactElement {
    return child(Footer::class) {
        this.attrs(handler)
    }
}