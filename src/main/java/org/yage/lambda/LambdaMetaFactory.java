package org.yage.lambda;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: Yage
 * @create: 2022-12-07 10:36
 */
public class LambdaMeta {
    public static <T, U> void getLambdaMete(SFunction<T, U> function) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = function.getClass().getDeclaredMethod("writeReplace");
        method.setAccessible(true);
        SerializedLambda serializedLambda = (SerializedLambda) method.invoke(function);

        System.out.println(serializedLambda.getImplMethodName());
    }

    public interface SFunction<T, U> extends Serializable {
        T get(U u);
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        LambdaMeta.getLambdaMete(People::getValue);
    }
}
