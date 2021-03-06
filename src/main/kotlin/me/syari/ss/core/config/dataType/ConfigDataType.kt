package me.syari.ss.core.config.dataType

import me.syari.ss.core.config.CustomConfig

/**
 * コンフィグデータタイプ
 * @param T データ型
 */
interface ConfigDataType<T> {
    /**
     * データ型の名前
     */
    val typeName: String

    /**
     * @param config [CustomConfig]
     * @param path コンフィグパス
     * @param notFoundError 存在しないデータの場合にエラーを出す
     */
    fun get(config: CustomConfig, path: String, notFoundError: Boolean): T?

    /**
     * @param config [CustomConfig]
     * @param path コンフィグパス
     * @param notFoundError 存在しないデータの場合にエラーを出す
     * @param default デフォルト値
     */
    fun get(config: CustomConfig, path: String, notFoundError: Boolean, default: T): T {
        return get(config, path, notFoundError) ?: default
    }

    companion object {
        val NUMBER = ConfigNumberDataType
        val INT = ConfigIntDataType
        val LONG = ConfigLongDataType
        val FLOAT = ConfigFloatDataType
        val STRING = ConfigStringDataType
        val STRINGLIST = ConfigStringListDataType
        val BOOLEAN = ConfigBooleanDataType
        val DATE = ConfigDateDataType
        val LOCATION = ConfigLocationDataType
        val MATERIAL = ConfigMaterialDataType
        val PARTICLE = ConfigParticleDataType
        val POTION = ConfigPotionDataType
        val SOUND = ConfigSoundDataType
        val MYSQL = ConfigMySQLDataType
        val SQLITE = ConfigSQLiteDataType
        val DATABASE = ConfigDatabaseDataType
    }
}