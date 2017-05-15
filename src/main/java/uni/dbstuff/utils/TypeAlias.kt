package uni.dbstuff.utils

/**
 * Функция дополнительной проверки ошибок
 */
typealias ErrorFunc<T> = (T) -> Boolean

/**
 * Функция обработчика события с параметром
 */
typealias ActionFunc<T> = (T) -> Unit