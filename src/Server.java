import java.text.DecimalFormat;
import java.util.*;
import java.io.FileNotFoundException;

public class Server {
    private Scanner csvFile;
    private ArrayList<Node> nodeList;


    public Server() throws FileNotFoundException {
        java.io.File path = new java.io.File("data.csv");
        csvFile=new Scanner(path);
        nodeList=new ArrayList<Node>();
        while (hasAnotherLine()){
            String line = getLine();
            String[] list = line.split(",");

            int NodeID=Integer.parseInt(list[0]);
            int yesID=Integer.parseInt(list[1]);
            int noID=Integer.parseInt(list[2]);
            float yesMultiplier=Float.parseFloat(list[3]);
            float noMultiplier=Float.parseFloat(list[4]);
            String question=list[5];

            Node node = new Node(NodeID,yesID,noID,yesMultiplier,noMultiplier,question);
            nodeList.add(node);


        }


    }
    public String getLine(){
        return csvFile.nextLine();
    }

    public double findDecimal(double tempDecimal,int eValue){
        if(eValue==13){
            tempDecimal*=10;
        }
        if (eValue==14){
            tempDecimal*=100;
        }
        if (eValue==16){
            tempDecimal*=10;
        }
        return tempDecimal;
    }
    public String toNormalForm(double value){
        DecimalFormat dc = new DecimalFormat("0.000");
        String stringValue = String.valueOf(value);
        int eValue=Integer.parseInt(stringValue.substring(stringValue.length()-2));
        String subString = stringValue.substring(0,stringValue.length()-3);
        double tempDecimal = Double.parseDouble(subString);
        double alteredDecimal=findDecimal(tempDecimal,eValue);
        String decimal = dc.format(alteredDecimal);

        if(eValue==15 || eValue==16){
            decimal=decimal+" quadrillion";
        }
        if (eValue==14 || eValue==13){
            decimal = decimal+" trillion";
        }
        return decimal;
    }

    public String individualYears (double value){
        int years= (int) Math.round(value/51916.27);
        int count=0;
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(years);


    }
    public Node returnNode(int noID) {
        int checkID = 0;
        for (Node node : nodeList) {
            checkID = node.getNodeID();
            if (checkID==(noID)) {
                return node;
            }
        }
        return null;
    };

    public void Close(){
        csvFile.close();
    }

    public boolean hasAnotherLine(){
        return csvFile.hasNext();
    }

    public int rollingGDPFunc(double value){
        Random random = new Random();
        double rollingGDP = 8471000000000.0;
        int years=0;
        while(rollingGDP <value){
            years+=1;
            double inflationpercentage=random.nextDouble()*(3.3-2.2)+2.2;
            inflationpercentage=(inflationpercentage/100)+1;
            double inflation=8471000000000.0*inflationpercentage;
            rollingGDP +=inflation;

       }
        return years;
    }


    public String toString (){
        String string="";
        for (Node node:nodeList){
            string += node.toString() + "\n";
        }
        return string;
    }
}
