package com.example.puzzledapp

import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.LinearLayout.LayoutParams
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import androidx.navigation.fragment.findNavController
import com.example.puzzledapp.databinding.FragmentFirstBinding
import java.util.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // region implements Letter Buttons
        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.buttonQ.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            inputLetter(myLayout, "Q")
        }

        binding.buttonW.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            inputLetter(myLayout, "W")
        }

        binding.buttonE.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            inputLetter(myLayout, "E")
        }

        binding.buttonR.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            inputLetter(myLayout, "R")
        }

        binding.buttonT.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            inputLetter(myLayout, "T")
        }

        binding.buttonY.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            inputLetter(myLayout, "Y")
        }

        binding.buttonU.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            inputLetter(myLayout, "U")
        }

        binding.buttonI.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            inputLetter(myLayout, "I")
        }

        binding.buttonO.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            inputLetter(myLayout, "O")
        }

        binding.buttonP.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            inputLetter(myLayout, "P")
        }

        binding.buttonA.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            inputLetter(myLayout, "A")
        }

        binding.buttonS.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            inputLetter(myLayout, "S")
        }

        binding.buttonD.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            inputLetter(myLayout, "D")
        }

        binding.buttonF.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            inputLetter(myLayout, "F")
        }

        binding.buttonG.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            inputLetter(myLayout, "G")
        }

        binding.buttonH.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            inputLetter(myLayout, "H")
        }

        binding.buttonJ.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            inputLetter(myLayout, "J")
        }

        binding.buttonK.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            inputLetter(myLayout, "K")
        }

        binding.buttonL.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            inputLetter(myLayout, "L")
        }

        binding.buttonZ.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            inputLetter(myLayout, "Z")
        }

        binding.buttonX.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            inputLetter(myLayout, "X")
        }

        binding.buttonC.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            inputLetter(myLayout, "C")
        }

        binding.buttonV.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            inputLetter(myLayout, "V")
        }

        binding.buttonB.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            inputLetter(myLayout, "B")
        }

        binding.buttonN.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            inputLetter(myLayout, "N")
        }

        binding.buttonM.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            inputLetter(myLayout, "M")
        }

        // endregion implements Letter Buttons

        binding.buttonDel.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            deleteLetter(myLayout)
        }

        var guesses = 0
        var word = getRandomWord()
//        var word = "book"
        var showWord = view.findViewById<TextView>(R.id.wordleView)
        showWord.text = " "

        val wordLength = word.length

        // region Table Layout

        val myLayout = view.findViewById<TableLayout>(R.id.myTable)
        for (i in 0..5) {
            val tableRow = TableRow(context)
            tableRow.id = View.generateViewId()

            for (i in 1..wordLength) {
                var rowTextView = TextView(view.context)
                rowTextView = makeLetterSquare(rowTextView)
                tableRow.addView(rowTextView)
            }
            myLayout.addView(tableRow)
        }

        // endregion Table Layout


        binding.buttonEnter.setOnClickListener {
            val myLayout = view.findViewById<TableLayout>(R.id.myTable)
            var isWord = checkIfWord(myLayout, word)
            getCorrectLetters(myLayout, word, view)
            guesses++
            if (isWord) {
                showWord.text = "You win!"
            } else if(guesses == 6) {
                showWord.text = "Sorry! The word was $word"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /*
     * Places user inputted letter in the latest spot
     */
    private fun inputLetter(myLayout: TableLayout, myLetter: String) {
        val childCount = myLayout.childCount
        findChild@ for (i in 0..childCount) {
            var view = myLayout.getChildAt(i)
            if (view is TableRow) {
                for (j in 0..view.childCount) {
                    var tableRow = view.getChildAt(j)
                    if (tableRow is TextView) {
                        if (tableRow.text == " ") {
                            tableRow.text = myLetter
                            break@findChild
                        }
                    }
                }
            }
        }
    }

    /*
     * Deletes last letter entered by user
     */
    private fun deleteLetter(myLayout: TableLayout) {
        val childCount = myLayout.childCount
        val wordIndex = getWordIndex(myLayout)
        var view = myLayout.getChildAt(wordIndex) as TableRow
        val tableChildren = view.childCount
        for (i in tableChildren downTo 0) {
            var row = view.getChildAt(i)
            if (row is TextView) {
                if (row.text != " ") {
                    row.text = " "
                    break
                }
            }
        }
    }

    /*
     * If the words are the same, returns True
     */
    private fun checkIfWord(myLayout: TableLayout, winningWord: String): Boolean {
        val myWord = getUserWord(myLayout)
        return myWord.lowercase() == winningWord.lowercase()
    }

    /*
     * Gets the last word guessed from the user and returns it as a String
     */
    private fun getUserWord(myLayout: TableLayout): String {
        var myWord = ""

        var wordIndex = getWordIndex(myLayout)
        val row = myLayout.getChildAt(wordIndex) as TableRow
        val tableChildren = row.childCount-1
        for(i in 0 .. tableChildren) {
            var child = row.getChildAt(i)
            if(child is TextView) {
                if(child.text == " ") {
                    break
                }
                myWord += child.text
            }
        }
        return myWord.lowercase()
    }

    /*
     * Returns the index of the last completed word in the table
     */
    private fun getWordIndex(myLayout: TableLayout): Int {
        val childCount = myLayout.childCount
        var tableIndex = 0
        findrow@ for(i in childCount-1 downTo 0) {
            var row = myLayout.getChildAt(i)
            if(row is TableRow) {
                val tableChildren = row.childCount
                for(j in 0 .. tableChildren) {
                    var child = row.getChildAt(i)
                    if(child is TextView) {
                        if(child.text == " ") {
                            break
                        }
                        tableIndex = i
                        break@findrow
                    }
                }
            }
        }
        return tableIndex
    }

    /*
     * Flips all letters in the user guess to their correct color
     * Green = Right letter in the correct spot
     * Red = Right letter in the incorrect spot
     * Dark Blue = Incorrect letter
     * Calls the changeButtonColor to change the keyboard buttons too
     */
    private fun getCorrectLetters(myLayout: TableLayout, winningWord: String, view: View) {
        var userWord = getUserWord(myLayout)
        var tableIndex = getWordIndex(myLayout)
        val rowIndex = myLayout.getChildAt(tableIndex) as TableRow
        var correctLetterWrongSpot = Color.parseColor("#D6A2AD")
        var correctLetterRightSpot = Color.parseColor("#668F80")
        var incorrectLetter = Color.parseColor("#1D3557")
        for (i in userWord.indices) {
            for (j in winningWord.indices) {
                try {
                    if (winningWord.contains(userWord[i].lowercase())) {
                        if (winningWord[i].lowercase() == userWord[i].lowercase()) {
                            var letter = rowIndex.getChildAt(i)
                            letter.setBackgroundColor(correctLetterRightSpot)
                            changeButtonColor(userWord[i].uppercase(), view, 1)
                            break
                        } else {
                            var letter = rowIndex.getChildAt(i)
                            letter.setBackgroundColor(correctLetterWrongSpot)
                            changeButtonColor(userWord[i].uppercase(), view, 0)
                            break
                        }
                    }
                    else {
                        var letter = rowIndex.getChildAt(i)
                        letter.setBackgroundColor(incorrectLetter)
                        changeButtonColor(userWord[i].uppercase(), view, -1)
                    }
                } catch (e: StringIndexOutOfBoundsException) {
                    println("String out of bounds exception")
                }
            }
        }
    }

    /*
     * Change the button colors to match the color of the letter
     */
    private fun changeButtonColor(letter: String, view: View, isCorrect: Int) {
        val buttonID = "button$letter"
        val button = view.findViewById<Button>(resources.getIdentifier(buttonID, "id", activity?.getPackageName()))
        var correctLetter = Color.parseColor("#668F80")
        var correctLetterWrongPlace = Color.parseColor("#D6A2AD")
        var incorrectLetter = Color.parseColor("#1D3557")
        when(isCorrect) {
            1 -> button?.setBackgroundColor(correctLetter)
            0 -> button?.setBackgroundColor(correctLetterWrongPlace)
            -1 -> button?.setBackgroundColor(incorrectLetter)
        }

    }

    /*
     * Creates Drawable Square out of a TextView for our letter boxes
     */
    private fun makeLetterSquare(myView: TextView): TextView {
        myView.text = " "
        myView.textSize = 30f
        var myColor = Color.parseColor("#000000")
        myView.setTextColor(myColor)
        var myDrawable = getResources().getDrawable(R.drawable.drawable)
        myView.setBackground(myDrawable)
        myView.setPadding(75,45,25,45)
        myView.layoutParams = TableRow.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT, 1F)
        return myView
    }

    /*
    * Returns String out of pool of 1000 common words
    */
    private fun getRandomWord(): String {
        val wordList = listOf("able",
            "about",
            "absolute",
            "accept",
            "account",
            "achieve",
            "across",
            "act",
            "active",
            "actual",
            "add",
            "address",
            "admit",
            "advertise",
            "affect",
            "afford",
            "after",
            "afternoon",
            "again",
            "against",
            "age",
            "agent",
            "ago",
            "agree",
            "air",
            "all",
            "allow",
            "almost",
            "along",
            "already",
            "alright",
            "also",
            "although",
            "always",
            "america",
            "amount",
            "and",
            "another",
            "answer",
            "any",
            "apart",
            "apparent",
            "appear",
            "apply",
            "appoint",
            "approach",
            "appropriate",
            "area",
            "argue",
            "arm",
            "around",
            "arrange",
            "art",
            "as",
            "ask",
            "associate",
            "assume",
            "at",
            "attend",
            "authority",
            "available",
            "aware",
            "away",
            "awful",
            "baby",
            "back",
            "bad",
            "bag",
            "balance",
            "ball",
            "bank",
            "bar",
            "base",
            "basis",
            "be",
            "bear",
            "beat",
            "beauty",
            "because",
            "become",
            "bed",
            "before",
            "begin",
            "behind",
            "believe",
            "benefit",
            "best",
            "bet",
            "between",
            "big",
            "bill",
            "birth",
            "bit",
            "black",
            "bloke",
            "blood",
            "blow",
            "blue",
            "board",
            "boat",
            "body",
            "book",
            "both",
            "bother",
            "bottle",
            "bottom",
            "box",
            "boy",
            "break",
            "brief",
            "brilliant",
            "bring",
            "britain",
            "brother",
            "budget",
            "build",
            "bus",
            "business",
            "busy",
            "but",
            "buy",
            "by",
            "cake",
            "call",
            "can",
            "car",
            "card",
            "care",
            "carry",
            "case",
            "cat",
            "catch",
            "cause",
            "cent",
            "centre",
            "certain",
            "chair",
            "chairman",
            "chance",
            "change",
            "chap",
            "character",
            "charge",
            "cheap",
            "check",
            "child",
            "choice",
            "choose",
            "Christ",
            "Christmas",
            "church",
            "city",
            "claim",
            "class",
            "clean",
            "clear",
            "client",
            "clock",
            "close",
            "closes",
            "clothe",
            "club",
            "coffee",
            "cold",
            "colleague",
            "collect",
            "college",
            "colour",
            "come",
            "comment",
            "commit",
            "committee",
            "common",
            "community",
            "company",
            "compare",
            "complete",
            "compute",
            "concern",
            "condition",
            "confer",
            "consider",
            "consult",
            "contact",
            "continue",
            "contract",
            "control",
            "converse",
            "cook",
            "copy",
            "corner",
            "correct",
            "cost",
            "could",
            "council",
            "count",
            "country",
            "county",
            "couple",
            "course",
            "court",
            "cover",
            "create",
            "cross",
            "cup",
            "current",
            "cut",
            "dad",
            "danger",
            "date",
            "day",
            "dead",
            "deal",
            "dear",
            "debate",
            "decide",
            "decision",
            "deep",
            "definite",
            "degree",
            "department",
            "depend",
            "describe",
            "design",
            "detail",
            "develop",
            "die",
            "difference",
            "difficult",
            "dinner",
            "direct",
            "discuss",
            "district",
            "divide",
            "do",
            "doctor",
            "document",
            "dog",
            "door",
            "double",
            "doubt",
            "down",
            "draw",
            "dress",
            "drink",
            "drive",
            "drop",
            "dry",
            "due",
            "during",
            "each",
            "early",
            "east",
            "easy",
            "eat",
            "economy",
            "educate",
            "effect",
            "egg",
            "eight",
            "either",
            "elect",
            "electric",
            "eleven",
            "else",
            "employ",
            "encourage",
            "end",
            "engine",
            "english",
            "enjoy",
            "enough",
            "enter",
            "environment",
            "equal",
            "especial",
            "europe",
            "even",
            "evening",
            "ever",
            "every",
            "evidence",
            "exact",
            "example",
            "except",
            "excuse",
            "exercise",
            "exist",
            "expect",
            "expense",
            "experience",
            "explain",
            "express",
            "extra",
            "eye",
            "face",
            "fact",
            "fair",
            "fall",
            "family",
            "far",
            "farm",
            "fast",
            "father",
            "favour",
            "feed",
            "feel",
            "few",
            "field",
            "fight",
            "figure",
            "file",
            "fill",
            "film",
            "final",
            "finance",
            "find",
            "fine",
            "finish",
            "fire",
            "first",
            "fish",
            "fit",
            "five",
            "flat",
            "floor",
            "fly",
            "follow",
            "food",
            "foot",
            "for",
            "force",
            "forget",
            "form",
            "fortune",
            "forward",
            "four",
            "france",
            "free",
            "friday",
            "friend",
            "from",
            "front",
            "full",
            "fun",
            "function",
            "fund",
            "further",
            "future",
            "game",
            "garden",
            "gas",
            "general",
            "germany",
            "get",
            "girl",
            "give",
            "glass",
            "go",
            "god",
            "good",
            "goodbye",
            "govern",
            "grand",
            "grant",
            "great",
            "green",
            "ground",
            "group",
            "grow",
            "guess",
            "guy",
            "hair",
            "half",
            "hall",
            "hand",
            "hang",
            "happen",
            "happy",
            "hard",
            "hate",
            "have",
            "he",
            "head",
            "health",
            "hear",
            "heart",
            "heat",
            "heavy",
            "hell",
            "help",
            "here",
            "high",
            "history",
            "hit",
            "hold",
            "holiday",
            "home",
            "honest",
            "hope",
            "horse",
            "hospital",
            "hot",
            "hour",
            "house",
            "how",
            "however",
            "hullo",
            "hundred",
            "husband",
            "idea",
            "identify",
            "if",
            "imagine",
            "important",
            "improve",
            "in",
            "include",
            "income",
            "increase",
            "indeed",
            "individual",
            "industry",
            "inform",
            "inside",
            "instead",
            "insure",
            "interest",
            "into",
            "introduce",
            "invest",
            "involve",
            "issue",
            "it",
            "item",
            "jesus",
            "job",
            "join",
            "judge",
            "jump",
            "just",
            "keep",
            "key",
            "kid",
            "kill",
            "kind",
            "king",
            "kitchen",
            "knock",
            "know",
            "labour",
            "lad",
            "lady",
            "land",
            "language",
            "large",
            "last",
            "late",
            "laugh",
            "law",
            "lay",
            "lead",
            "learn",
            "leave",
            "left",
            "leg",
            "less",
            "let",
            "letter",
            "level",
            "lie",
            "life",
            "light",
            "like",
            "likely",
            "limit",
            "line",
            "link",
            "list",
            "listen",
            "little",
            "live",
            "load",
            "local",
            "lock",
            "london",
            "long",
            "look",
            "lord",
            "lose",
            "lot",
            "love",
            "low",
            "luck",
            "lunch",
            "machine",
            "main",
            "major",
            "make",
            "man",
            "manage",
            "many",
            "mark",
            "market",
            "marry",
            "match",
            "matter",
            "may",
            "maybe",
            "mean",
            "meaning",
            "measure",
            "meet",
            "member",
            "mention",
            "middle",
            "might",
            "mile",
            "milk",
            "million",
            "mind",
            "minister",
            "minus",
            "minute",
            "miss",
            "mister",
            "moment",
            "monday",
            "money",
            "month",
            "more",
            "morning",
            "most",
            "mother",
            "motion",
            "move",
            "mrs",
            "much",
            "music",
            "must",
            "name",
            "nation",
            "nature",
            "near",
            "necessary",
            "need",
            "never",
            "new",
            "news",
            "next",
            "nice",
            "night",
            "nine",
            "no",
            "non",
            "none",
            "normal",
            "north",
            "not",
            "note",
            "notice",
            "now",
            "number",
            "obvious",
            "occasion",
            "odd",
            "of",
            "off",
            "offer",
            "office",
            "often",
            "okay",
            "old",
            "on",
            "once",
            "one",
            "only",
            "open",
            "operate",
            "opportunity",
            "oppose",
            "or",
            "order",
            "organize",
            "original",
            "other",
            "otherwise",
            "ought",
            "out",
            "over",
            "own",
            "pack",
            "page",
            "paint",
            "pair",
            "paper",
            "paragraph",
            "pardon",
            "parent",
            "park",
            "part",
            "particular",
            "party",
            "pass",
            "past",
            "pay",
            "pence",
            "pension",
            "people",
            "per",
            "percent",
            "perfect",
            "perhaps",
            "period",
            "person",
            "photograph",
            "pick",
            "picture",
            "piece",
            "place",
            "plan",
            "play",
            "please",
            "plus",
            "point",
            "police",
            "policy",
            "politic",
            "poor",
            "position",
            "positive",
            "possible",
            "post",
            "pound",
            "power",
            "practise",
            "prepare",
            "present",
            "press",
            "pressure",
            "presume",
            "pretty",
            "previous",
            "price",
            "print",
            "private",
            "probable",
            "problem",
            "proceed",
            "process",
            "produce",
            "product",
            "programme",
            "project",
            "proper",
            "propose",
            "protect",
            "provide",
            "public",
            "pull",
            "purpose",
            "push",
            "put",
            "quality",
            "quarter",
            "question",
            "quick",
            "quid",
            "quiet",
            "quite",
            "radio",
            "rail",
            "raise",
            "range",
            "rate",
            "rather",
            "read",
            "ready",
            "real",
            "realise",
            "really",
            "reason",
            "receive",
            "recent",
            "reckon",
            "recognize",
            "recommend",
            "record",
            "red",
            "reduce",
            "refer",
            "regard",
            "region",
            "relation",
            "remember",
            "report",
            "represent",
            "require",
            "research",
            "resource",
            "respect",
            "responsible",
            "rest",
            "result",
            "return",
            "rid",
            "right",
            "ring",
            "rise",
            "road",
            "role",
            "roll",
            "room",
            "round",
            "rule",
            "run",
            "safe",
            "sale",
            "same",
            "saturday",
            "save",
            "say",
            "scheme",
            "school",
            "science",
            "score",
            "scotland",
            "seat",
            "second",
            "secretary",
            "section",
            "secure",
            "see",
            "seem",
            "self",
            "sell",
            "send",
            "sense",
            "separate",
            "serious",
            "serve",
            "service",
            "set",
            "settle",
            "seven",
            "sex",
            "shall",
            "share",
            "she",
            "sheet",
            "shoe",
            "shoot",
            "shop",
            "short",
            "should",
            "show",
            "shut",
            "sick",
            "side",
            "sign",
            "similar",
            "simple",
            "since",
            "sing",
            "single",
            "sir",
            "sister",
            "sit",
            "site",
            "situate",
            "six",
            "size",
            "sleep",
            "slight",
            "slow",
            "small",
            "smoke",
            "so",
            "social",
            "society",
            "some",
            "son",
            "soon",
            "sorry",
            "sort",
            "sound",
            "south",
            "space",
            "speak",
            "special",
            "specific",
            "speed",
            "spell",
            "spend",
            "square",
            "staff",
            "stage",
            "stairs",
            "stand",
            "standard",
            "start",
            "state",
            "station",
            "stay",
            "step",
            "stick",
            "still",
            "stop",
            "story",
            "straight",
            "strategy",
            "street",
            "strike",
            "strong",
            "structure",
            "student",
            "study",
            "stuff",
            "stupid",
            "subject",
            "succeed",
            "such",
            "sudden",
            "suggest",
            "suit",
            "summer",
            "sun",
            "sunday",
            "supply",
            "support",
            "suppose",
            "sure",
            "surprise",
            "switch",
            "system",
            "table",
            "take",
            "talk",
            "tape",
            "tax",
            "tea",
            "teach",
            "team",
            "telephone",
            "television",
            "tell",
            "ten",
            "tend",
            "term",
            "terrible",
            "test",
            "than",
            "thank",
            "the",
            "then",
            "there",
            "therefore",
            "they",
            "thing",
            "think",
            "thirteen",
            "thirty",
            "this",
            "thou",
            "though",
            "thousand",
            "three",
            "through",
            "throw",
            "thursday",
            "tie",
            "time",
            "to",
            "today",
            "together",
            "tomorrow",
            "tonight",
            "too",
            "top",
            "total",
            "touch",
            "toward",
            "town",
            "trade",
            "traffic",
            "train",
            "transport",
            "travel",
            "treat",
            "tree",
            "trouble",
            "true",
            "trust",
            "try",
            "tuesday",
            "turn",
            "twelve",
            "twenty",
            "two",
            "type",
            "under",
            "understand",
            "union",
            "unit",
            "unite",
            "university",
            "unless",
            "until",
            "up",
            "upon",
            "use",
            "usual",
            "value",
            "various",
            "very",
            "video",
            "view",
            "village",
            "visit",
            "vote",
            "wage",
            "wait",
            "walk",
            "wall",
            "want",
            "war",
            "warm",
            "wash",
            "waste",
            "watch",
            "water",
            "way",
            "we",
            "wear",
            "wednesday",
            "wee",
            "week",
            "weigh",
            "welcome",
            "well",
            "west",
            "what",
            "when",
            "where",
            "whether",
            "which",
            "while",
            "white",
            "who",
            "whole",
            "why",
            "wide",
            "wife",
            "will",
            "win",
            "wind",
            "window",
            "wish",
            "with",
            "within",
            "without",
            "woman",
            "wonder",
            "wood",
            "word",
            "work",
            "world",
            "worry",
            "worse",
            "worth",
            "would",
            "write",
            "wrong",
            "year",
            "yes",
            "yesterday",
            "yet",
            "you",
            "young")
        val randomNumber = Random().nextInt(wordList.size-1)
        return wordList[randomNumber].toString()
    }
}