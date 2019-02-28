package no.hvl.dat110.broker.processing.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import no.hvl.dat110.broker.Broker;
import no.hvl.dat110.broker.Dispatcher;
import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.PublishMsg;

public class Test8MessageBuffer extends Test0Base {

	private String TESTTOPIC = "testtopic";
	public static String TOPIC = "testtopic";
	
	@Test
	public void test() {
		
		
		broker.setMaxAccept(2);
		
		Client client1 = new Client("client1", BROKER_TESTHOST, BROKER_TESTPORT);
		Client client2 = new Client("client2", BROKER_TESTHOST, BROKER_TESTPORT);
		
		client1.connect();
		pause(2000);
		client2.connect();
		pause(2000);
		
		client1.createTopic(TESTTOPIC);
		pause(2000);
		client1.subscribe(TESTTOPIC);
		pause(2000);
		
		client1.disconnect();
		pause(2000);
		client2.publish(TESTTOPIC, "test message");
		client1.connect();
		pause(2000);
		
		PublishMsg msg = (PublishMsg)client1.receive();
		
		client1.disconnect();
		client2.disconnect();
		
		assertEquals("test message", msg.getMessage());
	
	}
	
	private void pause(long l) {
		try {
			Thread.sleep(l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
