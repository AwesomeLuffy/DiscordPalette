package ca.uqac.lif.cep.io.discordpalette.discord;

import ca.uqac.lif.cep.io.discordpalette.beepbeep.functions.OutputBinaryFunction;
import ca.uqac.lif.cep.io.discordpalette.beepbeep.functions.OutputUnaryFunction;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;

import java.util.ArrayList;

/**
 * This class allow generally to do somes action from the Bot like get a Guild, a Member, etc.. that the bot know
 */
abstract class DiscordBotUtility {
    public final SelfUser selfUser = new SelfUser();
    public final Status status = new Status();
    public final GuildFromId guildFromId = new GuildFromId();

    protected static final ArrayList<DiscordPalette> instances = new ArrayList<>();

    protected final JDA BOT_INSTANCE;


    protected DiscordBotUtility(JDA _bot){
        this.BOT_INSTANCE = _bot;
    }

    /**
     * Get the id of the bot as a String (Discord use String instead of Long for the id cause id is very large number)
     * We can put anything in entry of this class, it will always return the User object
     */
    public final class SelfUser extends OutputUnaryFunction<User> {
        private SelfUser() {
            super(User.class);
        }

        @Override
        public User getValue(Object obj) {
            return BOT_INSTANCE.getSelfUser();
        }

        @Override
        public String toString() {
            return "SelfUser";
        }
    }

    /**
     * Get the status
     */
    public final class Status extends OutputUnaryFunction<String> {
        private Status() {
            super(String.class);
        }

        @Override
        public String getValue(Object obj) {
            return BOT_INSTANCE.getStatus().toString();
        }

        @Override
        public String toString() {
            return "Status";
        }
    }

    /**
     * Get a guild that the bot had already join
     */
    public final class GuildFromId extends OutputBinaryFunction<String, Guild> {
        private GuildFromId(){
            super(String.class, Guild.class);
        }

        @Override
        public Guild getValue(Object o, String guildId) {
            return BOT_INSTANCE.getGuildById(guildId);
        }
    }


}
