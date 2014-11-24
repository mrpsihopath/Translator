package lab2.syntaxAnalyzer;

import codereader.ErrorHandler;
import codereader.OutputHandler;

public class AutomatSyntaxAnalizer {

	OutputHandler outputHandler;
	AutomatHandler aHandler;

	public AutomatSyntaxAnalizer(OutputHandler outputHandler) {
		this.outputHandler = outputHandler;
	}

	public void analizeSyntax() {
		if (!outputHandler.getCodeWasTranslated()) {
			ErrorHandler.error(99, 0);
			return;
		}
		aHandler = new AutomatHandler(outputHandler);
		aHandler.runMain();
		if (aHandler.getErrorCode() != 0)
			ErrorHandler
					.error(aHandler.getErrorCode(), aHandler.getErrorLine());
		else
			System.out.println("Finished, yay!");
	}

}
