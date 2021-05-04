package ru.kartashov.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MusicPlayer {

    public Music classicalMusic;
    public Music rockMusic;

    private String name;
    private int volume;

/*    public List<Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public String getName() {
        return name;
    }

    private List<Music> musicList = new ArrayList<>();

    public void setName(String name) {

        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    */
    public MusicPlayer() {
    }

    @Autowired
    public MusicPlayer(@Qualifier("musicBean1") Music rock,
                       @Qualifier("musicBean2") Music classic) {
        this.rockMusic = rock;
        this.classicalMusic = classic;
    }

    public void playMusic(StyleMusic styleMusic) throws Exception {
        if (styleMusic.equals(StyleMusic.CLASSICAL)) {
            System.out.println("Random song is: " + classicalMusic.getSong());
        } else if (styleMusic.equals(StyleMusic.ROCK)) {
            System.out.println("Random song is: " + rockMusic.getSong());
        } else {
            throw new Exception("something went wrong");
        }
    }
}
