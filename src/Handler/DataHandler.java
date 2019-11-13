package Handler;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DataHandler implements HandlerInterface {

    public DataHandler() {
    }

    @Override
    public <T> ArrayList<T> readSerializedObject(String filename) {
        final String PATH = System.getProperty("user.dir")+"/src/Data/";
        ArrayList<T> pDetails = null;
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(PATH + filename);
            in = new ObjectInputStream(fis);
            pDetails = (ArrayList) in.readObject();
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        // print out the size
        //System.out.println(" Details Size: " + pDetails.size());
        //System.out.println();    catch (FileNotFoundException ex){
        //			return (ArrayList)pDetails;
        return pDetails;
    }

    public HashMap readSerializedHashMap(String filename) {
        final String PATH = System.getProperty("user.dir")+"/src/Data/";
        HashMap pDetails = null;
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(PATH + filename);
            in = new ObjectInputStream(fis);
            pDetails = (HashMap) in.readObject();
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        // print out the size
        //System.out.println(" Details Size: " + pDetails.size());
        //System.out.println();    catch (FileNotFoundException ex){
        //			return (ArrayList)pDetails;
        return pDetails;
    }

    @Override
    public <T> void writeSerializedObject(String filename, ArrayList<T> list) {
        final String PATH = System.getProperty("user.dir")+"/src/Data/";
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(PATH + filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(list);
            out.close();
            //	System.out.println("Object Persisted");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public <T> void writeSerializedHashMap(String filename, HashMap list) {
        final String PATH = System.getProperty("user.dir")+"/src/Data/";
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(PATH + filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(list);
            out.close();
            //	System.out.println("Object Persisted");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

