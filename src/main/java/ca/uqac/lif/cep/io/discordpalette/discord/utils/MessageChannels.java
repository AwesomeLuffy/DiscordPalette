package ca.uqac.lif.cep.io.discordpalette.discord.utils;

import ca.uqac.lif.cep.Processor;
import ca.uqac.lif.cep.SynchronousProcessor;
import ca.uqac.lif.cep.functions.UnaryFunction;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;

import java.util.Queue;

public class MessageChannels {
    public static final Id id = new Id();
    public static final Name name = new Name();
    public static final Guilds guilds = new Guilds();
    public static final CanTalk canTalk = new CanTalk();
    public static final SendMessage sendMsg = new SendMessage();

    protected MessageChannels(){}

    /**
     * Get the id of the text channel as a String
     */
    public static final class Id extends UnaryFunction<TextChannel, String> {
        private Id() {
            super(TextChannel.class, String.class);
        }

        @Override
        public String getValue(TextChannel textChannel) {
            return textChannel.getId();
        }

        @Override
        public String toString() {
            return "TextChannelId";
        }
    }

    /**
     * Get the name of the text channel as a String
     */
    public static final class Name extends UnaryFunction<MessageChannel, String> {
        private Name() {
            super(MessageChannel.class, String.class);
        }

        @Override
        public String getValue(MessageChannel textChannel) {
            return textChannel.getName();
        }

        @Override
        public String toString() {
            return "TextChannelName";
        }
    }

    /**
     * Get the guild of the text channel as a Guild
     */
    public static final class Guilds extends UnaryFunction<MessageChannel, Guild> {
        private Guilds() {
            super(MessageChannel.class, Guild.class);
        }

        @Override
        public Guild getValue(MessageChannel textChannel) throws ClassCastException{
            if(textChannel instanceof TextChannel) {
                return ((TextChannel) textChannel).getGuild();
            }
            throw new ClassCastException("The channel is not a TextChannel");

        }

        @Override
        public String toString() {
            return "TextChannelGuild";
        }
    }

    /**
     * Get the information if we can talk in this channel or not
     */
    public static final class CanTalk extends UnaryFunction<MessageChannel, Boolean> {
        private CanTalk() {
            super(MessageChannel.class, Boolean.class);
        }

        @Override
        public Boolean getValue(MessageChannel textChannel) {
            return textChannel.canTalk();
        }

        @Override
        public String toString() {
            return "CanTalk";
        }
    }

    public static class SendMessage extends SynchronousProcessor {
        public SendMessage() {
            super(2, 1);
        }

        @Override
        protected boolean compute(Object[] inputs, Queue<Object[]> queue) {
            if (!(inputs[0] instanceof MessageChannel channel) || !(inputs[1] instanceof String message)) {
                return false;
            }
            try {
                queue.add(new Object[]{channel.sendMessage(message).submit().join()});
            }
            catch (InsufficientPermissionException e){
                System.out.println("The bot does not have the permission to send a message in this channel");
                return false;
            }
            catch (AssertionError e){
                System.out.println("The bot is rate limited ! Please wait a few seconds before sending another message");
                return false;
            }
            catch (Exception e){
                System.out.println("An error occurred while sending the message");
                return false;
            }
            return true;
        }

        @Override
        public Processor duplicate(boolean b) {
            throw new UnsupportedOperationException("This processor cannot be duplicated");
        }
    }


}
