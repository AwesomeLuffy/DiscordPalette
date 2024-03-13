package ca.uqac.lif.cep.io.discordpalette;

import ca.uqac.lif.cep.Connector;
import ca.uqac.lif.cep.functions.ApplyFunction;
import ca.uqac.lif.cep.io.Print;
import ca.uqac.lif.cep.io.discordpalette.discord.util.Users;
import ca.uqac.lif.cep.tmf.Passthrough;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import ca.uqac.lif.cep.io.discordpalette.discord.DiscordPalette;

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

        Print print = new Print();
        ApplyFunction userName = new ApplyFunction(Users.name);
        ApplyFunction selfUser = new ApplyFunction(discordPalette.selfUser);
        Passthrough passthrough = new Passthrough();

        Connector.connect(passthrough, 0, selfUser, 0);
        Connector.connect(selfUser, 0, userName, 0);
        Connector.connect(userName, 0, print, 0);

        passthrough.getPushableInput().push(1);

    }
}