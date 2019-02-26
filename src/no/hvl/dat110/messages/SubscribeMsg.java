package no.hvl.dat110.messages;

public class SubscribeMsg extends Message {

	// TODO: 
	// Implement objectvariables, constructor, get/set-methods, and toString method

	String topic;
	MessageType type;
	
	public SubscribeMsg(String topic) {
		this.type = MessageType.SUBSCRIBE;
		this.topic = topic;
	}
	
	public MessageType getType() {
		return type;
	}
	
	public String getTopic() {
		return topic;
	}
	
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	@Override
	public String toString() {
		return "Message [type=" + type + ", topic=" + topic + "]";
	};
	
}
