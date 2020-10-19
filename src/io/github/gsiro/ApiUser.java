package io.github.gsiro;

import io.github.gsiro.package1.LegacyClass;
import io.github.gsiro.package2.LegacyClassPrivateAccessor;
import io.github.gsiro.package2.PrivateContract;

public class ApiUser {
    private LegacyClass legacyObject;
    public ApiUser(LegacyClass legacyObject){
        this.legacyObject = legacyObject;
    }
    public void run(){
        System.out.println(((PrivateContract) new LegacyClassPrivateAccessor(legacyObject)).privateMethod1("bar"));
    }
}
