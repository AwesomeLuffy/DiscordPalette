package ca.uqac.lif.cep.discordpalette.examples;

import ca.uqac.lif.cep.Connector;
import ca.uqac.lif.cep.Processor;
import ca.uqac.lif.cep.discordpalette.discord.DiscordPalette;
import ca.uqac.lif.cep.discordpalette.discord.utils.Guilds;
import ca.uqac.lif.cep.discordpalette.discord.utils.Members;
import ca.uqac.lif.cep.discordpalette.discord.utils.MessageChannels;
import ca.uqac.lif.cep.discordpalette.discord.utils.Messages;
import ca.uqac.lif.cep.functions.ApplyFunction;
import ca.uqac.lif.cep.io.Print;
import ca.uqac.lif.cep.tmf.Fork;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class GetInformation {
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

        // We create this print object to delimit the different information with a new line
        Print originalPrint = new Print();
        originalPrint.setSeparator("\n");

        // To get content of Discord object, we need to use the function processor from the DiscordPalette
        // In this example we will show the guild name, the member name, the channel name and the message content

        // For the guild we need to get the guild object from the message then the guild name
        ApplyFunction getGuild = new ApplyFunction(Messages.guild);
        ApplyFunction getGuildName = new ApplyFunction(Guilds.name);
        Print printGuildName = (Print) originalPrint.duplicate();

        // For the memeber it's very similar
        ApplyFunction getMember = new ApplyFunction(Messages.member);
        ApplyFunction getMemberName = new ApplyFunction(Members.nickname);
        Print printMember = (Print) originalPrint.duplicate();

        // Same for the channel
        ApplyFunction getChannel = new ApplyFunction(Messages.channel);
        ApplyFunction getChannelName = new ApplyFunction(MessageChannels.name);
        Print printChannel = (Print) originalPrint.duplicate();

        // And finally the message content
        ApplyFunction getMessageContent = new ApplyFunction(Messages.content);
        Print printMessage = (Print) originalPrint.duplicate();

        // We create a fork to show all the information
        Fork forkedInput = new Fork(4);

        Connector.connect(reader, 0, forkedInput, 0);

        // Guild name
        Connector.connect(forkedInput, 0, getGuild, 0);
        Connector.connect(getGuild, 0, getGuildName, 0);
        Connector.connect(getGuildName, 0, printGuildName, 0);

        // Member name
        Connector.connect(forkedInput, 1, getMember, 0);
        Connector.connect(getMember, 0, getMemberName, 0);
        Connector.connect(getMemberName, 0, printMember, 0);

        // Channel name
        Connector.connect(forkedInput, 2, getChannel, 0);
        Connector.connect(getChannel, 0, getChannelName, 0);
        Connector.connect(getChannelName, 0, printChannel, 0);

        // Message content
        Connector.connect(forkedInput, 3, getMessageContent, 0);
        Connector.connect(getMessageContent, 0, printMessage, 0);
    }
}
