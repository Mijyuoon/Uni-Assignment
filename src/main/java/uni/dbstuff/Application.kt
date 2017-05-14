package uni.dbstuff

import io.ebean.Ebean
import uni.dbstuff.views.AppMainView
import tornadofx.*
import java.util.*

class Application : App(AppMainView::class) {
    companion object {
        val appLocale = Locale("en")
        val localeProps = ResourceBundle.getBundle("uni.dbstuff.Language", appLocale)
    }

    init {
        Locale.setDefault(appLocale)
        FX.messages = localeProps
        importStylesheet("/uni/dbstuff/MainStyles.css")
        Ebean.getDefaultServer()
    }
}