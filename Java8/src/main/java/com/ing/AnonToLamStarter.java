package com.ing;

import java.util.function.Predicate;

/**
 * Hello world!
 *
 */
public class AnonToLamStarter
{

    public static void main (String ... args){
        AnonToLamStarter anonToLam = new AnonToLamStarter();
        anonToLam.printAnswer(new Predicate<String>(){
            @Override
            public boolean test(String string){
                return string.startsWith("a");
            }
        }, "abc");
    }

    public void printAnswer(Predicate<String> pred, String name){
        System.out.println(pred.test(name));
    }
}
