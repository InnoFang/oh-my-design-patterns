package io.innofang.Prototype;

import java.util.ArrayList;

/**
 * Created by Inno Fang on 2017/2/27.
 */
public class WordDocument implements Cloneable {

    private String text;
    private ArrayList<String> images = new ArrayList<>();

    public WordDocument() {
        System.out.println("-------------init-------------");
    }

    protected WordDocument clone() {
        try {
            WordDocument doc = (WordDocument) super.clone();
            doc.text = this.text;
            doc.images = this.images;
            return doc;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getmText() {
        return text;
    }

    public void setText(String mText) {
        this.text = mText;
    }

    public ArrayList<String> getmImages() {
        return images;
    }

    public void setImages(ArrayList<String> mImages) {
        this.images = mImages;
    }

    public void addImage(String image) {
        images.add(image);
    }

    public void showDocument() {
        System.out.println("-------------Start-------------");
        System.out.println("Text : " + text);
        System.out.println("Image List : ");
        for (String mImage : images) {
            System.out.println("Image Name : " + mImage);
        }
        System.out.println("------------- End -------------");
    }
}
