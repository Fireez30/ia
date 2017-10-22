package tp1;

import java.io.BufferedReader;
import java.util.ArrayList;

public class ConstraintEq extends Constraint {
	ArrayList<Object> eq;

	public ConstraintEq(BufferedReader in) throws Exception {
		super(in);
	/*	diff = new ArrayList<Object>();
		for (String v : in.readLine().split(";")) diff.add(v);	// Val1;Val2;...;Val(arity)
	*/
	}

	@Override
	public boolean violation(Assignment a) {
		ArrayList<Object> bar = new ArrayList<Object> ();

		if (a.getVars().containsAll(varList)){
			for (int i=0;i < getArity(); i++){
				bar.add(a.get(varList.get(i)));}

			for (int i=0;i<bar.size()-1; i++)
				for (int j= i+1;j<bar.size();j++)
					if (!bar.get(i).equals(bar.get(j))) return true;
		}
		return false;

	}
	
	public String toString(){
		return "eq "+super.toString();
	}

}
