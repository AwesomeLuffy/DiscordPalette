package ca.uqac.lif.cep.io.discordpalette.beepbeep;

import ca.uqac.lif.cep.Processor;
import net.dv8tion.jda.api.JDA;
import ca.uqac.lif.cep.io.discordpalette.beepbeep.Processor.DiscordMessageReader;

import java.util.ArrayList;

public class DiscordPalette {

    // In case of the user want to have different bot instances
    // We have to do that cause a user can't have two bots with the same token
    private static final ArrayList<DiscordPalette> instances = new ArrayList<>();

    // Actuel token of the bot
    private final JDA BOT_INSTANCE;


    /**
     * Private constructor to create a new instance of DiscordPalette
     * @param _bot The bot instance that we want to connect BeepBeep to
     */
    private DiscordPalette(JDA _bot) {
        this.BOT_INSTANCE = _bot;
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
     * @return
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
     * @return
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
