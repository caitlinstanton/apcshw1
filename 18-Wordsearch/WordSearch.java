import java.util.*;
import java.io.*;

/**
 * Creates a word search puzzle
 *
 */
public class WordSearch{

    private char[][] board;

    public WordSearch(int r, int c){
	board = new char[r][c];
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		board[i][j]='.';
	    }
	}
				
    }
    public WordSearch(){
        this(20,30);
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

    public boolean checkHorizontal(String w, int row, int col) {
	boolean possible = true;
	int r = row, c = col;
	if (col + w.length() > board[0].length) {
	    return false;
	}
	if (row > board.length) {
	    return false;
	}
	for (int i = 0; i < w.length(); i++) {
	    if (board[r][c] != '.') {
		if (board[r][c] != w.charAt(i)) {
		    return false;
		}
	    }
	    c++;
	}
	return true;
    }

    public boolean addWordHForward(String w,int row, int col){
	int r = row, c = col;
	boolean possible = false;
	if (checkHorizontal(w, r, c) == true) {
	    for (int i = 0; i < w.length() ; i++) {
		board[r][c] = w.charAt(i);
		c++;
	    }
	    possible = true;
	}
	return possible;
    }

    public boolean addWordHBackward(String w, int row, int col){
	//just flips the word given and prints it using the addWordHForward() method
	String newWord = new StringBuilder(w).reverse().toString();
	addWordHForward(newWord, row, col);
	return (addWordHForward(newWord, row, col));
    }

    public boolean checkVertical(String w, int row, int col) {
	boolean possible = true;
	int r = row, c = col;
	if (row + w.length() > board.length) {
	    return false;
	}
	if (col > board[0].length) {
	    return false;
	}
	for (int i = 0; i < w.length(); i++) {
	    if (board[r][c] != '.') {
		if (board[r][c] != w.charAt(i)) {
		    return false;
		}
	    }
	    r++;
	}
	return true;
    }

     public boolean addWordVForward(String w,int row, int col){
	int r = row, c = col;
	boolean possible = false;
	if (checkVertical(w, r, c) == true) {
	    for (int i = 0; i < w.length() ; i++) {
		board[r][c] = w.charAt(i);
		r++;
	    }
	    possible = true;
	}
	return possible;
     }

    public boolean addWordVBackward(String w, int row, int col){
	//just flips the word given and prints it using the addWordHForward() method
	String newWord = new StringBuilder(w).reverse().toString();
	addWordVForward(newWord, row, col);
	return(addWordVForward(newWord, row, col));
    }

    public boolean checkDiagonalDR(String w, int row, int col) {
	boolean possible = true;
	int r = row, c = col;
	if (row + w.length() > board.length) {
	    return false;
	}
	if (col + w.length() > board[0].length) {
	    return false;
	}
	for (int i = 0; i < w.length(); i++) {
	    if (board[r][c] != '.') {
		if (board[r][c] != w.charAt(i)) {
		    return false;
		}
	    }
	    r++;
	    c++;
	}
	return true;
    }

    public boolean addDiagonalDR(String w, int row, int col) {
    	boolean possible = false;
	int r = row, c = col;
	if (checkDiagonalDR(w, r, c) == true) {
	    for (int i = 0; i < w.length() ; i++) {
		board[r][c] = w.charAt(i);
		r++;
		c++;
	    }
	    possible = true;
	}
	return possible;
    }

    public boolean checkDiagonalDL(String w, int row, int col) {
	boolean possible = true;
	int r = row, c = col;
	if (row + w.length() > board.length) {
	    return false;
	}
	if (col - w.length() > board[0].length) {
	    return false;
	}
	for (int i = 0; i < w.length(); i++) {
	    if (board[r][c] != '.') {
		if (board[r][c] != w.charAt(i)) {
		    return false;
		}
	    }
	    r++;
	    c--;
	}
	return true;
    }

    public boolean addDiagonalDL(String w, int row, int col) {
	int r = row, c = col;
	boolean possible = false;
	if (checkDiagonalDL(w, r, c) == true) {
	    for (int i = 0; i < w.length() ; i++) {
		board[r][c] = w.charAt(i);
		r++;
		c--;
	    }
	    possible = true;
	}
	return possible;
    }

     public boolean checkDiagonalUR(String w, int row, int col) {
	boolean possible = true;
	int r = row, c = col;
	if (row - w.length() > board.length) {
	    return false;
	}
	if (col + w.length() > board[0].length) {
	    return false;
	}
	for (int i = 0; i < w.length(); i++) {
	    if (board[r][c] != '.') {
		if (board[r][c] != w.charAt(i)) {
		    return false;
		}
	    }
	    r--;
	    c++;
	}
	return true;
    }

    public boolean addDiagonalUR(String w, int row, int col) {
	int r = row, c = col;
	boolean possible = false;
	if (checkDiagonalUR(w, r, c) == true) {
	    for (int i = 0; i < w.length() ; i++) {
		board[r][c] = w.charAt(i);
		r--;
		c++;
	    }
	    possible = true;
	}
	return possible;
    }

    public boolean checkDiagonalUL(String w, int row, int col) {
	boolean possible = true;
	int r = row, c = col;
	if (row - w.length() > board.length) {
	    return false;
	}
	if (col - w.length() > board[0].length) {
	    return false;
	}
	for (int i = 0; i < w.length(); i++) {
	    if (board[r][c] != '.') {
		if (board[r][c] != w.charAt(i)) {
		    return false;
		}
	    }
	    r--;
	    c--;
	}
	return true;
    }

    public boolean addDiagonalUL(String w, int row, int col) {
	int r = row, c = col;
	boolean possible = false;
	if (checkDiagonalUL(w, r, c) == true) {
	    for (int i = 0; i < w.length() ; i++) {
		board[r][c] = w.charAt(i);
		r--;
		c--;
	    }
	    possible = true;
	}
	return possible;
    }

    public void fillBoard() {
	Random r = new Random();
	for (int i = 0; i < board.length; i++) {
	    for (int c = 0; c < board[i].length; c++) {
		if (board[i][c] == '.') {
		    board[i][c] = (char)(r.nextInt(26) + 'A');
		}
	    }
	}
    }

    public boolean addWord(String w){
	Random r = new Random();
	int randRow = r.nextInt(board.length);
	int randCol = r.nextInt(board[0].length);
	int method = r.nextInt(8);

	if (method == 0){
	    addWordHForward(w, randRow, randCol);
	    return(addWordHForward(w, randRow, randCol));
	} else if (method == 1) {
	    addWordHBackward(w, randRow, randCol);
	    return(addWordHBackward(w, randRow, randCol));
	} else if (method == 2) {
	    addWordVForward(w, randRow, randCol);
	    return(addWordVForward(w, randRow, randCol));
	} else if (method == 3) {
	    addWordVBackward(w, randRow, randCol);
	    return(addWordVBackward(w, randRow, randCol));
	} else if (method == 4) {
	    addDiagonalDR(w, randRow, randCol);
	    return(addDiagonalDR(w, randRow, randCol));
	} else if (method == 5) {
	    addDiagonalDL(w, randRow, randCol);
	    return(addDiagonalDL(w, randRow, randCol));
	} else if (method == 6) {
	    addDiagonalUR(w, randRow, randCol);
	    return(addDiagonalUR(w, randRow, randCol));
	} else if (method == 7) {
	    addDiagonalUL(w, randRow, randCol);
	    return(addDiagonalUL(w, randRow, randCol));
	}
    }

    public static void main(String[] args) {
	WordSearch w = new WordSearch();
	/*
	w.addWordHForward("hello",3,5);
	w.addWordHForward("hello",400,5);
	w.addWordHForward("hello",3,655);

	w.addWordHBackward("world",10,4);
	w.addWordHBackward("world",100,4);
	w.addWordHBackward("world",10,400);

	w.addWordVForward("look",7,8);
	w.addWordVForward("look",700,8);
	w.addWordVForward("look",7,800);

	w.addWordVBackward("great",15,4);
	w.addWordVBackward("great",150,4);
	w.addWordVBackward("great",10,04);

	w.addDiagonalDR("awesome", 1, 4);
	w.addDiagonalDL("fruit", 5, 15);
	w.addDiagonalUR("wrath", 10, 15);
	w.addDiagonalUL("song", 19, 15);
	System.out.println(w);
	*/
	System.out.println(w.addWord("dog"));
	System.out.println(w.addWord("world"));
	System.out.println(w.addWord("cool"));
	w.fillBoard();
	System.out.println(w);
    }
}
