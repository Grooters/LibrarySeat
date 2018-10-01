package io.github.grooters.lller.quote.litepal;

/**
 * Create by 李林浪 in 2018/9/21
 * Elegant Code...
 */
public class LitepaLer{

    private LitepaLer(){ }

    public static LitepaLer getLllGlider(){
        return SingleHolder.litepaLer;
    }

    private static class SingleHolder{
        private static final LitepaLer litepaLer=new LitepaLer();
    }



}
