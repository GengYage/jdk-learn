package org.yage.classloader;

/**
 * @author: Yage
 * @create: 2023-01-13 16:03
 */
public class MyClassLoader extends ClassLoader {
    public MyClassLoader(ClassLoader a) {
        super(a);
    }

    public MyClassLoader() {

    }

    @Override
    protected Class<?> findClass(String name) {
        AsmCreateObj asmCreateObj = new AsmCreateObj();
        // asm 生成字节码 包名 asm.String
        byte[] newClass = asmCreateObj.createNewClass();

        return defineClass(null, newClass, 0, newClass.length);
    }

    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader(null);
        Class<?> aaa = myClassLoader.loadClass("aaa");

        System.out.println(aaa);
        System.out.println(aaa.getClassLoader()); // MyClassLoader
        System.out.println(aaa.getClassLoader().getParent()); // AppClassLoader
        System.out.println(aaa.getClassLoader().getParent().getParent()); // ExtClassLoader
        System.out.println(aaa.getClassLoader().getParent().getParent().getParent()); // null BootStrapClassLoader
    }
}
