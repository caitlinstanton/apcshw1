import java.util.*;
import java.io.*;

/**
 * Creates a word search puzzle
 *
 */
public class WordSearch{

    private char[][] board, key;
    private ArrayList<String> words;
    private ArrayList<String> wordsInPuzzle;
    private Random rnd;
    public int n;
    
    public WordSearch(){
	rnd = new Random();
	words = new ArrayList<String>();

	Scanner sc = null;
	try {
	    sc = new Scanner(new File("words.txt"));
	} catch (Exception e ) {
	    System.out.println("Can't open wordlist");
	    System.exit(0);
	}

	while (sc.hasNext()) {
	    words.add(sc.next());
	}
	Scanner scan = new Scanner(System.in);
	System.out.println("Now you get to choose what your word search looks like:");
	try {
	    Thread.sleep(3000);
	} catch (Exception e ) {}
	System.out.println("How many rows?");
	int r = scan.nextInt();
	System.out.println("How many columns?");
	int c = scan.nextInt();
	System.out.println("How many words?");
	n = scan.nextInt();
	if (r > 0 && c > 0 && n > 0) {
	    board = new char[r][c];
	    for (int i = 0; i < board.length; i++) {
		for (int j = 0; j < board[i].length; j++) {
		    board[i][j]='.';
		}
	    }
	} else {
	    System.out.println("Invalid entry");
	    System.exit(0);
	}
				
    }

    public String toString(){
	String s = "";
       	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		s = s + board[i][j];
	    }
	    s = s + "\n";
	}
	return s;
    }

    //Code from in-class
    public boolean addWordHelper(String w,int row, int col,int deltaRow, int deltaCol){
	int r = row, c = col;
				
	for (int i=0;i<w.length();i++){
	    try {
		if (board[r][c]!='.' && board[r][c]!=w.charAt(i)){
		    return false;
		}
	    } catch ( Exception e){
		return false;
	    }
	    r = r + deltaRow;
	    c = c + deltaCol;
	}

	r = row;
	c = col;

	for (int i=0;i<w.length();i++){
	    board[r][c] = w.charAt(i);
	    r = r + deltaRow;
	    c=c+deltaCol;
	}
	return true;
    }

    //Code from in-class
    //Adds words at different orientations automatically
     public boolean addWord(String w) {
	int row = rnd.nextInt(board.length);
	int col = rnd.nextInt(board[0].length);
	int deltaRow = -1 + rnd.nextInt(3);
	int deltaCol = -1 + rnd.nextInt(3);
	if (deltaRow == deltaCol && deltaCol == 0)
	    return false;
	return addWordHelper(w,row,col,deltaRow,deltaCol);
    }
    
    private void makeKey(){
	key = new char[board.length][board[0].length];
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[0].length; j++) {
		key[i][j] = board[i][j];
	    }
	}
    }
    
    public void buildPuzzle() {

	/*
	  loop
	    take a random word out of wordlist
	    try to add it to the puzzle
	*/
	wordsInPuzzle = new ArrayList<String>();
	while (n > 0){
	    int wordIndex = rnd.nextInt(words.size());
	    String word = words.get(wordIndex);
	    if (addWord(word)) {
		n--;
		words.remove(wordIndex);
		wordsInPuzzle.add(word);
	    }
	}
	makeKey();
	/*fill in rest of the board*/
       	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[0].length; j++) {
		if(board[i][j] == '.') {
		    /* method 2
		    String letters = "abcdefghijklmnopqrstuvwxyz";
		    char letter = letters.charAt(rnd.nextInt(letters.length()));
		    board[i][j] = letter;
		    */

		    //method 1
		    int offset = rnd.nextInt(26);
		    board[i][j] = (char)((int) 'a' + offset);
		}
	    }
	}
    }

    public String getWIP() {
	return wordsInPuzzle.toString();
    }

    public String getKey() {
	String s = "";
       	for (int i = 0; i < key.length; i++) {
	    for (int j = 0; j < key[i].length; j++) {
		s = s + key[i][j];
	    }
	    s = s + "\n";
	}
	return s;
    }
    
    public static void main(String[] args) {
	WordSearch w = new WordSearch();
	w.buildPuzzle();
	System.out.println(w);
	System.out.println(w.getWIP());
	System.out.println(w.getKey());
    }
}
