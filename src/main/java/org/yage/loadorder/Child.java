package org.yage.loadorder;

/**
 * @author: Yage
 * @create: 2022-08-23 11:09
 */
class Child extends Parent {
    public static Print B_sv1 = new Print("B_sv1");
    public Print B_cv1 = new Print("B_cv1");
    public int num = 99;
    static{
        new Print("B_ss1");
    }
    public static Print B_sv2 = new Print("B_sv2");
    {
        new Print("B_cs1");
    }
    Child(){
        new Print("B_s");
        new Print(num);
    }
    public Print B_cv2 = new Print("B_cv2");
    {
        new Print("B_cs2");
    }
    static{
        new Print("B_ss2");
    }
    public void show(){
        new Print(num);
        new Print(num2);
        super.show();
    }
}