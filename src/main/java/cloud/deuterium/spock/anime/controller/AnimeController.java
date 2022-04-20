package cloud.deuterium.spock.anime.controller;

import cloud.deuterium.spock.anime.model.Anime;
import cloud.deuterium.spock.anime.service.AnimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/animes")
public class AnimeController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping
    public ResponseEntity<List<Anime>> getAllAnimes(){
        log.info("GET request -> getAllAnimes");
        List<Anime> animes = animeService.getAllAnimes();
        return ResponseEntity.ok(animes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anime> getAnimeById(@PathVariable UUID id){
        log.info("GET request -> getAnimeById {}", id);
        Anime anime = animeService.getAnimeById(id);
        return ResponseEntity.ok(anime);
    }

    @PostMapping
    public ResponseEntity<Anime> saveNewAnime(@RequestBody Anime anime){
        log.info("Post request -> saveNewAnime {}", anime);
        Anime savedAnime = animeService.saveAnime(anime);
        return ResponseEntity.ok(savedAnime);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimeById(@PathVariable UUID id){
        log.info("DELETE request -> deleteAnimeById {}", id);
        animeService.deleteAnime(id);
        return ResponseEntity.noContent().build();
    }


}
