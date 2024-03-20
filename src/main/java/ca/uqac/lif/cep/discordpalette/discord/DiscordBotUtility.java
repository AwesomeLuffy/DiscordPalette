package ca.uqac.lif.cep.discordpalette.discord;

import ca.uqac.lif.cep.discordpalette.beepbeep.functions.OutputUnaryFunction;
import ca.uqac.lif.cep.functions.UnaryFunction;
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
     * Get the bot as User to have access to the bot's information and actions like a normal user
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
    public final class GuildFromId extends UnaryFunction<String, Guild> {
        private GuildFromId(){
            super(String.class, Guild.class);
        }

        @Override
        public Guild getValue(String guildId) {
            return BOT_INSTANCE.getGuildById(guildId);
        }
    }


}
