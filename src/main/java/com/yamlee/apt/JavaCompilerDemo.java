package com.yamlee.apt;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * Created by yamlee on 9/30/16.
 */
public class JavaCompilerDemo {
    public static void main(String[] args) {
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
    }
}
