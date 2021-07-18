@file:JsModule("react-share")
@file:JsNonModule

import react.RClass
import react.RProps

@JsName("EmailIcon")
external val emailIcon: RClass<IconProps>

@JsName("EmailShareButton")
external val emailShareButton: RClass<EmailButtonProps>

@JsName("TelegramIcon")
external val telegramIcon: RClass<IconProps>

@JsName("TelegramShareButton")
external val telegramShareButton: RClass<ShareTitleButtonProps>

@JsName("TwitterIcon")
external val twitterIcon: RClass<IconProps>

@JsName("TwitterShareButton")
external val twitterShareButton: RClass<TwitterButtonProps>

@JsName("WhatsappIcon")
external val whatsappIcon: RClass<IconProps>

@JsName("WhatsappShareButton")
external val whatsappShareButton: RClass<ShareTitleButtonProps>

@JsName("FacebookIcon")
external val facebookIcon: RClass<IconProps>

@JsName("FacebookShareButton")
external val facebookShareButton: RClass<FacebookButtonProps>

@JsName("LinkedinIcon")
external val linkedinIcon: RClass<IconProps>

@JsName("LinkedinShareButton")
external val linkedinShareButton: RClass<LinkedInButtonProps>

@JsName("PinterestIcon")
external val pinterestIcon: RClass<IconProps>

@JsName("PinterestShareButton")
external val pinterestShareButton: RClass<PinterestButtonProps>

@JsName("RedditIcon")
external val redditIcon: RClass<IconProps>

@JsName("RedditShareButton")
external val redditShareButton: RClass<ShareTitleButtonProps>

@JsName("PocketIcon")
external val pocketIcon: RClass<IconProps>

@JsName("PocketShareButton")
external val pocketShareButton: RClass<ShareTitleButtonProps>

external interface ShareButtonProps : RProps {
    var url: String
}

external interface EmailButtonProps : ShareButtonProps {
    var subject: String
    var body: String
}

external interface PinterestButtonProps : ShareButtonProps {
    var media: String // imgUrl - required
    var description: String?
}

external interface FacebookButtonProps : ShareButtonProps {
    var quote: String
    var hashtag: String?
}

external interface ShareTitleButtonProps : ShareButtonProps {
    var title: String
}

external interface LinkedInButtonProps : ShareTitleButtonProps {
    var summary: String
    var source: String // website
}

external interface TwitterButtonProps : ShareTitleButtonProps {
    var via: String // website
    var hashtags: Array<String> // List of hashtags
//    var related: List<String>? // list of accounts
}

external interface IconProps : RProps {
    var size: Int
    var round: Boolean
    var borderRadius: Int
    var bgStyle: String // fill
    var iconFillColor: String // web color


}