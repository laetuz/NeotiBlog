package id.neotica.neotiblog.models

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb

enum class Theme(
    val hex: String,
    val rgb: CSSColorValue
) {
    PrimaryLegacy(
        hex = "#00A2FF",
        rgb = rgb(0, 162,255,)
    ),
    LightGray(
        hex = "#FAFAFA",
        rgb = rgb(250, 250,250,)
    ),
    Primary(
        hex = "#4D6EAA",
        rgb = rgb(77, 110,170,)
    ),
    Secondary(
        hex = "#232850",
        rgb = rgb(35, 40,80,)
    ),
    PrimaryBackground(
        hex = "#070D2D",
        rgb = rgb(7, 13,45,)
    )
}