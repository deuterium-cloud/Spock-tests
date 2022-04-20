package cloud.deuterium.spock.anime.service;


import cloud.deuterium.spock.anime.model.Anime;

import java.util.List;
import java.util.UUID;

public interface AnimeService {

    List<Anime> getAllAnimes();

    Anime getAnimeById(UUID id);

    Anime saveAnime(Anime anime);

    void deleteAnime(UUID id);
}
