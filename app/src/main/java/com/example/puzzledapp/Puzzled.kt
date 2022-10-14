package com.example.puzzledapp

class Puzzled(_word: String) {
    var word: String
    var guessCount: Int
    init {
        this.word = _word
        this.guessCount = 0
    }

    fun play() {
        val length = this.word.length;
        println("Rules of the game: ");
        println("* is an incorrect letter");
        println("Capital letter is correct letter in the correct spot e.g. (A)");
        println("Uncapitalized letter is correct letter in the incorrect spot e.g. (a)")
        println();
        println("Word:");
        for(i in 0 until length) {
            print("* ")
        }
        println("\n");
        var gameOver = false;

        while(!gameOver) {
            println("Your guess: ")
            val userGuess = readLine();
            gameOver = guess(userGuess.toString());
        }
    }
    fun guess(userGuess: String): Boolean {
        var hint = "";
        // If the words are the same, gameOver becomes true
        if(word.lowercase() == userGuess.lowercase()) {
            println("You guessed correctly! You win!")
            return true;
        }

        // If the words are not the same, check what letters are in the word
        else {
            for (i in userGuess.indices) {
                for (j in word.indices) {
                    try {
                        if (word.contains(userGuess[i].toChar().lowercaseChar())) {
                            if (i == word.indexOf(userGuess[i].toChar().lowercaseChar())) {
                                hint += userGuess[i].toChar().uppercaseChar() + " ";
                                break;
                            } else {
                                hint += userGuess[i].toChar().lowercaseChar() + " ";
                                break;
                            }
                        } else {
                            hint += "* ";
                            break;
                        }
                    } catch (e: StringIndexOutOfBoundsException) {
                        println("String out of bounds exception")
                    }
                }
            }
        }
        println(hint);
        return false;
    }
}