package me.syari.ss.core.scoreboard

import me.syari.ss.core.code.StringEditor.toColor
import me.syari.ss.core.player.UUIDPlayer
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scoreboard.DisplaySlot

data class CustomScoreBoard(
    private val plugin: JavaPlugin,
    private val title: String,
    val priority: ScoreBoardPriority
) : CustomScoreBoardEdit {
    private val lineList = mutableMapOf<Int, ScoreBoardLine>()

    private var lineIndex = 0

    override fun line(text: String) {
        lineList[lineIndex] = ScoreBoardLine.Constant(text)
        lineIndex--
    }

    override fun line(text: Player.() -> String) {
        lineList[lineIndex] = ScoreBoardLine.Invoke(text)
        lineIndex--
    }

    fun addPlayer(vararg players: Player) {
        players.forEach { ScoreBoardPlayer.addBoard(UUIDPlayer(it), this) }
    }

    fun removePlayer(vararg players: Player) {
        players.forEach { ScoreBoardPlayer.removeBoard(UUIDPlayer(it), this) }
    }

    fun show(scoreBoardPlayer: ScoreBoardPlayer) {
        val uuidPlayer = scoreBoardPlayer.uuidPlayer
        val player = uuidPlayer.player ?: return
        val board = plugin.server.scoreboardManager.newScoreboard
        val objective = board.registerNewObjective(uuidPlayer.toString().substring(0 until 16), "dummy", title.toColor)
        objective.displaySlot = DisplaySlot.SIDEBAR
        var count = 0
        lineList.forEach { (index, text) ->
            objective.getScore((text.get(player) + "&" + "%x".format(count)).toColor).score = index
            count++
        }
        val scoreboard = objective.scoreboard
        if (scoreboard != null && player.scoreboard.entries != scoreboard.entries) player.scoreboard = scoreboard
    }
}
