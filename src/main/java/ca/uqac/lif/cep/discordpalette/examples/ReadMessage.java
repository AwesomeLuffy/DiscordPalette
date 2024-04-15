package ca.uqac.lif.cep.discordpalette.examples;

import ca.uqac.lif.cep.Connector;
import ca.uqac.lif.cep.Processor;
import ca.uqac.lif.cep.discordpalette.discord.DiscordPalette;
import ca.uqac.lif.cep.discordpalette.discord.utils.Messages;
import ca.uqac.lif.cep.functions.ApplyFunction;
import ca.uqac.lif.cep.io.Print;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class ReadMessage {
    public static void main(String[] args) {
        // The token is the key to connect to the Discord API
        String token = "YOUR_TOKEN_HERE";

        // Create a new JDA object (it's the instance of our bot)
        JDA discordBot = JDABuilder.createDefault(token)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();

        // Create a new DiscordPalette object to interact with BeepBeep
        DiscordPalette palette = DiscordPalette.getInstance(discordBot);

        // Then get the processor to read messages
        Processor reader = palette.getDiscordMessageReader();

        // We get a function processor to only get the content of the message
        ApplyFunction getMessageContentFunction = new ApplyFunction(Messages.content);

        // Now we simply create a Print processor to show the messages from Discord
        Print print = new Print();

        // Connect the reader to the getMessageContentFunction
        Connector.connect(reader, getMessageContentFunction);

        // Connect the getMessageContentFunction to the print processor
        Connector.connect(getMessageContentFunction, print);
    }
}
