package org.yage.loadorder;

/**
 * @author: Yage
 * @create: 2022-08-23 11:00
 */
class Parent {
    public static Print A_sv1 = new Print("A_sv1");
    public Print A_cv1 = new Print("A_cv1");
    public int num = 66;
    public int num2 = 88;
    static{
        new Print("A_ss1");
    }
    public static Print A_sv2 = new Print("A_sv2");
    {
        new Print("A_cs1");
    }
    Parent(){
        new Print("A_s");
        show();
    }
    public Print A_cv2 = new Print("A_cv2");
    {
        new Print("A_cs2");
    }
    static{
        new Print("A_ss2");
    }
    public void show(){
        new Print(num);
        new Print(num2);
    }
}
