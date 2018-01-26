package com.ek.guide.rhino;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Test1 {
	public static void main(String[] args) {
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");
	}

}
