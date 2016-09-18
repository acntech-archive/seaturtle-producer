package no.acntech.seaturtle.producer;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import javax.ws.rs.core.MediaType;

class SeaTurtleHeartBeatSender {

    public void send(SeaTurtleHeartBeatEvent message) {

        postToReceiver(message);
    }

    private void postToReceiver(SeaTurtleHeartBeatEvent message) {

        try {

            ClientConfig clientConfig = new DefaultClientConfig();

            clientConfig.getFeatures().put(
                    JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

            Client client = Client.create(clientConfig);

            WebResource webResource = client
                    .resource("http://dev.acntech.no:8080/seaturtle-receiver-1.0.0-SNAPSHOT/api/heartbeat");

            ClientResponse response = webResource.accept("application/json")
                    .type("application/json").post(ClientResponse.class, message);

            System.out.println("Output from Server .... \n");
            String output = response.getEntity(String.class);
            System.out.println(output);


            if (response.getStatus() != 201) {
                System.out.println("Failed : HTTP error code : " + response.getStatus());
                throw new SeaTurtleSendingException("Event not received by event handler. See log for more information.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SeaTurtleSendingException("Event not sent to receiver. See log for more information.");
        }
    }
}
