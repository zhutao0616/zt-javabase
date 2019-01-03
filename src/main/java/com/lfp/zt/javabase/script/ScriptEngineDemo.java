package com.lfp.zt.javabase.script;

import javax.script.*;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2018-12-08
 * Copyright: Copyright (c) 2018
 * Company: LFP
 *
 * @author ZhuTao
 * @version 2.0
 */
public class ScriptEngineDemo {

    private ScriptEngine engine;

    public ScriptEngineDemo() {
        ScriptEngineManager manager = new ScriptEngineManager();
        this.engine = manager.getEngineByExtension("js");
    }

    private void evalScript(){
        try {

            engine.put("title", "LIKE");
            engine.eval("var like = '['+ title +']'");
            //engine内容可以直接在外部获取
            System.out.println(engine.get("like"));

            Bindings bindings = new SimpleBindings();
            bindings.put("title", "LOVE");
            engine.eval("var love = '['+ title +']';", bindings);
            //bindings 结果不可以直接在外部获取
            System.out.println(engine.get("love"));

        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    private void writeFile(){
        ScriptContext context = engine.getContext();
        try {
            //context.setWriter(new FileWriter("out.txt"));
            engine.eval("'[HELLO]';");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    private void invokeFunc(){
        String func = "function demo(param){" +
                "   var ret = param + ' LOVE GJJ!';" +
                "   return ret;" +
                "}";
        try {
            engine.eval(func);
            Invocable invocable = (Invocable) engine;
            Object ret = invocable.invokeFunction("demo", "ZT");
            System.out.println(ret);
        } catch (ScriptException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private void invokeInterface(){
        String func = "function handle(param){" +
                "   var ret = param + ' LOVE GJJ!';" +
                "   return ret;" +
                "}";
        try {
            engine.eval(func);
            Invocable invocable = (Invocable) engine;
            Handle handle = invocable.getInterface(Handle.class);
            Object ret = handle.handle("ZT");
            System.out.println(ret);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        ScriptEngineDemo demo = new ScriptEngineDemo();
        demo.invokeInterface();
    }

}
