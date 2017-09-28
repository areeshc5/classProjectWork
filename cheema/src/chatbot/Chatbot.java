package chatbot;

public class Chatbot {

	private String username;
	private boolean chatting;
	private Topic areej;
	
	
	public Chatbot() {
		
		areej = new ChatbotAreej();
		username = "Uknown User";
		chatting = true;
	}

	public void startChatting() {
		// whenever you print or get input, use these methods
		ChatbotMain.print("Hi! I am an intelligent machine that can respond to your input. Tell me your name.");
		username = ChatbotMain.getInput();
		
		while(chatting) {
			ChatbotMain.print("What would you like to talk about?");
			String response = ChatbotMain.getInput();
			
			if(areej.isTriggered(response)) {
				chatting = false; //exists the while loop IMPORTANT graded on this
				areej.talk(response);
			}
			else {
				ChatbotMain.print("I'm sorry. I don't understand. I never said I was perfect");
			}
		}
	}

}
