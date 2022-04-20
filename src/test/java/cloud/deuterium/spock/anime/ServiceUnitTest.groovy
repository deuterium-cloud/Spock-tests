package cloud.deuterium.spock.anime

import cloud.deuterium.spock.anime.model.Anime
import cloud.deuterium.spock.anime.repository.AnimeRepository
import cloud.deuterium.spock.anime.service.AnimeService
import cloud.deuterium.spock.anime.service.AnimeServiceImpl
import spock.lang.Specification

import java.time.Instant

/**
 * Created by Milan Stojkovic 20-Apr-2022
 */
class ServiceUnitTest extends Specification {

    def "Should call Repository and return List of Animes"() {

        given:
        AnimeRepository repository = Mock()
        AnimeService animeService = new AnimeServiceImpl(repository)
        repository.getAll() >> List.of()

        when:
        List<Anime> animes = animeService.getAllAnimes()

        then:
        animes.size() == 0

    }

    def "Should call Repository and return Anime with given UUID"() {

        given:
        AnimeRepository repository = Mock()
        AnimeService animeService = new AnimeServiceImpl(repository)
        repository.get(_ as UUID) >> new Anime(
                UUID.fromString("d634fadb-3cf8-416a-a794-05221da99ec5"),
                "Basilisk",
                24,
                Instant.parse("2022-02-02T12:00:00.0001Z")
        )

        when:
        Anime anime = animeService.getAnimeById(UUID.fromString("d634fadb-3cf8-416a-a794-05221da99ec5"))

        then:
        verifyAll(anime) {
            id == UUID.fromString("d634fadb-3cf8-416a-a794-05221da99ec5")
            name == "Basilisk"
            episodes == 24
            timestamp == Instant.parse("2022-02-02T12:00:00.0001Z")
        }
    }

    def "Should delete Anime with provided UUID"() {

        given:
        AnimeRepository repository = Mock()
        AnimeService animeService = new AnimeServiceImpl(repository)

        when:
        animeService.deleteAnime(UUID.fromString("d634fadb-3cf8-416a-a794-05221da99ec5"))

        then: "Call delete method only once"
        1 * repository.delete(_ as UUID)
    }

}
