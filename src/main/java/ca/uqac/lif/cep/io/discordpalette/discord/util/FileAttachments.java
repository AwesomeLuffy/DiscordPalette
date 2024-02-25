package ca.uqac.lif.cep.io.discordpalette.discord.util;

import ca.uqac.lif.cep.functions.UnaryFunction;
import net.dv8tion.jda.api.entities.Message;

public class FileAttachments {
    public static final FileName fileName = new FileName();
    public static final FormatedFileName formatedFileName = new FormatedFileName();
    public static final FileExtension fileExtension = new FileExtension();

    protected FileAttachments(){}

    /**
     * Get the full file name
     */
    public static final class FileName extends UnaryFunction<Message.Attachment, String> {

        private FileName() {
            super(Message.Attachment.class, String.class);
        }

        @Override
        public String getValue(Message.Attachment attachment) {
            return attachment.getFileName();
        }

        @Override
        public String toString() {
            return "FileName";
        }
    }

    /**
     * Get only the name of the file without the extensions
     */
    public static final class FormatedFileName extends UnaryFunction<Message.Attachment, String>{

        private FormatedFileName() {
            super(Message.Attachment.class, String.class);
        }

        @Override
        public String getValue(Message.Attachment attachment) {
            return attachment.getFileName().substring(0, attachment.getFileName().lastIndexOf('.'));
        }

        @Override
        public String toString() {
            return "FormatedFileName";
        }
    }

    /**
     * Get the extension of the file
     */
    public static final class FileExtension extends UnaryFunction<Message.Attachment, String> {

        private FileExtension() {
            super(Message.Attachment.class, String.class);
        }

        @Override
        public String getValue(Message.Attachment attachment) {
            return attachment.getFileExtension();
        }

        @Override
        public String toString() {
            return "FileExtension";
        }
    }
}
