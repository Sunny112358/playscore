package com.sunny.playscore.model

/**
 * Created by sunny on 5/3/18.
 */


@TypeAlias("player")
data class Player(@Id val handle: String,
                  val totalScore: Int = 0,
                  val history: List<ScoreEvent> = listOf()) {
    operator fun plus(score: Int) =
            Player(handle, totalScore + score, history + ScoreEvent(score))
}

data class ScoreEvent(val time: String,
                      val points: Int) {
    constructor(points: Int) : this(dateFormat.format(Date()), points)

    companion object {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    }
}