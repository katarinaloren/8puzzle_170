import java.util.Vector;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

public class Puzzle{
    public int[] tile = new int[9];
    public boolean manhattan = true;       
    public int depth;                                 
    public int parentID=-1;                      

    public Puzzle(int move) {generate(move);}

    public Puzzle(int[] squares, boolean isManhattan){
        for (int i=0; i<9; i++){
            tile[i] = squares[i];
            setHeuristic(isManhattan);
        }
    }

    public Puzzle(int[] squares, boolean isManhattan, int depth){
        this.depth = depth;
        for (int i=0; i<9; i++){
            tile[i] = squares[i];
            setHeuristic(isManhattan);
        }
    }

    public Puzzle(int[] squares, boolean isManhattan, int depth, int parentID){
        this.depth = depth;
        this.parentID = parentID;
        for (int i=0; i<9; i++){
            tile[i] = squares[i];
            setHeuristic(isManhattan);
        }
    }

    public Puzzle(Puzzle puzzle){
        tile = puzzle.copyArray();
        manhattan = puzzle.isManhattan();
        depth = puzzle.getDepth();
        parentID = puzzle.getParentID();
    }

    public void generate(int move){
        
        for (int i=0; i<9; i++){
            tile[i] = i;
		}
       for (int j=0; j<move; j++){
            
            Random rand = new Random();
            int choice = rand.nextInt(4)+1;
            switch (choice){
                case 1:
                    tile = up(tile);
                    break;
                case 2:
                    tile = down(tile);
                    break;
                case 3:
                    tile = left(tile);
                    break;
                case 4:
                    tile = right(tile);
                    break;
            }
        }
    }

    public int[] up(int[] puzzleArray){
        int i;
        int[] temp = new int[puzzleArray.length];
        int holder;
        for (i=0; i<puzzleArray.length; i++)
            temp[i] = puzzleArray[i];
        int square= 0;
        for (i=0; i<temp.length; i++)
        {
            if (temp[i] == 8)
                square = i;
        }
        
        if (square < 3)
            return temp;
        holder = temp[square];
        temp[square] = temp[square-3];
        temp[square-3] = holder;
        return temp;
    }

    public int[] down(int[] puzzleArray){
        int holder;
        int[] temp = new int[puzzleArray.length];
        for (int i=0; i<puzzleArray.length; i++)
            temp[i] = puzzleArray[i];
        int square= 0;
        for (int i=0; i<temp.length; i++)
        {
            if (temp[i] ==8 )
                square = i;
        }

        if (square > 5)
            return temp;
        holder = temp[square];
        temp[square] = temp[square+3];
        temp[square+3] = holder;
        return temp;
    }

    public int[] left(int[] puzzleArray){
        int holder;
        int[] temp = new int[puzzleArray.length];
        for (int i=0; i<puzzleArray.length; i++)
            temp[i] = puzzleArray[i];
        int square= 0;
        for (int i=0; i<temp.length; i++)
        {
            if (temp[i] ==8 )
                square = i;
        }

        if (square%3 == 0)
            return temp;
        holder = temp[square];
        temp[square] = temp[square-1];
        temp[square-1] = holder;
        return temp;
    }

    public int[] right(int[] puzzleArray){
        int holder;
        int[] temp = new int[puzzleArray.length];
        for (int i=0; i<puzzleArray.length; i++)
            temp[i] = puzzleArray[i];
        int square= 0;
        for (int i=0; i<temp.length; i++)
        {
            if (temp[i] ==8 )
                square = i;
        }
        
        if (square%3 == 2)
            return temp;
        holder = temp[square];
        temp[square] = temp[square+1];
        temp[square+1] = holder;
        return temp;
    }

    public String toString(){
        String out = new String();
        for (int i=1; i<=9; i++) {
            if ((i%3) == 1)
                out += " | ";
            if (tile[i-1] == 8)
                out += "  | ";
            else
                out += tile[i-1]+" | ";
            
        }
        return out;
    }

    public boolean equals(Puzzle p){
		return (p.toString().equals(toString()));
	}

    public boolean isManhattan()  {return manhattan;}

    public int getDepth() {return depth;}
    public int getParentID() {return parentID;}
    public void setDepth(int depth) {this.depth = depth;}
    public void setHeuristic(boolean isManhattan){
        manhattan = isManhattan;
    }
    public int getH(){
        if (manhattan){
           return getmanhattanH();
		}
        else
           return getOtherH();
    }

  
    public int getOtherH(){
       
        int wrong = 0;
        for (int i=0; i<9; i++)
            if (tile[i] != i)
                wrong++;
        return wrong;
    }

    public int getmanhattanH(){
        int h = 0;
        int xs, xg, ys, yg;
        for (int i=0; i<9; i++){
            xg = i%3;
            yg = i/3;
            xs = tile[i]%3;
            ys = tile[i]/3;
            h += Math.abs(xs-xg) + Math.abs(ys-yg);
        }
        return h;
    }

    public void addMove() { depth++;}

    public int[] copyArray(){
        int[] temp = new int[9];
        for (int i=0; i<9; i++)
            temp[i] = tile[i];
        return temp;
    }

    public int[] up() { return up(tile);}
    public int[] down() { return down(tile);}
    public int[] left() { return left(tile);}
    public int[] right() {return right(tile);}

	public int[][] changeto2d(){
		int array[][] = new int[3][3];
		int k=0;
		for(int i=0; i<3;i++){
			for(int j=0; j<3;j++){
				array[i][j]=tile[k];
				k++;
			}
		}
		
		return array;
	}

} 