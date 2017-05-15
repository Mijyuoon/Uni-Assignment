package uni.dbstuff

import io.ebean.Ebean
import uni.dbstuff.views.AppMainView
import tornadofx.*
import java.util.*

/**
 * Точка входа в приложение.
 */
class Application : App(AppMainView::class) {
    companion object {
        /**
         * Локаль приложения
         */
        val appLocale = Locale("ru")

        /**
         * Набор строк локализации
         */
        val localeProps = ResourceBundle.getBundle("uni.dbstuff.Language", appLocale)
    }

    /**
     * Главный инициализатор
     */
    init {
        Locale.setDefault(appLocale)
        FX.messages = localeProps
        importStylesheet("/uni/dbstuff/MainStyles.css")
        Ebean.getDefaultServer()
    }
}