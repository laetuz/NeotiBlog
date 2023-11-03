package id.neotica.neotiblog.styles

import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.focus
import id.neotica.neotiblog.models.Theme
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val LoginInputStyle by ComponentStyle {
    base {
        Modifier.border(
            width = 2.px,
            style = LineStyle.Solid,
            color = Colors.Transparent,
        )
            .borderRadius(12.px)
            .transition(CSSTransition(property = "border", duration = 300.ms))
    }
    focus {
        Modifier.border(
            width = 4.px,
            style = LineStyle.Solid,
            color = Theme.Primary.rgb
        )
            .borderRadius(12.px)
    }
}