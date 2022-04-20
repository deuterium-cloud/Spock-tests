package cloud.deuterium.spock.anime.config;

import cloud.deuterium.spock.anime.model.Anime;
import cloud.deuterium.spock.anime.repository.AnimeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class InsertInitialData implements CommandLineRunner {

    private final AnimeRepository animeRepository;

    public InsertInitialData(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of(new Anime(null, "Berserk", 45, null),
                        new Anime(null, "Basilisk", 24, null),
                        new Anime(null, "Death Note", 24, null),
                        new Anime(null, "Fullmetal Alchemist", 51, null))
                .forEach(animeRepository::save);
    }
}
