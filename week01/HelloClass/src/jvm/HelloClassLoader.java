package jvm;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * ClassName:HelloClasLoader
 * Package:jvm
 * Description:此处编写类的描述内容
 *
 * @Date:2022-03-05 21:40
 * @Author:jiayz,JYZ
 */
public class HelloClassLoader extends ClassLoader{
    public static void main(String[] args) {
        try {
            Class<?> helloClass = new HelloClassLoader().findClass("Hello");
            Method helloMethod = helloClass.getMethod("hello");
            helloMethod.invoke(helloClass.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected Class<?> findClass(String name) {
        //String myPath = Thread.currentThread().getContextClassLoader().getResource("Hello.xlass").getPath();
        String myPath = this.getClass().getResource("/Hello.xlass").getPath();
        //System.out.println(myPath);
        byte[] cLassBytes = null;
        Path path = null;
        try {
            File f = new File(myPath);
            path = f.toPath();
            cLassBytes = Files.readAllBytes(path);
        } catch (IOException  e) {
            e.printStackTrace();
        }
        if(cLassBytes !=null){
            for(int i = 0;i<cLassBytes.length;i++){
                cLassBytes[i] = (byte)(255- cLassBytes[i]);
            }

        }
        Class clazz = defineClass(name, cLassBytes, 0, cLassBytes.length);
        return clazz;
    }

}
