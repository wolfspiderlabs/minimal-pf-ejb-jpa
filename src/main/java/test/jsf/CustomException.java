/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.jsf;

/**
 *
 * @author empyreanx
 */
public class CustomException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public CustomException() {
        super("Custom error");
    }
    
    public CustomException(String msg) {
        super(msg);
    }
}
