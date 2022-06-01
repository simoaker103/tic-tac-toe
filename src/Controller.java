import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
	
	private Model model;
	private View view;

	public Controller(Model model) {
		this.model = model;
	}
	
	public void setView(View view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommandString = e.getActionCommand();
		
		if(actionCommandString != "score") {
			
			int btnNr = Integer.parseInt(actionCommandString);
			
			if(model.switchPlayerTurn(btnNr)) {
				view.updateBoard(e, model.getPlayerTurn());
				
				char result = model.checkForWinner();
				
				if(result != 'A') {
					view.displayWinnerOrDraw(result, model.getPlayerXScore(), model.getPlayerOScore());
				}
				
			}
		} else {
			view.displayScoreFrame();
		}
	}
}