package cloud.deuterium.spock.anime.dto;

import java.time.Instant;
import java.util.UUID;

public class AnimeDto {
    UUID id;
    String name;
    int episodes;
    Instant timestamp;

    public AnimeDto() {
    }

    public AnimeDto(UUID id, String name, int episodes, Instant timestamp) {
        this.id = id;
        this.name = name;
        this.episodes = episodes;
        this.timestamp = timestamp;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}
