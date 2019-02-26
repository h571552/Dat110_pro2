package no.hvl.dat110.messages;

public class CreateTopicMsg extends Message {
	
	// TODO: 
	// Implement objectvariables, constructor, get/set-methods, and toString method
	
	String topic;
	MessageType type;
	
	public CreateTopicMsg(String topic) {
		this.type = MessageType.CREATETOPIC;
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
