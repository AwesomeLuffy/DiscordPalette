package ca.uqac.lif.cep.discordpalette.discord.Processor;

import ca.uqac.lif.cep.Processor;
import ca.uqac.lif.cep.SynchronousProcessor;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.MessageUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Queue;

public class DiscordMessageReader extends SynchronousProcessor {

    /**
     * Creates a new instance of the processor DiscordMessageReader
     */
    public DiscordMessageReader() {
        super(0, 1);
    }

    /**
     * This method is not used cause we have to nothing to compute, we will only send some data to the output
     * @return false
     */
    @Override
    protected boolean compute(Object[] objects, Queue<Object[]> queue) {
        return false;
    }

    /**
     * Duplicate the processor
     * @return the new instance of the processor
     */
    @Override
    public Processor duplicate(boolean with_state) {
        return new DiscordMessageReader();
    }

    /**
     * Get the listener of the Discord event message
     * @return ListenerAdapter (Discord event message listener)
     */
    public ListenerAdapter getDiscordMessageReceivedListener() {
        return new onDiscordMessageReceivedListener();
    }

    /**
     * Get the listener of the Discord event message update
     * @return ListenerAdapter (Discord event message update listener)
     */
    public ListenerAdapter getDiscordMessageUpdatedListener() {
        return new onDiscordMessageUpdatedListener();
    }
    protected class onDiscordMessageReceivedListener extends ListenerAdapter{
        @Override
        public void onMessageReceived(MessageReceivedEvent event) {
            if (event.getAuthor().isBot()) {
                return;
            }
            getPushableOutput(0).push(event.getMessage());
        }
    }

    protected class onDiscordMessageUpdatedListener extends ListenerAdapter{
        @Override
        public void onMessageUpdate(MessageUpdateEvent event) {
            if (event.getAuthor().isBot()) {
                return;
            }
            getPushableOutput(0).push(event.getMessage());
        }
    }
}
