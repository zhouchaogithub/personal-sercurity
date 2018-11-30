package com.zc.security.core.properties;

public class ImageCodeProperties extends  SmsCodeProperties{

    private int width = 67;
    private int height = 23;
    private int lineCount = 80;

    public ImageCodeProperties(){
        setCodeCount(4);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public int getLineCount() {
        return lineCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }
}
