package no.hvl.dat110.broker;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import no.hvl.dat110.common.Logger;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messagetransport.Connection;

public class Storage {

	protected ConcurrentHashMap<String, Set<String>> subscriptions;
	protected ConcurrentHashMap<String, ClientSession> clients;
	
	protected ConcurrentHashMap<String, Set<Message>> pendingMessages;

	public Storage() {
		subscriptions = new ConcurrentHashMap<String, Set<String>>();
		clients = new ConcurrentHashMap<String, ClientSession>();
		pendingMessages = new ConcurrentHashMap<String, Set<Message>>();
	}

	public Collection<ClientSession> getSessions() {
		return clients.values();
	}

	public Set<String> getTopics() {

		return subscriptions.keySet();

	}
	
	public boolean SessionExists(String user) {
		
		return clients.containsKey(user);
	}
	
	public void bufferMessage(String user, Message message) {

		pendingMessages.get(user).add(message);
	}

	public ClientSession getSession(String user) {

		return clients.get(user);
	}

	public Set<String> getSubscribers(String topic) {

		return (subscriptions.get(topic));

	}
	
	public Set<Message> getPendingMessages(String user) {

		Set<Message> set = null;
		
		if(pendingMessages.containsKey(user))
			set = pendingMessages.get(user);
		
		return set;

	}

	public void addClientSession(String user, Connection connection) {

		// add corresponding client session to the storage
		
		clients.put(user, new ClientSession(user, connection));
	}

	public void removeClientSession(String user) {

		// remove client session for user from the storage

		clients.remove(user);
		
	}
	
	public void addPendingUser (String user) {

		pendingMessages.put( user, new HashSet<Message>() );
	}
	
	public void removePendingUser (String user) {

		pendingMessages.remove(user);
	}

	public void createTopic(String topic) {

		// create topic in the storage
		
		subscriptions.put(topic, new HashSet<String>());
	}

	public void deleteTopic(String topic) {

		// delete topic from the storage

		subscriptions.remove(topic);
		
	}

	public void addSubscriber(String user, String topic) {

		// add the user as subscriber to the topic
		
		subscriptions.get(topic).add(user);
		
	}

	public void removeSubscriber(String user, String topic) {

		// remove the user as subscriber to the topic

		subscriptions.get(topic).remove(user);
	}
}
