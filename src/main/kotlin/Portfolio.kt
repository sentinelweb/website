import kotlinx.html.P
import kotlinx.html.id
import kotlinx.html.title
import react.*
import react.dom.*

external interface PortfolioProps : RProps {
    var x: Boolean
}

class Portfolio(props: PortfolioProps) : RComponent<PortfolioProps, RState>(props) {

    override fun RBuilder.render() {
        section {
            attrs { id = "portfolio" }
            div("container py-10") {
                p("text-links small uppercase opacity-09 mb-6") {
                    attrs { id = "folioFilter" }
                    filterItem("*", "All")
                    filterItem(".mobile","Mobile")
                    filterItem(".web","Web")
                    filterItem(".external","External")
                    filterItem(".internal","Project")
                }
                div("grid lightbox") {
                    attrs {
                        setProp("data-columns", "5")
                        setProp("data-gutter", "50")
                        setProp("data-cell-ratio", "5/5")
                        setProp("data-filter", "#folioFilter")
                    }
                    portfolioItem {
                        categories = "mobile external"
                        title = "Trainline"
                        tall = true
                        wide = true
                        backgroundUrl = "img/portfolio/trainline-app-logo.png"
                        detailUrl = "img/portfolio/trainline-app-detail.png"
                        description = "Trainline is the UK #1 travel app"
                        links = listOf(
                            "Website" to "https://www.thetrainline.com",
                            "Play Store" to "https://play.google.com/store/apps/details?id=com.thetrainline",
                            "Play Store EU" to "https://play.google.com/store/apps/details?id=com.capitainetrain.android"
                        )
                    }
                    portfolioItem {
                        categories = "mobile web external"
                        title = "Depop"
                        tall = true
                        wide = true
                        backgroundUrl = "img/portfolio/depop-app-logo.png"
                        description = ""
                        links = listOf(
                            "Website" to "https://www.depop.com",
                            "Play Store" to "https://play.google.com/store/apps/details?id=com.depop"
                        )
                    }

                    portfolioItem {
                        categories = "mobile external"
                        title = "Waracle"
                        wide = true
                        backgroundUrl = "img/portfolio/waracle-logo.png"
                        description = ""
                        links = listOf(
                            "Website" to "https://waracle.com/industries/digital-health/",
                            "Article" to "https://www.syneoshealthcommunications.com/blog/roches-floodlight-a-multiple-sclerosis-game-changer"
                        )
                    }

                    portfolioItem {
                        categories = "web external"
                        title = "PWC"
                        wide = true
                        backgroundUrl = "img/portfolio/pwc-logo.jpg"
                        description = "eGFS System"
                        links = listOf(
                            "Website" to "https://www.pwc.com/"
                        )
                    }

                    portfolioItem {
                        categories = "web external"
                        title = "Deloitte"
                        wide = true
                        backgroundUrl = "img/portfolio/deloitte-logo.png"
                        description = "Sapphire System"
                        links = listOf(
                            "Website" to "https://www.deloitte.com/"
                        )
                    }

                    portfolioItem {
                        categories = "mobile external"
                        title = "Bighand"
                        backgroundUrl = "img/portfolio/bighand-app-logo.png"
                        detailUrl = "img/portfolio/bighand-app-detail.png"
                        description = "Voice-recording and task management"
                        links = listOf(
                            "Website" to "https://www.thetrainline.com",
                            "Play Store" to "https://play.google.com/store/apps/details?id=com.bighand.android"
                        )
                    }

                    portfolioItem {
                        categories = "mobile external"
                        title = "MGM Sports betting"
                        backgroundUrl = "img/portfolio/mgm-app-logo.png"
                        detailUrl = "img/portfolio/mgm-app-detail.webp"
                        description = "Sports betting for the US market - not on play store"
                        links = listOf(
                            "Website" to "https://promo.nj.betmgm.com/en/promo/geolocator?orh=sports.betmgm.com"
                        )
                    }

                    portfolioItem {
                        categories = "web external"
                        title = "Jaeger Le Coultre"
                        wide = true
                        backgroundUrl = "img/portfolio/jlc-logo.svg"
                        detailUrl = "img/portfolio/jlc-logo-watch-detail.webp"
                        description = "Jaeger Le Coultre watches website"
                        links = listOf(
                            "Website" to "https://www.jaeger-lecoultre.com/"
                        )
                    }

                    portfolioItem {
                        categories = "web external"
                        title = "Capita"
                        wide = true
                        backgroundUrl = "img/portfolio/capita-logo.png"
                        description = "Capita HR system"
                        links = listOf(
                            "Website" to "https://www.capita.com/"
                        )
                    }

                    portfolioItem {
                        categories = "mobile external"
                        title = "Pickle Jobs"
                        backgroundUrl = "img/portfolio/pickle-app-logo.png"
                        detailUrl = "img/portfolio/pickle-app-detail.png"
                        description = "A social jobs application - we worked on app data networking layer"
                        links = listOf(
                            "Website" to "https://pickle.app/",
                            "App" to "https://play.google.com/store/apps/details?id=com.wearepickle.pickle"
                        )
                    }

                    portfolioItem {
                        categories = "mobile internal"
                        title = "MyPod"
                        backgroundUrl = "img/portfolio/mypod-app-logo.png"
                        detailUrl = "img/portfolio/mypod-app-detail.png"
                        description = "Podcasting application"
                        links = listOf(
                            "App" to "https://play.google.com/store/apps/details?id=co.uk.sentinelweb.mypod.v2",
                            "V1 App" to "https://play.google.com/store/apps/details?id=org.my_pod.mypod"
                        )
                    }

                    portfolioItem {
                        categories = "mobile web internal"
                        title = "Cuer"
                        backgroundUrl = "img/portfolio/cuer-app-logo.svg"
                        detailUrl = "img/portfolio/cuer-app-detail.png"
                        description = "Better playlists for your well-being"
                        links = listOf(
                            "Website" to "https://cuer.app"
                        )
                    }

                    portfolioItem {
                        categories = "mobile internal"
                        title = "SuprCards"
                        backgroundUrl = "img/portfolio/suprcards-app-logo.png"
                        description = "Vector drawing application"
                        links = listOf(
                            "App" to "https://play.google.com/store/apps/details?id=co.uk.sentinelweb.cards"
                        )
                    }

                    portfolioItem {
                        categories = "mobile internal"
                        title = "PureFlow"
                        backgroundUrl = "img/portfolio/pureflow-app-logo.png"
                        description = "Art / Sound application"
                        links = listOf(
                            "App" to "https://play.google.com/store/apps/details?id=com.katyconnor.pureflow"
                        )
                    }

                    portfolioItem {
                        categories = "mobile internal"
                        title = "Silent mode timer"
                        backgroundUrl = "img/portfolio/silent-timer-app-logo.png"
                        description = "Utilities"
                        links = listOf(
                            "App" to "https://play.google.com/store/apps/details?id=co.uk.sentinelweb.silenttimer"
                        )
                    }

                    portfolioItem {
                        categories = "mobile internal"
                        title = "ReMeme"
                        backgroundUrl = "img/portfolio/rememe-app-logo.png"
                        detailUrl = "img/portfolio/rememe-app-detail.png"
                        description = "Meme creation application"
                        links = listOf(
                            "App" to "https://play.google.com/store/apps/details?id=org.rememe"
                        )
                    }

                }
            }
        }
    }

    private fun RDOMBuilder<P>.filterItem(target: String, text: String) {
        a(href = "#") {
            attrs { setProp("data-filter", target) }
            +text
        }
    }
}

fun RBuilder.portfolio(handler: PortfolioProps.() -> Unit): ReactElement {
    return child(Portfolio::class) {
        this.attrs(handler)
    }
}

external interface PortfolioItemProps : RProps {
    var categories: String?
    var tall: Boolean
    var wide: Boolean
    var backgroundUrl: String
    var detailUrl: String?
    var title: String
    var description: String?
    var links: List<Pair<String, String>>
}

private class PortfolioItem(props: PortfolioItemProps) : RComponent<PortfolioItemProps, RState>(props) {


    override fun RBuilder.render() {
        figure(
            "portfolio-item "
                    + (if (props.wide) "wide " else "")
                    + (if (props.tall) "tall " else "")
                    + (props.categories ?: "")
        ) {
            attrs {
                setProp("data-background", props.backgroundUrl)
            }
            props.detailUrl?.apply {
                a(href = this, classes = "lightbox-link") {
                    attrs { title = props.title }
                }
            }
            figcaption {
                h5("item-title") {
                    a(href = props.links.takeIf { it.isNotEmpty() }?.get(0)?.second, target = "_blank") {
                        +props.title
                    }
                }
                props.description?.let {
                    p("item-description") {
                        +it
                    }
                }
                props.links
                    .takeIf { it.isNotEmpty() }
                    ?.apply {
                        p("text-links") {
                            forEach {
                                a(href = it.second, target = "_blank") {
                                    +it.first
                                }
                            }
                        }
                    }
            }

        }
    }

}


private fun RBuilder.portfolioItem(handler: PortfolioItemProps.() -> Unit): ReactElement {
    return child(PortfolioItem::class) {
        this.attrs(handler)
    }
}