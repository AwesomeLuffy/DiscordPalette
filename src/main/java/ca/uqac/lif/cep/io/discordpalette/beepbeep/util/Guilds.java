package ca.uqac.lif.cep.io.discordpalette.beepbeep.util;

import ca.uqac.lif.cep.functions.BinaryFunction;
import ca.uqac.lif.cep.functions.UnaryFunction;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;

import java.util.Collection;

public class Guilds {
    public static final Id id = new Id();
    public static final MemberCount memberCount = new MemberCount();
    public static final Name name = new Name();
    public static final IconUrl iconUrl = new IconUrl();
    public static final Description description = new Description();
    public static final Owner owner = new Owner();
    public static final Members members = new Members();
    public static final Roles roles = new Roles();
    public static final MemberRoles memberRoles = new MemberRoles();
    public static final MemberFromUser memberFromUser = new MemberFromUser();
    public static final MemberFromId memberFromId = new MemberFromId();


    protected Guilds(){}

    /**
     * Get the id of the guild as a String
     * (Discord use String instead of Long for the id cause id is very large number)
     */
    public static final class Id extends UnaryFunction<Guild, String> {
        private Id() {
            super(Guild.class, String.class);
        }

        @Override
        public String getValue(Guild guild) {
            return guild.getId();
        }

        @Override
        public String toString() {
            return "GuildId";
        }
    }

    /**
     * Get how many member the Guild have
     */
    public static final class MemberCount extends UnaryFunction<Guild, Integer> {
        private MemberCount() {
            super(Guild.class, Integer.class);
        }

        @Override
        public Integer getValue(Guild guild) {
            return guild.getMemberCount();
        }

        @Override
        public String toString() {
            return "MemberCount";
        }
    }

    /**
     * Get the name of the guild as a String
     */
    public static final class Name extends UnaryFunction<Guild, String> {
        private Name() {
            super(Guild.class, String.class);
        }

        @Override
        public String getValue(Guild guild) {
            return guild.getName();
        }

        @Override
        public String toString() {
            return "GuildName";
        }
    }

    /**
     * Get the icon url of the guild as a String
     */
    public static final class IconUrl extends UnaryFunction<Guild, String> {
        private IconUrl() {
            super(Guild.class, String.class);
        }

        @Override
        public String getValue(Guild guild) {
            return guild.getIconUrl();
        }

        @Override
        public String toString() {
            return "IconUrl";
        }
    }

    /**
     * Get the description of the guild as a String
     */
    public static final class Description extends UnaryFunction<Guild, String> {
        private Description() {
            super(Guild.class, String.class);
        }

        @Override
        public String getValue(Guild guild) {
            return guild.getDescription();
        }

        @Override
        public String toString() {
            return "Description";
        }
    }

    /**
     * Get the owner of the guild as a Member object
     */
    public static final class Owner extends UnaryFunction<Guild, Member> {
        private Owner() {
            super(Guild.class, Member.class);
        }

        @Override
        public Member getValue(Guild guild) {
            return guild.getOwner();
        }

        @Override
        public String toString() {
            return "Owner";
        }
    }

    /**
     * Get the Members as a Collection
     */
    public static final class Members extends UnaryFunction<Guild, Collection<Member>> {
        @SuppressWarnings("unchecked")
        private Members() {
            super(Guild.class, (Class<Collection<Member>>) (Class<?>) Collection.class);
        }

        @Override
        public Collection<Member> getValue(Guild guild) {
            return guild.getMembers();
        }

        @Override
        public String toString() {
            return "Members";
        }
    }

    /**
     * Get the roles of the guild as a Collection
     */
    public static final class Roles extends UnaryFunction<Guild, Collection<Role>> {
        @SuppressWarnings("unchecked")
        private Roles() {
            super(Guild.class, (Class<Collection<Role>>) (Class<?>) Collection.class);
        }

        @Override
        public Collection<Role> getValue(Guild guild) {
            return guild.getRoles();
        }

        @Override
        public String toString() {
            return "Roles";
        }
    }

    /**
     * Get the roles of a Member
     */
    public static final class MemberRoles extends UnaryFunction<Member, Collection<Role>> {
        @SuppressWarnings("unchecked")
        private MemberRoles() {
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

    /**
     * Get a Member from a User object
     */
    public static final class MemberFromUser extends BinaryFunction<Guild, User, Member> {
        private MemberFromUser() {
            super(Guild.class, User.class, Member.class);
        }

        @Override
        public Member getValue(Guild guild, User user) {
            return guild.getMember(user);
        }

        @Override
        public String toString() {
            return "Member";
        }
    }

    /**
     *  Get a Member from its id
     */
    public static final class MemberFromId extends BinaryFunction<Guild, String, Member> {
        private MemberFromId() {
            super(Guild.class, String.class, Member.class);
        }

        @Override
        public Member getValue(Guild guild, String id) {
            return guild.getMemberById(id);
        }

        @Override
        public String toString() {
            return "Member";
        }
    }

    /**
     * Represent a Role object that can only be found in a Guild
     * To Apply function that is inside procede as follows :
     * ApplyFunction roleName = new ApplyFunction(Guilds.GuildRole.name);
     */
    public static final class GuildRole {
        public static final Name name = new Name();
        public static final Position position = new Position();

        private GuildRole(){}

        /**
         * Get the name of the role as a String
         */
        public static final class Name extends UnaryFunction<Role, String> {
            private Name() {
                super(Role.class, String.class);
            }

            @Override
            public String getValue(Role role) {
                return role.getName();
            }

            @Override
            public String toString() {
                return "RoleName";
            }
        }

        /**
         * Get the position of the role as an Integer
         */
        public static final class Position extends UnaryFunction<Role, Integer> {
            private Position() {
                super(Role.class, Integer.class);
            }

            @Override
            public Integer getValue(Role role) {
                return role.getPosition();
            }

            @Override
            public String toString() {
                return "RolePosition";
            }
        }
    }
}
