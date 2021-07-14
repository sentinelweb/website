import react.*
import react.dom.a
import react.dom.div
import react.dom.h6
import react.dom.i

external interface BlogNavProps : RProps {
    var nextTitle: String
    var prevTitle: String
    var nextTarget: String?
    var prevTarget: String?
}

class BlogNav(props: BlogNavProps) : RComponent<BlogNavProps, RState>(props) {


    override fun RBuilder.render() {
        div("project-nav") {
            div("col-6") {
                a(href = props.prevTarget ?: "#", classes = props.prevTarget?.let { "" } ?: "disabled") {
                    i("fa fa-long-arrow-left opacity-03") {}
                    h6 { +props.prevTitle }
                }
            }
            div("col-6") {
                a(href = props.nextTarget ?: "#", classes = props.nextTarget?.let { "" } ?: "disabled") {
                    i("fa fa-long-arrow-right opacity-03") {}
                    h6 { +props.nextTitle }
                }
            }
        }
    }

}

fun RBuilder.blogNav(handler: BlogNavProps.() -> Unit): ReactElement {
    return child(BlogNav::class) {
        this.attrs(handler)
    }
}

//"""<div class="project-nav">
//			<div class="col-6">
//				<a href="#" class="disabled">
//					<i class="fa fa-long-arrow-left opacity-03"></i>
//					<h6>Newer Posts</h6>
//				</a>
//			</div>
//			<div class="col-6">
//				<a href="#">
//					<i class="fa fa-long-arrow-right opacity-03"></i>
//					<h6>Older Posts</h6>
//				</a>
//			</div>
//		</div>"""