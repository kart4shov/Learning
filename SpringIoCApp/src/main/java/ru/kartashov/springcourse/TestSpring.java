package ru.kartashov.springcourse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
/*
        Music rockMusic = context.getBean("musicBean", Music.class);
        System.out.println(rockMusic.getSong());
        Music classicalMusic = context.getBean("classicalMusic", Music.class);
        System.out.println(classicalMusic.getSong());
*/
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        try {
            musicPlayer.playMusic(StyleMusic.CLASSICAL);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        context.close();
    }
}
