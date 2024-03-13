package ca.uqac.lif.cep.io.discordpalette.beepbeep.functions;

import ca.uqac.lif.cep.functions.UnaryFunction;

/**
 * To simplify the next Utility class where we always need the bot instance
 * This class allow to not have to indicate each time the first parameter of the UnaryFunction
 * It can be anything and only be here to trigger the function to get the result
 * @param <T>
 */
public abstract class OutputUnaryFunction<T> extends UnaryFunction<Object, T> {

    protected OutputUnaryFunction(Class<T> clazz) {
        super(Object.class, clazz);
    }
}
