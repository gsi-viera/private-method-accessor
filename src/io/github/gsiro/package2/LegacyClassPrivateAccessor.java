package io.github.gsiro.package2;

import io.github.gsiro.package1.LegacyClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LegacyClassPrivateAccessor implements PrivateContract {
    private final Method privateMethod1;
    private final LegacyClass legacyClass;

    public LegacyClassPrivateAccessor(LegacyClass object) {
        try {
            this.privateMethod1 = object.getClass().getDeclaredMethod("privateMethod1", String.class);
            this.privateMethod1.setAccessible(true);
        } catch (NoSuchMethodException e) {
            throw new AssertionError("Contract not fulfilled", e);
        }
        this.legacyClass = object;
    }

    @Override
    public String privateMethod1(String input) {
        try {
            return (String) privateMethod1.invoke(legacyClass, input);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new AssertionError("contract not fulfilled", e);
        }
    }
}
