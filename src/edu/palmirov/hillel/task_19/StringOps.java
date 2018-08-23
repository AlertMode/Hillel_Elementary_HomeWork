package edu.palmirov.hillel.task_19;

public class StringOps {

    //Returns the quantity of the input symbol in the input text.
    public int countSymbolDuplicates(char symbol , String text){
        char[] symbols = text.toCharArray();
        int counter = 0;

        for(int temp : symbols){
            if(symbol == temp){ ++counter; }
        }
        return counter;
    }


    //Returns the information about the quantity of vowels and consonants in each sentence.
    public String[] countSymbolsPerSentence(String text){
        if(text == null){ return null; }

        String[] sentences = text.split("(?<=[.!?])\\s"); //Split the whole text into the array of its sentences.
        int loopCounter = 0; //Stores the number of the sentence under consideration.
        int loopVowel = 0; //Stores the number of vowels in each sentence.
        int loopConsonants = 0; //Stores the number of consonants in each sentence.
        int loopOtherSymbols = 0; //Stores the number of other symbols in each sentence.
        int totalVowels = 0; //Stores the total number of vowels in all sentences.
        int totalConsonants = 0; //Stores the total number of consonants in all sentences.
        int totalOtherSymbols = 0; //Stores the total number of other symbols in all sentences.
        String[] info = new String[sentences.length + 1]; //Each array's cell will contain the information about each
        // sentence. The size was enlarged by one for containing the last message about total count.

        for(int i = 0; i < sentences.length; i++){

            loopVowel = this.getVowelsQuantity(sentences[i]);
            loopConsonants = this.getConsonantsQuantity(sentences[i]);
            loopOtherSymbols = sentences[i].length() - (loopVowel + loopConsonants);

            totalVowels += loopVowel; //Sums each sentence's amount of vowels.
            totalConsonants += loopConsonants; //Sums each sentence's amount of consonants.
            totalOtherSymbols += loopOtherSymbols; //Sums each sentence's amount of other symbols.
            ++loopCounter;

            //The last line, added to array, contains the information about total count of all symbols in the text.
            info[i] = "Sentence #" + loopCounter + " :: Vowels: " + loopVowel +
                    "; Consonants: " + loopConsonants + "; Other symbols: " + loopOtherSymbols +
                    "; Total: " + (loopVowel + loopConsonants + loopOtherSymbols) + ";";
        }

        info[sentences.length] = "Final :: Sentences : " + loopCounter + "; Vowels: " +  totalVowels +
                "; Consonants: " + totalConsonants + "; Other symbols: " + totalOtherSymbols +
                "; Total: " + (totalVowels + totalConsonants + totalOtherSymbols) + ";";
        return info;
    }


    //Counts the number of vowels in the input value.
    public int getVowelsQuantity(String text){
        char[] array = text.toCharArray();
        int count = 0;

        for(char temp : array){
            if(isVowel(temp)){ ++count; }
        }
        return count;
    }


    //Counts the number of consonants in the input value;
    public int getConsonantsQuantity(String text){
        char[] array = text.toCharArray();
        int count = 0;

        for(char temp : array){
            if(isConsonant(temp)){ ++count; }
        }
        return count;
    }


    //Returns the array of the words with minimum or maximum length in the text.
    public String[] getSubstring(String text, SizeType sizeType){
        String[] words = text.split("\\W+"); //Splits the input value into separate words and assigns them
        // to the array.

        int size = words[0].length(); //Assigned the first array's cell to be compared with the others.
        int i = 0; //Counts every loop's pass.
        String temp; //Created in order to store values, taken from the every array's cell.
        boolean condition; //Will contain the condition of comparing.

        //Finds out the shortest or the longest word in the array.
        while(i < words.length){
            temp = words[i];

            //Chooses the variant of comparing.
            if(sizeType.equals(SizeType.LONG)){
                condition = size < temp.length();
            } else {
                condition = size > temp.length();
            }

            if(condition) {
                size = temp.length();
            }
            ++i;
        }

        StringBuilder result = new StringBuilder();

        //Assigns all words with the same length to 'StringBuilder' variable.
        for(String word : words){
            if(size == word.length()){
                result.append(" " + word);
            }
        }

        return result.toString().split("\\W+");
    }


    //Returns the number of punctuation marks in the input 'String' variable.
    public int getPunctuationMarksQuantity(String text){
        int count = 0;

        for(int i = 0; i < text.length(); i++){
            char temp = text.charAt(i);

            switch(temp){
                case '.' : ++count; break;
                case ',' : ++count; break;
                case '!' : ++count; break;
                case '?' : ++count; break;
                case ':' : ++count; break;
                case ';' : ++count; break;
                case '-' : ++count; break;
                case '"' : ++count; break;
                case '(' : ++count; break;
                case ')' : ++count; break;
                case '*' : ++count; break;
                default: break;
            }
        }
        return count;
    }


    //Returns the quantity of the input substring's duplicates in the string.
    public int countSubstring(String substring, String text){
        String[] substrings = text.split("[\\p{Punct}\\s]+"); //Splits the input value into separate words and assigns them
        // to the array.

        int count = 0;

        for(String temp : substrings){
            if(substring.equals(temp)){ ++count; }
        }

        return count;
    }


    //Returns string with deleted symbols except letters.
    public String onlyLetters(String text){

        return text.replaceAll("\\P{L}+", " "); //Replaces every non-alphabetic symbol with whitespace.
    }


    //Returns string with replaced symbol in every substring (word) by input character.
    public String replaceSymbolWith(int index, char symbol, String text){
        String []substrings = text.split("\\W+"); //Separates string into substrings and assigns each to array's cell.

        for(String temp : substrings) {
            if (temp.length() - 1 >= index) { //Checks whether the input index is less than or equal to string's value size.
                StringBuilder toChange = new StringBuilder(temp);
                toChange.setCharAt(index, symbol); //Replaces every character by index with input one.

                String changed = toChange.toString();
                text = text.replaceAll(temp, changed); //Replaces every substring with the already modified.
            }
        }
        return text;
    }


    //Returns 'true' value if the input 'char' symbol is a latin or cyrillic vowel.
    //Otherwise, the result will be 'false'.
    private boolean isVowel(char symbol){
        String latinVowels = "aeiou";
        String cyrillicVowels = "ауоыиэяюеё";
        symbol = Character.toLowerCase(symbol);

        return latinVowels.indexOf(symbol) > 0 || cyrillicVowels.indexOf(symbol) > 0;
    }


    //Returns 'true' value if the input 'char' symbol is a latin or cyrillic consonant.
    //Otherwise, the result will be 'false'.
    private boolean isConsonant(char symbol){
        String latinConsonants = "bcdfghjklmnpqrstvwzyx";
        String cyrillicConsonants = "бвгджзйлмнркпстфхцчшщ";

        symbol = Character.toLowerCase(symbol);

        return latinConsonants.indexOf(symbol) > 0 || cyrillicConsonants.indexOf(symbol) > 0;
    }

    //For getSubstring() function.
    enum SizeType{
        LONG,
        SHORT;
    }
}