package com.ing;

import java.util.function.*;

public class MethodReferences<K>{

public static void main(String[] args) {
    MethodReferences<String> m = new MethodReferences<>();
    String abc = "abc";
    m.staticReference("Hi",System.out::println);
    m.particularInstance("xyz", abc::startsWith);
    m.runtimeInstance("Non empty", String::isEmpty);
    m.constructor(String::new);
}

public void staticReference(K k, Consumer<K> con){
    con.accept(k);
}

public void particularInstance(K k, Predicate<K> pred){
    System.out.println("Particular Instance: " + pred.test(k));
}

public void runtimeInstance(K k, Predicate<K> pred){
    System.out.println("Runtime Instance" + pred.test(k));
}

public K constructor(Supplier<K> supp){
    System.out.println("Constructor: " + supp.get());
    return supp.get();
}

}