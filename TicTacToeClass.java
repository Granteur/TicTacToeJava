public class TicTacToeClass{
	
    // Instance Variables
	private char[][] board;
    private int turns;
    boolean isWinner;
    boolean isFull;
    boolean isCat;
    boolean isValid;
    

	// Constructors
	public TicTacToeClass()
	{
		board = new char[3][3];
		turns = 0;

		for ( int r=0; r<3; r++ )
			for ( int c=0; c<3; c++ )
				board[r][c] = ' ';
	}

	// Accessor Methods

	public boolean isWinner( char p )
	{
        /* takes the character passed in, either X 
        or O and returns whichever one has 3 in a 
        row- NOTE, this isn't particularly DRY, so 
        I want to try this again by breaking this
        portion down into their own methods - also 
        I don't like breaking these else-ifs down 
        the way i did.*/
        //first column
        if (p == board[0][0] && p == board[1][0] && p == board[2][0]) {
            return true;
        }
        //second column 
        else if (board[0][1] == p && board[1][1] == p && board[2][1] == p) {
            return true;
        } 
        //last column
        else if (board[0][2] == p && board[1][2] == p && board[2][2] == p) {
            return true;
        } 
        //first (top) row
        else if (board[0][0] == p && board[0][1] == p && board[0][2] == p) {
            return true;
        } 
        //second (middle) row
        else if (board[1][0] == p && board[1][1] == p && board[1][2] == p) {
            return true;
        } 
        //last (bottom) row
        else if (board[2][0] == p && board[2][1] == p && board[2][2] == p) {
            return true;
        } 
        //diagonal from top left -> bottom right
        else if (board[0][0] == p && board[1][1] == p && board[2][2] == p) {
            return true;
        } 
        //diagonal from bottom left -> top right
        else if (board[0][2] == p && board[1][1] == p && board[2][0] == p) {
            return true;
        } else {
            return false;
        }
    }
    

	public boolean isFull()
	{
        if (turns <= 8){
            return false;
        } else {
        return true;
        }
	}

	public boolean isCat()
	{
        /*if all spots are full and neither X nor O 
        wins, returns true*/
		if (isFull() && isWinner('X') && isWinner('O') == false){
            return true;
        } else {
            return false;
        }
	}

	public boolean isValid( int r, int c )
	{
		if ( 0 <= r && r <= 2 && 0 <= c && c <= 2 )
			return true;
		else
			return false;
	}

	public int numTurns()
	{
		return turns;
	}

	public char playerAt( int r, int c )
	{
		if ( isValid(r,c) )
			return board[r][c];
		else
			return '@';
	}

	public void displayBoard()
	{
		System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		System.out.println("    --+-+--");
		System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		System.out.println("    --+-+--");
		System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
		System.out.println("     0 1 2 ");
	}

	// Modifiers
	public void playMove( char p, int r, int c )
	{
        if ((board[r][c] != 'X') && (board[r][c] != 'X')){
            board[r][c] = p;
        }
        turns++;
	}

}