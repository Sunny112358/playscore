package com.sunny.playscore.service

/**
 * Created by sunny on 5/3/18.
 */

interface PlayerService {
    fun leaders() : List<Player>
    fun score(handle: String, points: Int) : Int
}

@Service("playerService")
class PlayerServiceImpl : PlayerService {
    @Autowired
    lateinit var playerRepository: PlayerRepository

    override fun leaders(): List<Player> =
            playerRepository.findTop3ByOrderByTotalScoreDesc()

    override fun score(handle: String, points: Int) : Int {
        val player = playerRepository
                .findById(handle).orElse(Player(handle))
        + points
        playerRepository.save(player)
        return player.totalScore
    }
}