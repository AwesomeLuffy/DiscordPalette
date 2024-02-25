package ca.uqac.lif.cep.io.discordpalette.beepbeep.functions;

import ca.uqac.lif.cep.functions.BinaryFunction;

/**
 * To simplify the next Utility class where we always need the bot instance
 * This class allow to not have to indicate each time the first parameter of the BinaryFunction
 * @param <T> Will depend on what we want
 * @param <U> The output
 */
public abstract class OutputBinaryFunction<T, U> extends BinaryFunction<Object, T, U> {
    @SuppressWarnings("unchecked")
    protected OutputBinaryFunction(Class<?> clazzInput, Class<?> clazzOutput) {
        super(Object.class, (Class<T>) clazzInput, (Class<U>) clazzOutput);
    }
}
