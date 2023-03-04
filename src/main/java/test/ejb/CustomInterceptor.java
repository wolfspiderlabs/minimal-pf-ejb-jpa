/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.ejb;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;
import test.jsf.CustomException;
import test.jsf.SessionBean;

/**
 *
 * @author empyreanx
 */
public class CustomInterceptor {
    @Inject
    SessionBean sessionBean;

    @AroundInvoke
    public Object intercept(InvocationContext ctx) throws Exception {
        if (sessionBean.getUserId() == null) {
            //throw new TestException("Null ID");
            throw new CustomException("Null ID");
        } else {
            return ctx.proceed();
        }
    }
}
