package cloud.deuterium.spock.anime.repository;

import cloud.deuterium.spock.anime.config.RandomService;
import cloud.deuterium.spock.anime.model.Anime;
import org.springframework.stereotype.Repository;

import java.time.Clock;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class AnimeRepository {

    private List<Anime> animes = new ArrayList<>();
    private final Clock clock;
    private final RandomService random;

    public AnimeRepository(Clock clock, RandomService random) {
        this.clock = clock;
        this.random = random;
    }

    public List<Anime> getAll(){
        return animes;
    }

    public Anime get(UUID id){
        return animes.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElse(new Anime());
    }

    public Anime save(Anime anime){
        anime.setId(random.randomUuid());
        anime.setTimestamp(Instant.now(clock));
        animes.add(anime);
        return anime;
    }

    public void delete(UUID id){
        animes = animes.stream()
                .filter(anime -> !anime.getId().equals(id))
                .toList();
    }
}
