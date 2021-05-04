package ru.kartashov.springcourse;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component("musicBean2")
public class ClassicalMusic implements Music {

    public List<String> classicalList = new ArrayList<>(Arrays.asList("ClassicSong1", "ClassicSong2", "ClassicSong3"));

    private ClassicalMusic() {

    }

    public static ClassicalMusic getInstance() {
        return new ClassicalMusic();
    }

    public void doMyInit() {
        System.out.println("My initialization");
    }

    public void doMyDestroy() {
        System.out.println("My destroying");
    }

    @Override
    public String getSong() {
        int randomSong = new Random().nextInt(classicalList.size());
        return classicalList.get(randomSong);
    }
}
