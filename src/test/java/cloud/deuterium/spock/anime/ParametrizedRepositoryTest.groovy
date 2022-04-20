package cloud.deuterium.spock.anime

import cloud.deuterium.spock.anime.config.RandomService
import cloud.deuterium.spock.anime.model.Anime
import cloud.deuterium.spock.anime.repository.AnimeRepository
import spock.lang.Specification

import java.time.Clock

/**
 * Created by Milan Stojkovic 20-Apr-2022
 */
class ParametrizedRepositoryTest extends Specification {

    AnimeRepository animeRepository = new AnimeRepository(Clock.systemDefaultZone(), new RandomService())

    def "should add new Anime to the Database"() {

        animeRepository.save(new Anime(null, "Death note", 24, null))

        expect: "Should expect one Anime"
        animeRepository.getAll().size() == 1
    }

    def "should add new Anime with name: #name to the Database"() {

        when:
        animeRepository.save(new Anime(null, name, episodes, null))

        then:
        Anime anime = animeRepository.getAll().stream()
                .filter(a -> a.getName() == name)
                .findFirst().get()
        anime.getName() == name
        anime.getEpisodes() == episodes

        where:
        name         | episodes
        "Berserk"    | 24
        "Basilisk"   | 34
        "Death note" | 44
    }


}
