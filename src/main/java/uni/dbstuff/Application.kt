package uni.dbstuff

import io.ebean.Ebean
import uni.dbstuff.views.AppMainView
import tornadofx.*
import java.util.*

class Application : App(AppMainView::class) {
    companion object {
        val localeProps: ResourceBundle = ResourceBundle.getBundle("uni.dbstuff.Language", Locale("en"))
    }

    init {
        FX.messages = localeProps
        importStylesheet("/uni/dbstuff/MainStyles.css")
    }
}