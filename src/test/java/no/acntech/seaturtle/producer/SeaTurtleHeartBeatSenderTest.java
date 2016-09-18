package no.acntech.seaturtle.producer;

import org.junit.Test;
import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;


public class SeaTurtleHeartBeatSenderTest {

    @Test
    public void sendSimpleEvent(){
        SeaTurtleHeartBeatSender sender = new SeaTurtleHeartBeatSender();

        SeaTurtleHeartBeatEvent event = new SeaTurtleHeartBeatEvent();
        event.setSender("junit test class");
        event.setHeartBeatSource(this.getClass().getSimpleName());
        sender.send(event);

        assertThat(event.getSender(), is(equalTo("junit test class")));
        assertThat(event.getHeartBeatSource(), is(equalTo("SeaTurtleHeartBeatSenderTest")));
    }
}
