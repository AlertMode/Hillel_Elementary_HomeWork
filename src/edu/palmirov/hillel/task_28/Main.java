package edu.palmirov.hillel.task_28;

public class Main {
    public static void main(String []args){
        Message<Boolean> booleanMessage = new Message<>(true);
        Message<Character> characterMessage = new Message<>('g');
        Message<Byte> byteMessage = new Message<>(Byte.MAX_VALUE);
        Message<Short> shortData = new Message<>(Short.MIN_VALUE);
        Message<Float> floatMessage = new Message<>(67.04F);
        Message<Double> doubleData = new Message<>(746.466);
        Message<Integer> intData = new Message<>(554747456);
        Message<Long> longData = new Message<>(93665940054000279L);
        Message<String> stringMessage = new Message<>("That's all, folks!");

        System.out.println(booleanMessage.toString());
        System.out.println(characterMessage.toString());
        System.out.println(byteMessage.toString());
        System.out.println(shortData.toString());
        System.out.println(floatMessage.toString());
        System.out.println(doubleData.toString());
        System.out.println(intData.toString());
        System.out.println(longData.toString());
        System.out.println(stringMessage.toString());
    }
}