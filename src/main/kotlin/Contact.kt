import kotlinx.html.id
import react.*
import react.dom.*

external interface ContactProps : RProps {
    var x: Boolean
}

data class ContactState(val unused: String) : RState

class Contact(props: ContactProps) : RComponent<ContactProps, ContactState>(props) {

    init {
        state = ContactState("xxx")
    }

    override fun RBuilder.render() {
        section("background-fixed") {
            attrs {
                id = "contact"
                //https://pixabay.com/illustrations/network-hug-embrace-man-media-4143317/
                setProp("data-background", "/img/gallery/network-4143317_1280.jpg")
                setProp("data-overlay", "black; .7")
            }
            div("container text-light py-10") {
                div("row no-gutters") {
                    div("col-md-6") {
                        h3("uppercase") { +"Contact" }
                        h6("uppercase mt-6") {
                            +"Let us know ..."
                        }
                        ul("mt-6 ml-6") {
                            li("mt-3") { +"When you want to start your project" }
                            li("mt-3") { +"What type of business you have" }
                            li("mt-3") { +"You business size" }
                        }
                    }
                    div("col-lg-6 align-self-center") {
                        attrs {
                            id = "contact"
                            // https://pixabay.com/illustrations/finger-network-binary-null-one-5848448/
                            setProp("data-background", "#fff8")
                        }
                        iframe() {
                            attrs {
                                src =
                                    "https://docs.google.com/forms/d/e/1FAIpQLScSPAErD4ROD8CburgmBtoaA0wkZYMPPMmE8fF29MOVojzSww/viewform?embedded=true"
                                width = "100%"
                                height = "1332"
                                setProp("frameborder", "0")
                                setProp("marginheight", "0")
                                setProp("marginwidth", "0")
                            }
                            +"Loading ... "
                        }
                    }
                }
            }
        }
    }

}


fun RBuilder.contact(handler: ContactProps.() -> Unit): ReactElement {
    return child(Contact::class) {
        this.attrs(handler)
    }
}
//
//<iframe src="https://docs.google.com/forms/d/e/1FAIpQLScSPAErD4ROD8CburgmBtoaA0wkZYMPPMmE8fF29MOVojzSww/viewform?embedded=true" width="640" height="1332" frameborder="0" marginheight="0" marginwidth="0">Loading…</iframe>

//"""<!-- Contact -->
//		<section id="contact">
//			<div class="container-fluid p-0">
//				<div class="row no-gutters">
//					<div class="col-lg-6">
//
//						<!-- Google Map -->
//						<div class="google-map map-column"
//						     data-api-key=""
//						     data-latitude="41.646845"
//						     data-longitude="41.618846"
//						     data-zoom="13"
//						     data-marker="img/map-marker.png"></div>
//
//					</div>
//					<div class="col-lg-6 align-self-center p-6 p-sm-10">
//
//						<p class="small uppercase">Have A Project?</p>
//						<h2 class="bold">Let's Get In Touch</h2>
//
//						<!-- Form Message -->
//						<div class="mail-form-message d-none mb-5"></div>
//
//						<!-- Contact Form -->
//						<form class="mail-form"
//						      action="php/mail.php"
//						      data-mailto="where_to_send_email@example.com"
//						      data-subject="Torola Subject Line">
//							<input name="name" type="text" placeholder="Name:" required autocomplete="off">
//							<input name="email" type="email" placeholder="Email:" required autocomplete="off">
//							<select name="budget">
//								<option selected disabled>Project Budget</option>
//								<option value="$1000-$2000">$1000-$2000</option>
//								<option value="$2000-$5000">$2000-$5000</option>
//								<option value="$5000-$20000">$5000-$20000</option>
//								<option value="$20000+">$20000+</option>
//							</select>
//							<textarea name="message" placeholder="Message:" required rows="4"></textarea>
//							<button type="submit" class="button style-5 uppercase">send</button>
//						</form>
//						<!-- Contact Form -->
//
//					</div>
//				</div>
//			</div>
//		</section>"""