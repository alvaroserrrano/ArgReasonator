package wmich.edu.cs.AlvaroSerrano.PA4GSNVisitor.GSNVisitor;

public interface IVisitorGSN {

	public Object visitGoal (Goal goal);
	public Object visitAssumption (Assumption assumption);
	public Object visitJustification (Justification justification);
	public Object visitStrategy (Strategy strategy);
	public Object visitContext (Context context);
	public Object visitSolution (Solution solution);
	public Object visitSupportedBy(SupportedBy supportedBy);
	public Object visitInContextOf (InContextOf inContextOf);
	
}
