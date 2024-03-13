package ca.uqac.lif.cep.io.discordpalette.discord;

import ca.uqac.lif.cep.Processor;
import net.dv8tion.jda.api.JDA;
import ca.uqac.lif.cep.io.discordpalette.discord.Processor.DiscordMessageReader;

public class DiscordPalette extends DiscordBotUtility {


    /**
     * Private constructor to create a new instance of DiscordPalette
     * @param _bot The bot instance that we want to connect BeepBeep to
     */
    private DiscordPalette(JDA _bot) {
        super(_bot);
        instances.add(this);
    }

    /**
     * Get the bot instance
     * @return
     */
    protected JDA getJDA(){
        return this.BOT_INSTANCE;
    }

    /**
     * Get the DiscordMessageReader processor, will have to be moved in another place
     * @return The discord message reader processor
     */
    public Processor getDiscordMessageReader(){
        DiscordMessageReader discordMessageReader = new DiscordMessageReader();
        this.BOT_INSTANCE.addEventListener(discordMessageReader.getDiscordMessageListener());
        return discordMessageReader;
    }

    /**
     * Get the instance of DiscordPalette, we have to do that to avoid having two instances of the same bot
     * Also, it will simplify the use of BeepBeep with Discord
     * @param _bot The bot instance that we want to connect BeepBeep to
     * @return The instance of DiscordPalette
     */
    public static DiscordPalette getInstance(JDA _bot){
        for(DiscordPalette instance : instances){
            if(instance.getJDA().equals(_bot)){
                return instance;
            }
        }
        return new DiscordPalette(_bot);
    }
}
