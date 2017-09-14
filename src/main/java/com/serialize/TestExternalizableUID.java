package com.serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestExternalizableUID {

    public static void main(String[] args) throws Exception {
        SerializeCustomer();// 序列化Customer对象
        Customer customer = DeserializeCustomer();// 反序列Customer对象
        System.out.println(customer);
    }

    /**
     * MethodName: SerializeCustomer 
     * Description: 序列化Customer对象
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static void SerializeCustomer() throws FileNotFoundException,
            IOException {
        Customer customer = new Customer("gacl",25);
        // ObjectOutputStream 对象输出流
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
                new File("E:/Customer.txt")));
        out.writeObject(customer);
        System.out.println("Customer对象序列化成功！");
        out.close();
    }

    /**
     * MethodName: DeserializeCustomer 
     * Description: 反序列Customer对象
     * @return
     * @throws Exception
     * @throws IOException
     */
    private static Customer DeserializeCustomer() throws Exception, IOException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(
                new File("E:/Customer.txt")));
        Customer customer = (Customer) in.readObject();
        System.out.println("Customer对象反序列化成功！");
        return customer;
    }
}
