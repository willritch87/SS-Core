package me.syari.ss.core.particle

import me.syari.ss.core.scheduler.CustomScheduler.runListWithDelay
import me.syari.ss.core.scheduler.CustomTask
import org.bukkit.Location
import org.bukkit.entity.Entity

/**
 * [CustomParticle] をまとめたクラス
 */
class CustomParticleList {
    private val listWithDelay = mutableMapOf<Long, MutableSet<CustomParticle>>()
    private var accumulateDelay = 0L

    /**
     * パーティクルを追加します
     * @param particle パーティクル
     */
    fun addParticle(particle: CustomParticle) {
        listWithDelay.getOrPut(accumulateDelay) { mutableSetOf() }.add(particle)
    }

    /**
     * 待機時間を追加します
     * @param delay tick
     */
    fun addDelay(delay: Long) {
        accumulateDelay += delay
    }

    /**
     * 実行します
     * @param run 実行する処理
     */
    private fun run(run: (CustomParticle) -> Unit): Set<CustomTask> {
        return runListWithDelay(listWithDelay, run)
    }

    /**
     * パーティクルを生成します
     * @param location 場所
     */
    fun spawn(location: Location): Set<CustomTask> {
        return run { it.spawn(location) }
    }

    /**
     * パーティクルを生成します
     * @param entity 場所
     */
    fun spawn(entity: Entity): Set<CustomTask> {
        return run { it.spawn(entity) }
    }

    /**
     * 合計待機時間を取得します
     * @return [Long]
     */
    fun getRequireTime(): Long {
        return accumulateDelay
    }
}