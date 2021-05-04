package ru.kartashov.springcourse;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:musicPlayer.properties")
@ComponentScan("ru.kartashov.springcourse")
public class ConfigClass {

}
