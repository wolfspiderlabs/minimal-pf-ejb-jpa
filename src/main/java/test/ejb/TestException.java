/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.ejb;

import java.lang.Exception;

/**
 *
 * @author empyreanx
 */
public class TestException extends Exception {
    public TestException(String msg) {
        super(msg);
    }
    
    public TestException() {
        super("Test");
    }
}
