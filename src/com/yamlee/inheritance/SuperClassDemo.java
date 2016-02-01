package com.yamlee.inheritance;

import com.yamlee.log.Logger;

/**
 * Created by yamlee on 15/7/10.
 */
public class SuperClassDemo {
    public SuperClassDemo(){
        Logger.show("supper class constructor!");
    }

    public SuperClassDemo(String msg){
        Logger.show("super constructor with param!");
    }

    public void onTouch(){
        Logger.show("super ontouch!");
    }

    public void dispatchOnTouch() {
        Logger.show("super dispatchOnTouch");
        onTouch();
    }
}
