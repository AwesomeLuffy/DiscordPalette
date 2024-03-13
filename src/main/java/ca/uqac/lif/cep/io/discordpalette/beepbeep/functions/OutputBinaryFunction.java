package ca.uqac.lif.cep.io.discordpalette.beepbeep.functions;

import ca.uqac.lif.cep.functions.BinaryFunction;

/**
 * To simplify the next Utility class where we always need the bot instance
 * This class allow to not have to indicate each time the first parameter of the BinaryFunction
 * @param <T> Will depend on what we want
 * @param <U> The output
 */
public abstract class OutputBinaryFunction<T, U> extends BinaryFunction<Object, T, U> {
    protected OutputBinaryFunction(Class<T> clazzInput, Class<U> clazzOutput) {
        super(Object.class, clazzInput, clazzOutput);
    }
}
