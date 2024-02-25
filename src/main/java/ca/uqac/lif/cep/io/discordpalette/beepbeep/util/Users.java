package ca.uqac.lif.cep.io.discordpalette.beepbeep.util;

import ca.uqac.lif.cep.functions.UnaryFunction;
import net.dv8tion.jda.api.entities.User;

/**
 * Get information about the Discord user itself
 */
public class Users {
    public static final Id id = new Id();
    public static final Name name = new Name();
    public static final AvatarUrl avatarUrl = new AvatarUrl();

    protected Users(){}

    /**
     * Get the id of the user as a String (Discord use String instead of Long for the id cause id is very large number)
     */
    public static final class Id extends UnaryFunction<User, String> {
        private Id() {
            super(User.class, String.class);
        }

        @Override
        public String getValue(User user) {
            return user.getId();
        }

        @Override
        public String toString() {
            return "UserId";
        }
    }

    /** Get the name of the user as a String
     *
     */
    public static final class Name extends UnaryFunction<User, String> {
        private Name() {
            super(User.class, String.class);
        }

        @Override
        public String getValue(User user) {
            return user.getName();
        }

        @Override
        public String toString() {
            return "Name";
        }
    }

    /**
     * Get the avatar url of the user as a String
     */
    public static final class AvatarUrl extends UnaryFunction<User, String> {
        private AvatarUrl() {
            super(User.class, String.class);
        }

        @Override
        public String getValue(User user) {
            return user.getAvatarUrl();
        }

        @Override
        public String toString() {
            return "AvatarUrl";
        }
    }
}
