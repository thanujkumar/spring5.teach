package org.tk.spring.proxyfactory.javabased;

import javax.crypto.spec.PSource;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainCreatingMyProxy {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        Map<String, String> proxiedMap = (Map) Proxy.newProxyInstance(MainCreatingMyProxy.class.getClassLoader(),
                new Class[]{Map.class},
                new MyInvocationHandler(map)); //As InvocationHandler is function interface we can use lambda expression

        proxiedMap.put("one", "1");
        proxiedMap.put("two", "2");
        proxiedMap.get("one");

        //Directly accessing map to print details
        map.keySet().stream().forEach(k -> System.out.println(k+"="+map.get(k)));
    }
}
