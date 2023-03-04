/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.jsf;

import java.io.Serializable;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

/**
 *
 * @author empyreanx
 */
@Named
@RequestScoped
public class ExceptionBean implements Serializable {
    private static final long serialVersionUID = 1L;

    public void error() throws CustomException
    {
        throw new CustomException();
    }
}
