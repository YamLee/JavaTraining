package com.yamlee.inheritance;

import com.yamlee.log.Logger;

/**
 * Created by yamlee on 15/7/10.
 */
public class SubClassDemo extends SuperClassDemo{
    private String filed;
    public SubClassDemo(){

        Logger.show("sub Class constructor!");
    }

    public static void main(String[] args){
        SubClassDemo subClassDemo = new SubClassDemo("subclass constructor with parameter!");
        subClassDemo.dispatchOnTouch();
    }

    public SubClassDemo(String msg){
        super(msg);
        Logger.show(msg);

    }

    @Override
    public void onTouch() {
        Logger.show("sub onTouch!");
    }

    @Override
    public void dispatchOnTouch() {
        super.dispatchOnTouch();
    }
}
