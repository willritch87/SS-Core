package me.syari.ss.core.sound

import org.bukkit.Location
import org.bukkit.Sound
import org.bukkit.SoundCategory

object CreateSound {
    /**
     * CustomSound を作成します
     * @param type サウンドタイプ
     * @param volume 音量
     * @param pitch 高さ
     * @param category サウンドカテゴリー default: MASTER
     * @return [CustomSound]
     */
    fun sound(type: Sound, volume: Float, pitch: Float, category: SoundCategory = SoundCategory.MASTER): CustomSound {
        return CustomSound(type, volume, pitch, category)
    }

    /**
     * サウンドを再生します
     * @param location 場所
     * @param type サウンドタイプ
     * @param volume 音量
     * @param pitch 高さ
     * @param category サウンドカテゴリー default: MASTER
     */
    fun playSound(
        location: Location,
        type: Sound,
        volume: Float,
        pitch: Float,
        category: SoundCategory = SoundCategory.MASTER
    ) {
        sound(type, volume, pitch, category).play(location)
    }
}