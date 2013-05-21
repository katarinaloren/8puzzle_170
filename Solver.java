import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

public class Solver{
    public int cost = 0;
    public ArrayList<Puzzle>CloseList;
    public ArrayList<Puzzle>OpenList;
    public Puzzle p;
	public ArrayList<int[][]> answers = new ArrayList<int[][]>();

    public Solver(int list){
        CloseList = new ArrayList<Puzzle>();
        OpenList = new ArrayList<Puzzle>();
        p = new Puzzle(list);
        OpenList.add(p);
    }

    public Solver(Puzzle puzzle){
        CloseList = new ArrayList<Puzzle>();
        OpenList = new ArrayList<Puzzle>();
        p = new Puzzle(puzzle);
        OpenList.add(p);
    }

    public void solve()  {while (expandNodes(p)) {p=findBestNode();}}

    public int getCost() {return (CloseList.size() + OpenList.size());}

    public Puzzle findBestNode(){
        Puzzle best;
        Puzzle test;
        
        if (OpenList.size()==0)
            best = (Puzzle)CloseList.get(0);
        
        else
            best = (Puzzle)OpenList.get(0);
        for (int i=1; i<OpenList.size();i++)
        {
            test = (Puzzle)OpenList.get(i);
            
            int bestH = best.getDepth() + best.getH();
            int testH = test.getDepth() + test.getH();
            
            if (testH < bestH)
                best = test;
        }
        return best;
    }

    public boolean expandNodes(Puzzle p){
        int[] test;
        Puzzle temp;
       
        OpenList.remove(p);
        
        int parentID = CloseList.size();
        CloseList.add(p);
        
        if (p.getH() == 0){
            return false;
		}
        test = p.up();
        temp = new Puzzle(test, p.isManhattan(), p.getDepth(), parentID);
        addtoOpen(temp);
        test = p.down();
        temp = new Puzzle(test, p.isManhattan(), p.getDepth(), parentID);
        addtoOpen(temp);
        test = p.left();
        temp = new Puzzle(test, p.isManhattan(), p.getDepth(), parentID);
        addtoOpen(temp);
        test = p.right();
        temp = new Puzzle(test, p.isManhattan(), p.getDepth(), parentID);
        addtoOpen(temp);
        return true;
    }

    public void addtoOpen(Puzzle p){
        if (!nodeRepeated(p)){
            p.addMove();
            OpenList.add(p);
        }
    }

    public boolean nodeRepeated (Puzzle node)
    {
        for (int i=0; i<CloseList.size(); i++)
        {
            if (node.equals((Puzzle)CloseList.get(i)))
                return true;
        }
        return false;
    }

    public ArrayList<int[][]> print(){
        ArrayList<Puzzle> list = new ArrayList<Puzzle>();
        Puzzle node = getPuzzleSolution();
		Puzzle me;
		int array[][]= new int[3][3];
        list.add(node);
        
        int parentID = node.getParentID();
        while (parentID != -1){
            node = (Puzzle)CloseList.get(parentID);
            list.add(node);
            parentID = node.getParentID();
        }

        for (int i = 1; i <= list.size();  i++){
			if (i ==1){
					
				me=(Puzzle)list.get(list.size()-i);
				array=me.changeto2d();
				answers.add(array);
				
			}
			else{
				me=(Puzzle)list.get(list.size()-i);
				array=me.changeto2d();
				answers.add(array);
			}
	    }
  		return answers;
	}

    public Puzzle getPuzzleSolution(){
		int size=CloseList.size();
        return (Puzzle)CloseList.get(size-1);
    }

}