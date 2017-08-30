package io.innofang.prototype.example.java;

/**
 * Created by Inno Fang on 2017/2/27.
 */
public class Client {

    public static void main(String[] args) {

        WordDocument originDoc = new WordDocument();
        originDoc.setText("This is a document");
        originDoc.addImage("Image 1");
        originDoc.addImage("Image 2");
        originDoc.addImage("Image 3");
        originDoc.showDocument();

        WordDocument copyDoc = originDoc.clone();
        copyDoc.showDocument();

        copyDoc.setText("This is a copy document");

        // add this line to test the origin document what will happen after the copy document add a image
        copyDoc.addImage("a new Image");

        copyDoc.showDocument();

        originDoc.showDocument();

    }
}
