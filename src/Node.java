public class Node {

    private int NodeID;
    private int yesID;
    private int noID;
    private float yesMultiplier;
    private float noMultiplier;
    private String question;


    public Node(int nodeID, int yesID, int noID, float yesMultiplier, float noMultiplier, String question) {
        NodeID = nodeID;
        this.yesID = yesID;
        this.noID = noID;
        this.yesMultiplier = yesMultiplier;
        this.noMultiplier = noMultiplier;
        this.question = question;
    }

    @Override
    public String toString() {
        return "Node{" +
                "NodeID=" + NodeID +
                ", yesID=" + yesID +
                ", noID=" + noID +
                ", yesMultiplier=" + yesMultiplier +
                ", noMultiplier=" + noMultiplier +
                ", question='" + question + '\'' +
                '}';
    }

    public int getNodeID() {
        return NodeID;
    }

    public void setNodeID(int nodeID) {
        NodeID = nodeID;
    }

    public int getYesID() {
        return yesID;
    }

    public void setYesID(int yesID) {
        this.yesID = yesID;
    }

    public int getNoID() {
        return noID;
    }

    public void setNoID(int noID) {
        this.noID = noID;
    }

    public float getYesMultiplier() {
        return yesMultiplier;
    }

    public void setYesMultiplier(float yesMultiplier) {
        this.yesMultiplier = yesMultiplier;
    }

    public float getNoMultiplier() {
        return noMultiplier;
    }

    public void setNoMultiplier(float noMultiplier) {
        this.noMultiplier = noMultiplier;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
