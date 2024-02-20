package org.example;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
    private static final String token = "";
    public static void main(String[] args) {
        JDA jdaBuilder = JDABuilder.createDefault(Main.token)
                .setActivity(Activity.watching("Playing with Lego"))
                .build();
    }
}