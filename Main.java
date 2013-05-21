import java.util.ArrayList;

 
public class Main{
	public static ArrayList<int[][]> answers;
	
    public static void main(String[] args){
		answers = new ArrayList<int[][]>();
        Solver puzzle = new Solver(50);
        puzzle.solve();
        answers=puzzle.print();
		PuzzleUI a = new PuzzleUI();
		a.Show(answers);
    }
} 