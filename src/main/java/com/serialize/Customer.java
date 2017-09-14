package com.serialize;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
/**
 * Externalizable 
 * @author lengkeng
 *
 */
public class Customer implements Externalizable {
	
	private String name;
    private int age;
    
    public Customer(){
    } 
    
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name=" + name + ", age=" + age;
    }

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("现在执行序列化方法"); 
		out.writeObject(name); 
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		System.out.println("现在执行反序列化方法"); 
		this.name=(String)in.readObject(); 
	}
}
