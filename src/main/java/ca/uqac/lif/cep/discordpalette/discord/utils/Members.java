package ca.uqac.lif.cep.discordpalette.discord.utils;

import ca.uqac.lif.cep.functions.UnaryFunction;
import net.dv8tion.jda.api.entities.*;

import java.util.Collection;

public class Members {
    public static final Id id = new Id();
    public static final Nickname nickname = new Nickname();
    public static final UserFromMember user = new UserFromMember();
    public static final Server guild = new Server();
    public static final AvatarUrl avatarUrl = new AvatarUrl();
    public static final Roles roles = new Roles();
    public static final TimeJoined timeJoined = new TimeJoined();
    public static final IsGuildOwner isGuildOwner = new IsGuildOwner();

    protected Members(){}

    /**
     * Get the id of the member as a String (Same as the userid)
     * Discord use String instead of Long for the id cause id is very large number
     */
    public static final class Id extends UnaryFunction<Member, String> {
        private Id() {
            super(Member.class, String.class);
        }

        @Override
        public String getValue(Member member) {
            return member.getId();
        }

        @Override
        public String toString() {
            return "MemberId";
        }
    }

    /**
     * Get the nickname the member have on the Guild
     */
    public static final class Nickname extends UnaryFunction<Member, String> {
        private Nickname() {
            super(Member.class, String.class);
        }

        @Override
        public String getValue(Member member) {
            return member.getNickname();
        }

        @Override
        public String toString() {
            return "Nickname";
        }
    }

    /**
     * Get the user object of the member
     * Discord allow to have different avatar for each server so a Member is a User but a User is not a Member
     */
    public static final class UserFromMember extends UnaryFunction<Member, User> {
        private UserFromMember() {
            super(Member.class, User.class);
        }

        @Override
        public User getValue(Member member) {
            return member.getUser();
        }

        @Override
        public String toString() {
            return "User";
        }
    }

    /**
     * Get the server of the member (the Guild)
     */
    public static final class Server extends UnaryFunction<Member, Guild> {
        private Server() {
            super(Member.class, Guild.class);
        }

        @Override
        public Guild getValue(Member member) {
            return member.getGuild();
        }

        @Override
        public String toString() {
            return "Guild";
        }
    }

    /**
     * Discord allow to have different avatar for each server
     */
    public static final class AvatarUrl extends UnaryFunction<Member, String> {
        private AvatarUrl() {
            super(Member.class, String.class);
        }

        @Override
        public String getValue(Member member) {
            return member.getAvatarUrl();
        }

        @Override
        public String toString() {
            return "AvatarUrl";
        }
    }

    /**
     * Get the roles of the member
     * A member can have multiple roles so it return a collection of roles
     */
    public static final class Roles extends UnaryFunction<Member, Collection<Role>> {
        @SuppressWarnings("unchecked")
        private Roles() {
            super(Member.class, (Class<Collection<Role>>) (Class<?>) Collection.class);
        }

        @Override
        public Collection<Role> getValue(Member member) {
            return member.getRoles();
        }

        @Override
        public String toString() {
            return "Roles";
        }
    }

    /** Get the time the member joined the guild, return a long (epoch second)
     *
     */
    public static final class TimeJoined extends UnaryFunction<Member, Long> {
        private TimeJoined() {
            super(Member.class, Long.class);
        }

        @Override
        public Long getValue(Member member) {
            return member.getTimeJoined().toEpochSecond();
        }

        @Override
        public String toString() {
            return "TimeJoined";
        }
    }

    /**
     * Check if the member is the owner of the guild
     */
    public static final class IsGuildOwner extends UnaryFunction<Member, Boolean> {
        private IsGuildOwner() {
            super(Member.class, Boolean.class);
        }

        @Override
        public Boolean getValue(Member member) {
            return member.isOwner();
        }

        @Override
        public String toString() {
            return "IsOwner";
        }
    }
}
