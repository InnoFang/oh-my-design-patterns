package io.innofang.Prototype;

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
        copyDoc.showDocument();

        originDoc.showDocument();

    }
}
