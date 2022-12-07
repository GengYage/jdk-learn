package org.yage.lambda;

import lombok.Data;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Yage
 * @create: 2022-12-07 10:36
 */
public class LambdaMetaFactory {
    public static final String GET = "get";
    public static final int GET_LENGTH = GET.length();


    @Data
    public static class LambdaMeta {
        private String methodName;
        private String captClass;
    }

    public static <T, U> LambdaMeta getLambdaMete(SFunction<T, U> function) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = function.getClass().getDeclaredMethod("writeReplace");
        method.setAccessible(true);
        SerializedLambda serializedLambda = (SerializedLambda) method.invoke(function);

        LambdaMeta lambdaMeta = new LambdaMeta();

        String implMethodName = serializedLambda.getImplMethodName();

        // 将get方法
        int index = 0;
        if ((index = implMethodName.lastIndexOf(GET)) >= 0) {
            String field = Character.toLowerCase(implMethodName.charAt(index + GET_LENGTH))
                    + implMethodName.substring(index + GET_LENGTH + 1);
            lambdaMeta.setMethodName(field);
            index = 0;
        }

        lambdaMeta.setCaptClass(serializedLambda.getImplClass().replace("/", "."));

        return lambdaMeta;
    }

    public interface SFunction<T, U> extends Serializable {
        T get(U u);
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        List<LambdaMeta> lambdaMetas = new ArrayList<>();
        lambdaMetas.add(LambdaMetaFactory.getLambdaMete(People::getValue));
        lambdaMetas.add(LambdaMetaFactory.getLambdaMete(People::getName));
        lambdaMetas.add(LambdaMetaFactory.getLambdaMete(User::getDate));
        lambdaMetas.add(LambdaMetaFactory.getLambdaMete(User::getPeople));

        lambdaMetas.forEach(System.out::println);
    }
}
