package com.cx.designpatterns.proxy.jdk;

/**
 * @author:wuming
 */
public class JDKTest {

    public static void main(String[] args) throws Exception {

        JDKFather jdkFather = new JDKFather();

        JDKPerson person = (JDKPerson) jdkFather.getInstance(new JDKSon());
        person.findLove();

        person.buy();

        /*JDK58 jdk58 = new JDK58();
        JDKPerson jdkPerson = (JDKPerson)jdk58.getInstance(new JDKSon());
        jdkPerson.buy();*/
    }
}
