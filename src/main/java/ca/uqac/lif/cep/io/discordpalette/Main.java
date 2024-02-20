package ca.uqac.lif.cep.io.discordpalette;

import ca.uqac.lif.cep.Connector;
import ca.uqac.lif.cep.Processor;
import ca.uqac.lif.cep.io.Print;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import ca.uqac.lif.cep.io.discordpalette.beepbeep.DiscordPalette;

public class Main {
    private static final String token = "NjQ2NzUwNzU4MTc5NDM4NTkz.GehI_Z.4PBY9XmZtusKX6Vty8EIaDXos8-yWqSsR_p55g";
    public static void main(String[] args) {
        System.out.println("This JAR file is not meant to be run from the command line");
        Main.initialize();
    }

    private static void initialize(){
        JDA jdaBuilder = JDABuilder.createDefault(Main.token)
                .setActivity(Activity.watching("Playing with Lego"))
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();

        DiscordPalette discordPalette = DiscordPalette.getInstance(jdaBuilder);

        Processor discordMessageReader = discordPalette.getDiscordMessageReader();

        Print print = new Print();

        Connector.connect(discordMessageReader, 0, print, 0);
    }
}