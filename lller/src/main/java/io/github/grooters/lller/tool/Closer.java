package io.github.grooters.lller.tool;

import java.io.Closeable;
import java.io.IOException;

/**
 * Create by 李林浪 in 2018/9/14
 * Elegant Code...
 */
public class Closer {
    public static void close(Closeable... closeable){
        if(closeable!=null){
            try {
                for(Closeable c:closeable)
                    c.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
