package id.neotica.neotiblog.pages.admin

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import id.neotica.neotiblog.util.isUserLoggedIn

@Page("index")
@Composable
fun HomeScreen() {
    isUserLoggedIn { HomePage() }
}

@Composable
fun HomePage() {
    print("Admin HomePage")
}