package org.example.beepbeep;

import ca.uqac.lif.cep.Processor;
import ca.uqac.lif.cep.SynchronousProcessor;

import java.util.Queue;

public class DiscordMessageReader extends SynchronousProcessor {

    public DiscordMessageReader() {
        super(1, 1);
    }

    @Override
    protected boolean compute(Object[] objects, Queue<Object[]> queue) {
        return false;
    }

    @Override
    public Processor duplicate(boolean with_state) {
        //TODO
        return null;
    }
}
