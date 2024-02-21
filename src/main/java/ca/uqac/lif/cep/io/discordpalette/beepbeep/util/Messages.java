package ca.uqac.lif.cep.io.discordpalette.beepbeep.util;

import ca.uqac.lif.cep.functions.UnaryFunction;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.Channel;

import java.util.Collection;
import java.util.List;

public class Messages {

    public static final Content content = new Content();
    public static final Author author = new Author();
    public static final GuildMember member = new GuildMember();
    public static final GuildChannel channel = new GuildChannel();
    public static final ServerGuild guild = new ServerGuild();
    public static final Files files = new Files();


    protected Messages(){}

    /**
     * Get the id of the message as a String
     * Discord use String instead of Long for the id cause id is very large number
     */
    public static final class Id extends UnaryFunction<Message, String> {
        public Id() {
            super(Message.class, String.class);
        }

        @Override
        public String getValue(Message message) {
            return message.getId();
        }

        @Override
        public String toString() {
            return "Id";
        }
    }

    /**
     * Get the content of the message as a String
     */
    public static final class Content extends UnaryFunction<Message, String>{
        public Content(){
            super(Message.class, String.class);
        }

        @Override
        public String getValue(Message message) {
            return message.getContentDisplay();
        }

        @Override
        public String toString() {
            return "Content";
        }
    }

    /**
     * Get the Author of the message
     */
    public static final class Author extends UnaryFunction<Message, User>{
        public Author(){
            super(Message.class, User.class);
        }

        @Override
        public User getValue(Message message) {
            return message.getAuthor();
        }

        @Override
        public String toString() {
            return "Author";
        }
    }

    /**
     * Get the Member of the message
     * The main difference with an Author is a Member is the User profile from the guild, not the User itself
     */
    public static final class GuildMember extends UnaryFunction<Message, Member>{

        public GuildMember(){
            super(Message.class, Member.class);
        }

        @Override
        public Member getValue(Message message) {
            return message.getMember();
        }

        @Override
        public String toString() {
            return "Member";
        }
    }

    /**
     * Get the Channel of the message
     */
    public static final class GuildChannel extends UnaryFunction<Message, Channel>{
        public GuildChannel(){
            super(Message.class, Channel.class);
        }

        @Override
        public Channel getValue(Message message) {
            return message.getChannel();
        }

        @Override
        public String toString() {
            return "Channel";
        }
    }

    /**
     * Get the Guild of the message
     */
    public static final class ServerGuild extends UnaryFunction<Message, Guild>{
        public ServerGuild(){
            super(Message.class, Guild.class);
        }

        @Override
        public Guild getValue(Message message) {
            return message.getGuild();
        }

        @Override
        public String toString() {
            return "Guild";
        }
    }

    public static final class Files extends UnaryFunction<Message, Collection<Message.Attachment>>{

        public Files(){
            super(Message.class, (Class<Collection<Message.Attachment>>) (Class<?>) Collection.class);
        }

        @Override
        public Collection<Message.Attachment> getValue(Message message) {
            return message.getAttachments();
        }

        @Override
        public String toString() {
            return "Files";
        }
    }
}
