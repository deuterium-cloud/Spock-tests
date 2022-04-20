package cloud.deuterium.spock.anime.service;

import cloud.deuterium.spock.anime.model.Anime;
import cloud.deuterium.spock.anime.repository.AnimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AnimeServiceImpl implements AnimeService{

    private final AnimeRepository animeRepository;

    public AnimeServiceImpl(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    @Override
    public List<Anime> getAllAnimes() {
        return animeRepository.getAll();
    }

    @Override
    public Anime getAnimeById(UUID id) {
        return animeRepository.get(id);
    }

    @Override
    public Anime saveAnime(Anime anime) {
        return animeRepository.save(anime);
    }

    @Override
    public void deleteAnime(UUID id) {
        animeRepository.delete(id);
    }
}
