package no.acntech.seaturtle.producer;

public class SeaTurtleHeartBeatEvent extends SeaTurtleEvent {

    private String heartBeatSource;

    public String getHeartBeatSource() {
        return heartBeatSource;
    }

    public void setHeartBeatSource(String heartBeatSource) {
        this.heartBeatSource = heartBeatSource;
    }

    //@Override
    //public String toString() {
    //    return "SeaTurtleHeartBeatEvent{" +
    //            "inherited from='" + super.toString() + '\'' +
    //            "heartBeatSource='" + heartBeatSource + '\'' +
    //            '}';
    //}


}
