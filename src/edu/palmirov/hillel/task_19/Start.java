package edu.palmirov.hillel.task_19;

/*Task 19

В тексте найти и напечатать n символов (и их количество), встречающихся
наиболее часто.

Найти, каких букв, гласных или согласных, больше в каждом предложении
текста.

В тексте найти и напечатать все слова максимальной и все слова минималь-
ной длины.

Подсчитать количество содержащихся в данном тексте знаков препинания.

Подсчитать, сколько раз заданное слово входит в текст.

Из текста удалить все символы, кроме пробелов, не являющиеся буквами.

В каждом слове текста k-ю букву заменить заданным символом. Если k
больше длины слова, корректировку не выполнять.
*/

public class Start {
    public static void main(String[] args) {
        StringOps stringOps = new StringOps();

        //The text to be used for all the existing operations (functions/methods) in 'StringOps' class.
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

        System.out.println("\"a\" letter in the text: " + stringOps.countSymbolDuplicates('a', text) + "\n");

        for(String line : stringOps.countSymbolsPerSentence(text)){
            System.out.println(line);
        }

        System.out.print("\nThe shortest words in the text:");
        for(String value : stringOps.getSubstring(text, StringOps.SizeType.SHORT)){
            System.out.println(value);
        }

        System.out.print("\nThe longest words in the text:");
        for(String value : stringOps.getSubstring(text, StringOps.SizeType.SHORT)){
            System.out.println(value);
        }

        System.out.println("\nPunctuation marks in the text: " + stringOps.getPunctuationMarksQuantity(text));

        System.out.println("\n\"ut\" in the text: " + stringOps.countSubstring("ut", text));

        System.out.println("\n" + stringOps.onlyLetters(text));

        System.out.println("\n" + stringOps.replaceSymbolWith(3, '#', text));
    }
}