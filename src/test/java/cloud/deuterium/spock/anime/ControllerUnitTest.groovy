package cloud.deuterium.spock.anime

import cloud.deuterium.spock.anime.controller.AnimeController
import cloud.deuterium.spock.anime.model.Anime
import cloud.deuterium.spock.anime.service.AnimeService
import spock.lang.Specification

import java.time.Instant

/**
 * Created by Milan Stojkovic 20-Apr-2022
 */
class ControllerUnitTest extends Specification {

    def animeService = Mock(AnimeService)
    def animeController = new AnimeController(animeService)

    def "should return Anime with given UUID"() {

        animeService.getAnimeById(_ as UUID) >> new Anime(
                UUID.fromString("a39927d5-7b51-4ece-893e-ee71ff4c7b75"),
                "Berserk",
                24,
                Instant.parse("2022-02-02T12:00:00.0001Z")
        )

        expect:
        Anime response = animeController.getAnimeById(UUID.fromString("a39927d5-7b51-4ece-893e-ee71ff4c7b75")).body
        response.name == "Berserk"
        response.episodes == 24
    }
}
