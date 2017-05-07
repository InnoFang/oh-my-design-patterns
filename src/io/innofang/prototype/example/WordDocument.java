package io.innofang.prototype.example;

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

    protected WordDocument clone() {
        try {
            WordDocument copy = (WordDocument) super.clone();
            copy.text = this.text;
//            copy.images = this.images;
            copy.images = (ArrayList<String>) this.images.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
