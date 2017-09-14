package com.proxy.test2;

public class HelloTestImpl implements HelloTest {

	@Override
	public void say(String name) {
		System.out.println("Hello:"+name);
	}

}
