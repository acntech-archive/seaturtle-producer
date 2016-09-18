package no.acntech.seaturtle.producer;

class SeaTurtleEvent<T> {

    private String sender;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    //@Override
    //public String toString() {
    //    return "SeaTurtleEvent{" +
    //            "sender='" + sender + '\'' +
    //            '}';
    //}
}
