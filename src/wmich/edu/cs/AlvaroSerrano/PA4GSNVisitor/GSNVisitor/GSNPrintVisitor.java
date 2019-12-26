package wmich.edu.cs.AlvaroSerrano.PA4GSNVisitor.GSNVisitor;

public class GSNPrintVisitor implements IVisitorGSN {
	
	@Override
	public Object visitGoal(Goal goal) {
		
		System.out.println("\n==========\nGSN GOAL||\n==========\n\n");
		System.out.println("-----GOAL-----\n");
		
		System.out.println("Goal id: " + goal.getId() + "\n");
		
		if(goal.getDescription().isEmpty()) {
			System.out.println("Goal description: \"\" \n");
		}else {			
			System.out.println("Goal description: " + goal.getDescription() + "\n");
		}
		
		System.out.print("Goal content: ");
		
		for(int i = 0; i < goal.getContent().size(); i++) {
			
			System.out.print(goal.getContent().get(i).getValue() + " ");
			
		}//for
		
		System.out.println();
		
		if(goal.isAssumed) {
			System.out.println("\nAssumed: true\n");
		}else {
			System.out.println("\nAssumed: false\n");
		}
		
		if(goal.isSupported) {
			System.out.println("Supported: true\n");
		}else {
			System.out.println("Supported: false\n");
		}
		
		if(goal.getSourceOf() != null) {
			for(int i = 0; i < goal.getSourceOf().size();i++) {
				if(goal.getSourceOf().get(i) instanceof InContextOf) {
					System.out.println("Goal "+ goal.getId() + " is in context of " + goal.getSourceOf().get(i).getTarget().getId() + "\n");
				}else if (goal.getSourceOf().get(i) instanceof SupportedBy) {
					System.out.println("Goal "+ goal.getId() + " is supported by " + goal.getSourceOf().get(i).getTarget().getId() + "\n");
				}
			}
		}
		
		
		if(goal.getTargetOf() != null) {
			for(int i = 0; i < goal.getTargetOf().size();i++) {
				if(goal.getTargetOf().get(i) instanceof InContextOf) {
					System.out.println("Goal "+ goal.getId() + " is in context of " + goal.getTargetOf().get(i).getSource().getId()+ "\n");
				}else if (goal.getTargetOf().get(i) instanceof SupportedBy) {
					System.out.println("Goal "+ goal.getId() + " supports " + goal.getTargetOf().get(i).getSource().getId()+ "\n");
				}
			}
		}
		
		return null;
	}

	@Override
	public Object visitSolution(Solution solution) {
		
		System.out.println("\n==========\nGSN SOLUTION||\n==========\n\n");
		System.out.println("-----SOLUTION-----\n");

		System.out.println("Solutin id: " + solution.getId() + "\n");	
		
		if(solution.getDescription().isEmpty()) {
			System.out.println("Solution description: \"\" \n");
		}else {			
			System.out.println("Solution description: " + solution.getDescription() + "\n");
		}
		
		System.out.print("Solution content: ");
		
		for(int i = 0; i < solution.getContent().size(); i++) {
			
			System.out.print(solution.getContent().get(i).getValue() + " " );
			
		}//for
		
		System.out.println();
		System.out.println();
		
		if(solution.getSourceOf() != null) {			
			for(int i = 0; i < solution.getSourceOf().size();i++) {
				if(solution.getSourceOf().get(i) instanceof InContextOf) {
					System.out.println("Solution "+ solution.getId() + " is in context of " + solution.getSourceOf().get(i).getTarget().getId()+ "\n");
				}else if (solution.getSourceOf().get(i) instanceof SupportedBy) {
					System.out.println("Solution "+ solution.getId() + " is supported by " + solution.getSourceOf().get(i).getTarget().getId()+ "\n");
				}
			}
		}
		
		if(solution.getTargetOf() != null) {			
			for(int i = 0; i < solution.getTargetOf().size();i++) {
				if(solution.getTargetOf().get(i) instanceof InContextOf) {
					System.out.println("Solution "+ solution.getId() + " is in context of " + solution.getTargetOf().get(i).getSource().getId()+ "\n");
				}else if (solution.getTargetOf().get(i) instanceof SupportedBy) {
					System.out.println("Solution "+ solution.getId() + " supports " + solution.getTargetOf().get(i).getSource().getId()+ "\n");
				}
			}
		}
		
		System.out.println();
		System.out.println();
		
	
		return null;
	}

	@Override
	public Object visitAssumption(Assumption assumption) {
		
		System.out.println("\n==========\nGSN ASSUMPTION||\n==========\n\n");
		System.out.println("-----ASSUMPTION-----\n");

		System.out.println("Assumption id: " + assumption.getId() + "\n");	
		
		if(assumption.getDescription().isEmpty()) {
			System.out.println("Assumption description: \"\" \n");
		}else {			
			System.out.println("Assumption description: " + assumption.getDescription() + "\n");
		}
		
		System.out.print("Assumption content: ");
		
		for(int i = 0; i < assumption.getContent().size(); i++) {
			
			System.out.print(assumption.getContent().get(i).getValue() + " ");
			
		}//for
		
		System.out.println();
		
		if(assumption.getSourceOf() != null) {			
			for(int i = 0; i < assumption.getSourceOf().size();i++) {
				if(assumption.getSourceOf().get(i) instanceof InContextOf) {
					System.out.println("Assumption "+ assumption.getId() + " is in context of " + assumption.getSourceOf().get(i).getTarget().getId()+ "\n");
				}else if (assumption.getSourceOf().get(i) instanceof SupportedBy) {
					System.out.println("Assumption "+ assumption.getId() + " is supported by " + assumption.getSourceOf().get(i).getTarget().getId()+ "\n");
				}
			}
		}
		
		if(assumption.getTargetOf() != null) {			
			for(int i = 0; i < assumption.getTargetOf().size();i++) {
				if(assumption.getTargetOf().get(i) instanceof InContextOf) {
					System.out.println("Assumption "+ assumption.getId() + " is in context of " + assumption.getTargetOf().get(i).getSource().getId()+ "\n");
				}else if (assumption.getTargetOf().get(i) instanceof SupportedBy) {
					System.out.println("Assumption "+ assumption.getId() + " supports " + assumption.getTargetOf().get(i).getSource().getId()+ "\n");
				}
			}
		}
		
		System.out.println();
		System.out.println();
		
		return null;
		
	}

	@Override
	public Object visitJustification(Justification justification) {
		
		System.out.println("\n==========\nGSN JUSTIFICATION||\n==========\n\n");
		System.out.println("-----JUSTIFICATION-----\n");

		System.out.println("Justification id: " + justification.getId() + "\n");	
		
		if(justification.getDescription().isEmpty()) {
			System.out.println("Justification description: \"\" \n");
		}else {			
			System.out.println("Justification description: " + justification.getDescription() + "\n");
		}
		
		System.out.print("Justification content: ");
		
		for(int i = 0; i < justification.getContent().size(); i++) {
			
			System.out.print(justification.getContent().get(i).getValue() + " ");
			
		}//for
		
		System.out.println();
		
		if(justification.getSourceOf() != null) {			
			for(int i = 0; i < justification.getSourceOf().size();i++) {
				if(justification.getSourceOf().get(i) instanceof InContextOf) {
					System.out.println("Justification "+ justification.getId() + " is in context of " + justification.getSourceOf().get(i).getTarget().getId()+ "\n");
				}else if (justification.getSourceOf().get(i) instanceof SupportedBy) {
					System.out.println("Justification "+ justification.getId() + " is supported by " + justification.getSourceOf().get(i).getTarget().getId()+ "\n");
				}
			}
		}
		
		if(justification.getTargetOf() != null) {			
			for(int i = 0; i < justification.getTargetOf().size();i++) {
				if(justification.getTargetOf().get(i) instanceof InContextOf) {
					System.out.println("Justification "+ justification.getId() + " is in context of " + justification.getTargetOf().get(i).getSource().getId()+ "\n");
				}else if (justification.getTargetOf().get(i) instanceof SupportedBy) {
					System.out.println("Justification "+ justification.getId() + " supports " + justification.getTargetOf().get(i).getSource().getId()+ "\n");
				}
			}
		}
		
		System.out.println();
		System.out.println();
		
		return null;
		
	}

	@Override
	public Object visitStrategy(Strategy strategy) {
		
		System.out.println("\n==========\nGSN STRATEGY||\n==========\n\n");
		System.out.println("-----STRATEGY-----\n");

		System.out.println("Strategy id: " + strategy.getId() + "\n");
	
		
		if(strategy.getDescription().isEmpty()) {
			System.out.println("Strategy description: \"\" \n");
		}else {			
			System.out.println("Strategy description: " + strategy.getDescription() + "\n");
		}
		
		System.out.print("Strategy content: ");
		
		for(int i = 0; i < strategy.getContent().size(); i++) {
			
			System.out.print(strategy.getContent().get(i).getValue() + " ");
			
		}//for
		
		
		System.out.println();
		
		if(strategy.getSourceOf() != null) {			
			for(int i = 0; i < strategy.getSourceOf().size();i++) {
				if(strategy.getSourceOf().get(i) instanceof InContextOf) {
					System.out.println("Strategy "+ strategy.getId() + " is in context of " + strategy.getSourceOf().get(i).getTarget().getId()+ "\n");
				}else if (strategy.getSourceOf().get(i) instanceof SupportedBy) {
					System.out.println("Strategy "+ strategy.getId() + " is supported by " + strategy.getSourceOf().get(i).getTarget().getId()+ "\n");
				}
			}
		}
		
		if(strategy.getTargetOf() != null) {			
			for(int i = 0; i < strategy.getTargetOf().size();i++) {
				if(strategy.getTargetOf().get(i) instanceof InContextOf) {
					System.out.println("Strategy "+ strategy.getId() + " is in context of " + strategy.getTargetOf().get(i).getSource().getId()+ "\n");
				}else if (strategy.getTargetOf().get(i) instanceof SupportedBy) {
					System.out.println("Strategy "+ strategy.getId() + " supports " + strategy.getTargetOf().get(i).getSource().getId()+ "\n");
				}
			}
		}
		
		System.out.println();
		System.out.println();
		
		return null;
		
	}

	@Override
	public Object visitContext(Context context) {
		
		System.out.println("\n\n==========\nGSN CONTEXT||\n==========\n\n");
		System.out.println("-----CONTEXT-----\n");

		System.out.println("Context id: " + context.getId() + "\n");
		
		
		if(context.getDescription().isEmpty()) {
			System.out.println("Context description: \"\" \n");
		}else {			
			System.out.println("Context description: " + context.getDescription() + "\n");
		}
		
		System.out.print("Context content: ");
		
		for(int i = 0; i < context.getContent().size(); i++) {
			
			System.out.print(context.getContent().get(i).getValue() + " ");
			
		}//for
		
		System.out.println();
		
		if(context.getSourceOf() != null) {			
			for(int i = 0; i < context.getSourceOf().size();i++) {
				if(context.getSourceOf().get(i) instanceof InContextOf) {
					System.out.println("Context "+ context.getId() + " is in context of " + context.getSourceOf().get(i).getTarget().getId()+ "\n");
				}else if (context.getSourceOf().get(i) instanceof SupportedBy) {
					System.out.println("Context "+ context.getId() + " is supported by " + context.getSourceOf().get(i).getTarget().getId()+ "\n");
				}
			}
		}
		
		if(context.getTargetOf() != null) {			
			for(int i = 0; i < context.getTargetOf().size();i++) {
				if(context.getTargetOf().get(i) instanceof InContextOf) {
					System.out.println("Context"+ context.getId() + " is in context of " + context.getTargetOf().get(i).getSource().getId()+ "\n");
				}else if (context.getTargetOf().get(i) instanceof SupportedBy) {
					System.out.println("Context"+ context.getId() + " supports " + context.getTargetOf().get(i).getSource().getId()+ "\n");
				}
			}
		}
		
		System.out.println();
		System.out.println();
	
		return null;
		
	}

	@Override
	public Object visitSupportedBy(SupportedBy supportedBy) {
		
		System.out.println("\n==========\nGSN SUPPORTEDBY||\n==========\n\n");
		System.out.println("-----SUPPORTEDBY-----\n");


		System.out.println("SupportedBy id: " + supportedBy.getId() + "\n");

		if(supportedBy.getDescription().isEmpty()) {
			System.out.println("SupportedBy description: \"\" \n");
		}else {			
			System.out.println("SupportedBy description: " + supportedBy.getDescription() + "\n");
		}
		
		System.out.println("SupportedBy content:  \n");
		
		System.out.println("SupportedBy link between source "   + supportedBy.getSource().getId() + " and target " + supportedBy.getTarget().getId() + "\n");
		
		System.out.println();
		System.out.println();
	
		return null;
	}

	@Override
	public Object visitInContextOf(InContextOf inContextOf) {
		
		System.out.println("\n==========\nGSN INCONTEXTOF||\n==========\n\n");
		System.out.println("-----INCONTEXTOF-----\n");
		
		System.out.println("InContextOf id: " + inContextOf.getId() + "\n");
			
		if(inContextOf.getDescription().isEmpty()) {
			System.out.println("InContextOf description: \"\" \n");
		}else {			
			System.out.println("InContextOf description: " + inContextOf.getDescription() + "\n");
		}
		
		System.out.println("InContextOf content: \n");
		
		System.out.println("InContextOf link between source " + inContextOf.getSource().getId() + " and target " + inContextOf.getTarget().getId() + "\n");

		System.out.println();
		System.out.println();
	
		return null;
		
	}
	
	//************************************************************************************************************************
	
	
}//GSNPrintVisitor
