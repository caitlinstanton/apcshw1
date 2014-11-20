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

    public void addWordH(String w,int row, int col){
	boolean possible;
	int r = row, c = col;
	if (r < = board.length && col <= board[1].length) {
	    possible = true;
	    if (possible == true) {
		for (int i=0;i<w.length();i++){
		    if (board[r][c+i] != '.'){
			possible = false;
			break;
		    }
		}
	    }
	    if (possible = true) {
		for (int = 0; i < w.length() ; i++) {
		    board[r][c=i] = w.charAt(i);
		}
	    }
	}
    }

    public static void main(String[] args) {
	WordSearch w = new WordSearch();
	System.out.println(w);
	w.addWordH("hello",3,5);
	//w.addWordH("look",3,8);
	w.addWordH("look",3,5);
	//w.addWordH("hello",100,5);
	//w.addWordH("hello",30,555);
				
	System.out.println(w);
    }
}
