package ru.kartashov.springcourse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


@Component("musicBean1")
//@Scope("prototype")
public class RockMusic implements Music {
    public List<String> rockList =  new ArrayList<>(Arrays.asList("RockSong1", "RockSong2", "RockSong3"));

    @Override
    public String getSong() {
        int randomIndex = new Random().nextInt(rockList.size());
        return rockList.get(randomIndex);
    }
}
