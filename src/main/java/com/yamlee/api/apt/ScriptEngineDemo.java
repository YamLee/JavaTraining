package com.yamlee.api.apt;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import java.util.List;

/**
 * Created by yamlee on 9/30/16.
 */
public class ScriptEngineDemo {
    public static void main(String[] args) {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        List<ScriptEngineFactory> engineFactories = engineManager.getEngineFactories();
        for (int i = 0; i < engineFactories.size(); i++) {
            ScriptEngineFactory scriptEngineFactory = engineFactories.get(i);
            System.out.println("engine name:" + scriptEngineFactory.getEngineName());
            System.out.println("language name:" + scriptEngineFactory.getLanguageName());
        }
        ScriptEngine scriptEngine = engineManager.getEngineByName("JavaScript");
        System.out.println("JavaScript engine is Null:" + scriptEngine == null);

    }
}
