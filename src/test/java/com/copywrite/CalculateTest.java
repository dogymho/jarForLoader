package com.copywrite;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Unit test for simple App.
 */
public class CalculateTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void calculate() throws Exception {
        // 在一般情况下，我们是无法获取到 bootstrapClassLoader的
        ClassLoader bootstrapCL = ClassLoader.getSystemClassLoader().getParent();
        System.out.println("bootstrapCL: " + bootstrapCL.toString());

        URL jarPath = new URL("file:/target/jarForLoader-1.0-SNAPSHOT.jar");
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[] {jarPath});
        Class<?> loadClass = urlClassLoader.loadClass("com.copywrite.calculate");
        Object loadClassObj = loadClass.newInstance();
        Integer result = (Integer) loadClass.getMethod("calculateNum", int.class).invoke(loadClassObj, 100);

        System.out.println("Jar invoke result:" + result);
    }
}
