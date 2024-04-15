package ca.uqac.lif.cep.discordpalette;

import ca.uqac.lif.cep.Connector;
import ca.uqac.lif.cep.Processor;
import ca.uqac.lif.cep.discordpalette.discord.DiscordPalette;
import ca.uqac.lif.cep.discordpalette.discord.Processor.DiscordMessageReader;
import ca.uqac.lif.cep.io.Print;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main {
    public static void main(String[] args) {
        System.out.println("This is a Palette for Discord Bot, it is not meant to be run as a standalone application.");
        System.exit(0);
    }
}