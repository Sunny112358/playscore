package com.sunny.playscore.repository

/**
 * Created by sunny on 5/3/18.
 */
interface PlayerRepository : CrudRepository<Player, String> {
    fun findTop3ByOrderByTotalScoreDesc() : List<Player>
}