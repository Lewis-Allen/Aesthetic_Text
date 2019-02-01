package convert;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.KeyCode;

public class Controller {

    @FXML
    private TextArea input;

    @FXML
    private TextArea output;
    
    @FXML
    private CheckBox autoCopy;

    @FXML
    public void initialize(){
    	input.setOnKeyPressed(event -> {
    		if(event.getCode() == KeyCode.ENTER){
    			output.setText(parseText(input.getText()));
    			event.consume();
    		}
    	});
    }
    
    private String parseText(String text){
    	if(text.length() < 2) return text;
    	
    	char[] charList = text.toCharArray();
    	
    	StringBuilder sb = new StringBuilder();
    	for(char c : charList)
    		sb.append(c).append(" "); 

    	String finalRes = sb.toString().trim();
    	
    	if(autoCopy.isSelected()){
	    	ClipboardContent content = new ClipboardContent();
	    	content.putString(finalRes);
	    	
	    	Clipboard c = Clipboard.getSystemClipboard();
	    	c.setContent(content);
    	}
    	
    	return finalRes;  	
    }
}
