package no.hvl.dat110.messages;

public class PublishMsg extends Message {
	
	// TODO: 
	// Implement objectvariables, constructor, get/set-methods, and toString method
	
	String message;
	MessageType type;
	
	public PublishMsg(String message) {
		this.type = MessageType.PUBLISH;
		this.message = message;
	}
	
	public MessageType getType() {
		return type;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Message [type=" + type + ", topic=" + message + "]";
	};
	
}
