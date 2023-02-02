// class version 52.0 (52)
// access flags 0x1
public class org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141 extends org/yage/tx/ExecutionTimeReality implements net/sf/cglib/proxy/Factory {

  // compiled from: <generated>

  // access flags 0x2
  private Z CGLIB$BOUND

  // access flags 0x9
  public static Ljava/lang/Object; CGLIB$FACTORY_DATA

  // access flags 0x1A
  private final static Ljava/lang/ThreadLocal; CGLIB$THREAD_CALLBACKS

  // access flags 0x1A
  private final static [Lnet/sf/cglib/proxy/Callback; CGLIB$STATIC_CALLBACKS

  // access flags 0x2
  private Lnet/sf/cglib/proxy/MethodInterceptor; CGLIB$CALLBACK_0

  // access flags 0xA
  private static Ljava/lang/Object; CGLIB$CALLBACK_FILTER

  // access flags 0x1A
  private final static Ljava/lang/reflect/Method; CGLIB$sayHello$0$Method

  // access flags 0x1A
  private final static Lnet/sf/cglib/proxy/MethodProxy; CGLIB$sayHello$0$Proxy

  // access flags 0x1A
  private final static [Ljava/lang/Object; CGLIB$emptyArgs

  // access flags 0x1A
  private final static Ljava/lang/reflect/Method; CGLIB$dealTask$1$Method

  // access flags 0x1A
  private final static Lnet/sf/cglib/proxy/MethodProxy; CGLIB$dealTask$1$Proxy

  // access flags 0x1A
  private final static Ljava/lang/reflect/Method; CGLIB$equals$2$Method

  // access flags 0x1A
  private final static Lnet/sf/cglib/proxy/MethodProxy; CGLIB$equals$2$Proxy

  // access flags 0x1A
  private final static Ljava/lang/reflect/Method; CGLIB$toString$3$Method

  // access flags 0x1A
  private final static Lnet/sf/cglib/proxy/MethodProxy; CGLIB$toString$3$Proxy

  // access flags 0x1A
  private final static Ljava/lang/reflect/Method; CGLIB$hashCode$4$Method

  // access flags 0x1A
  private final static Lnet/sf/cglib/proxy/MethodProxy; CGLIB$hashCode$4$Proxy

  // access flags 0x1A
  private final static Ljava/lang/reflect/Method; CGLIB$clone$5$Method

  // access flags 0x1A
  private final static Lnet/sf/cglib/proxy/MethodProxy; CGLIB$clone$5$Proxy

  // access flags 0x8
  static CGLIB$STATICHOOK1()V
   FRAME SAME
    NEW java/lang/ThreadLocal
    DUP
    INVOKESPECIAL java/lang/ThreadLocal.<init> ()V
    PUTSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$THREAD_CALLBACKS : Ljava/lang/ThreadLocal;
    ICONST_0
    ANEWARRAY java/lang/Object
    PUTSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$emptyArgs : [Ljava/lang/Object;
    LDC "org.yage.tx.ExecutionTimeReality$$EnhancerByCGLIB$$20f53141"
    INVOKESTATIC java/lang/Class.forName (Ljava/lang/String;)Ljava/lang/Class;
    ASTORE 0
    ICONST_4
    ANEWARRAY java/lang/String
    DUP
    ICONST_0
    LDC "sayHello"
    AASTORE
    DUP
    ICONST_1
    LDC "(Ljava/lang/String;)V"
    AASTORE
    DUP
    ICONST_2
    LDC "dealTask"
    AASTORE
    DUP
    ICONST_3
    LDC "(Ljava/lang/String;)V"
    AASTORE
    LDC "org.yage.tx.ExecutionTimeReality"
    INVOKESTATIC java/lang/Class.forName (Ljava/lang/String;)Ljava/lang/Class;
    DUP
    ASTORE 1
    INVOKEVIRTUAL java/lang/Class.getDeclaredMethods ()[Ljava/lang/reflect/Method;
    INVOKESTATIC net/sf/cglib/core/ReflectUtils.findMethods ([Ljava/lang/String;[Ljava/lang/reflect/Method;)[Ljava/lang/reflect/Method;
    DUP
    ICONST_0
    AALOAD
    PUTSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$sayHello$0$Method : Ljava/lang/reflect/Method;
    ALOAD 1
    ALOAD 0
    LDC "(Ljava/lang/String;)V"
    LDC "sayHello"
    LDC "CGLIB$sayHello$0"
    INVOKESTATIC net/sf/cglib/proxy/MethodProxy.create (Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sf/cglib/proxy/MethodProxy;
    PUTSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$sayHello$0$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    DUP
    ICONST_1
    AALOAD
    PUTSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$dealTask$1$Method : Ljava/lang/reflect/Method;
    ALOAD 1
    ALOAD 0
    LDC "(Ljava/lang/String;)V"
    LDC "dealTask"
    LDC "CGLIB$dealTask$1"
    INVOKESTATIC net/sf/cglib/proxy/MethodProxy.create (Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sf/cglib/proxy/MethodProxy;
    PUTSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$dealTask$1$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    POP
    BIPUSH 8
    ANEWARRAY java/lang/String
    DUP
    ICONST_0
    LDC "equals"
    AASTORE
    DUP
    ICONST_1
    LDC "(Ljava/lang/Object;)Z"
    AASTORE
    DUP
    ICONST_2
    LDC "toString"
    AASTORE
    DUP
    ICONST_3
    LDC "()Ljava/lang/String;"
    AASTORE
    DUP
    ICONST_4
    LDC "hashCode"
    AASTORE
    DUP
    ICONST_5
    LDC "()I"
    AASTORE
    DUP
    BIPUSH 6
    LDC "clone"
    AASTORE
    DUP
    BIPUSH 7
    LDC "()Ljava/lang/Object;"
    AASTORE
    LDC "java.lang.Object"
    INVOKESTATIC java/lang/Class.forName (Ljava/lang/String;)Ljava/lang/Class;
    DUP
    ASTORE 1
    INVOKEVIRTUAL java/lang/Class.getDeclaredMethods ()[Ljava/lang/reflect/Method;
    INVOKESTATIC net/sf/cglib/core/ReflectUtils.findMethods ([Ljava/lang/String;[Ljava/lang/reflect/Method;)[Ljava/lang/reflect/Method;
    DUP
    ICONST_0
    AALOAD
    PUTSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$equals$2$Method : Ljava/lang/reflect/Method;
    ALOAD 1
    ALOAD 0
    LDC "(Ljava/lang/Object;)Z"
    LDC "equals"
    LDC "CGLIB$equals$2"
    INVOKESTATIC net/sf/cglib/proxy/MethodProxy.create (Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sf/cglib/proxy/MethodProxy;
    PUTSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$equals$2$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    DUP
    ICONST_1
    AALOAD
    PUTSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$toString$3$Method : Ljava/lang/reflect/Method;
    ALOAD 1
    ALOAD 0
    LDC "()Ljava/lang/String;"
    LDC "toString"
    LDC "CGLIB$toString$3"
    INVOKESTATIC net/sf/cglib/proxy/MethodProxy.create (Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sf/cglib/proxy/MethodProxy;
    PUTSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$toString$3$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    DUP
    ICONST_2
    AALOAD
    PUTSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$hashCode$4$Method : Ljava/lang/reflect/Method;
    ALOAD 1
    ALOAD 0
    LDC "()I"
    LDC "hashCode"
    LDC "CGLIB$hashCode$4"
    INVOKESTATIC net/sf/cglib/proxy/MethodProxy.create (Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sf/cglib/proxy/MethodProxy;
    PUTSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$hashCode$4$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    DUP
    ICONST_3
    AALOAD
    PUTSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$clone$5$Method : Ljava/lang/reflect/Method;
    ALOAD 1
    ALOAD 0
    LDC "()Ljava/lang/Object;"
    LDC "clone"
    LDC "CGLIB$clone$5"
    INVOKESTATIC net/sf/cglib/proxy/MethodProxy.create (Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sf/cglib/proxy/MethodProxy;
    PUTSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$clone$5$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    POP
    RETURN
   L0
   FRAME SAME1 java/lang/Throwable
    ATHROW
    MAXSTACK = 6
    MAXLOCALS = 2

  // access flags 0x10
  final CGLIB$sayHello$0(Ljava/lang/String;)V
    ALOAD 0
    ALOAD 1
    INVOKESPECIAL org/yage/tx/ExecutionTimeReality.sayHello (Ljava/lang/String;)V
    RETURN
    MAXSTACK = 2
    MAXLOCALS = 2

  // access flags 0x11
  public final sayHello(Ljava/lang/String;)V
    ALOAD 0
    GETFIELD org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
    DUP
    IFNONNULL L0
    POP
    ALOAD 0
    INVOKESTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$BIND_CALLBACKS (Ljava/lang/Object;)V
    ALOAD 0
    GETFIELD org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
   L0
   FRAME SAME1 net/sf/cglib/proxy/MethodInterceptor
    DUP
    IFNULL L1
    ALOAD 0
    GETSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$sayHello$0$Method : Ljava/lang/reflect/Method;
    ICONST_1
    ANEWARRAY java/lang/Object
    DUP
    ICONST_0
    ALOAD 1
    AASTORE
    GETSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$sayHello$0$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    INVOKEINTERFACE net/sf/cglib/proxy/MethodInterceptor.intercept (Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;Lnet/sf/cglib/proxy/MethodProxy;)Ljava/lang/Object; (itf)
    RETURN
   L1
   FRAME SAME1 net/sf/cglib/proxy/MethodInterceptor
    ALOAD 0
    ALOAD 1
    INVOKESPECIAL org/yage/tx/ExecutionTimeReality.sayHello (Ljava/lang/String;)V
    RETURN
    MAXSTACK = 7
    MAXLOCALS = 2

  // access flags 0x10
  final CGLIB$dealTask$1(Ljava/lang/String;)V
    ALOAD 0
    ALOAD 1
    INVOKESPECIAL org/yage/tx/ExecutionTimeReality.dealTask (Ljava/lang/String;)V
    RETURN
    MAXSTACK = 2
    MAXLOCALS = 2

  // access flags 0x11
  public final dealTask(Ljava/lang/String;)V
    ALOAD 0
    GETFIELD org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
    DUP
    IFNONNULL L0
    POP
    ALOAD 0
    INVOKESTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$BIND_CALLBACKS (Ljava/lang/Object;)V
    ALOAD 0
    GETFIELD org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
   L0
   FRAME SAME1 net/sf/cglib/proxy/MethodInterceptor
    DUP
    IFNULL L1
    ALOAD 0
    GETSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$dealTask$1$Method : Ljava/lang/reflect/Method;
    ICONST_1
    ANEWARRAY java/lang/Object
    DUP
    ICONST_0
    ALOAD 1
    AASTORE
    GETSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$dealTask$1$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    INVOKEINTERFACE net/sf/cglib/proxy/MethodInterceptor.intercept (Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;Lnet/sf/cglib/proxy/MethodProxy;)Ljava/lang/Object; (itf)
    RETURN
   L1
   FRAME SAME1 net/sf/cglib/proxy/MethodInterceptor
    ALOAD 0
    ALOAD 1
    INVOKESPECIAL org/yage/tx/ExecutionTimeReality.dealTask (Ljava/lang/String;)V
    RETURN
    MAXSTACK = 7
    MAXLOCALS = 2

  // access flags 0x10
  final CGLIB$equals$2(Ljava/lang/Object;)Z
    ALOAD 0
    ALOAD 1
    INVOKESPECIAL org/yage/tx/ExecutionTimeReality.equals (Ljava/lang/Object;)Z
    IRETURN
    MAXSTACK = 2
    MAXLOCALS = 2

  // access flags 0x11
  public final equals(Ljava/lang/Object;)Z
    ALOAD 0
    GETFIELD org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
    DUP
    IFNONNULL L0
    POP
    ALOAD 0
    INVOKESTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$BIND_CALLBACKS (Ljava/lang/Object;)V
    ALOAD 0
    GETFIELD org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
   L0
   FRAME SAME1 net/sf/cglib/proxy/MethodInterceptor
    DUP
    IFNULL L1
    ALOAD 0
    GETSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$equals$2$Method : Ljava/lang/reflect/Method;
    ICONST_1
    ANEWARRAY java/lang/Object
    DUP
    ICONST_0
    ALOAD 1
    AASTORE
    GETSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$equals$2$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    INVOKEINTERFACE net/sf/cglib/proxy/MethodInterceptor.intercept (Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;Lnet/sf/cglib/proxy/MethodProxy;)Ljava/lang/Object; (itf)
    DUP
    IFNONNULL L2
    POP
    ICONST_0
    GOTO L3
   L2
   FRAME SAME1 java/lang/Object
    CHECKCAST java/lang/Boolean
    INVOKEVIRTUAL java/lang/Boolean.booleanValue ()Z
   L3
   FRAME SAME1 I
    IRETURN
   L1
   FRAME SAME1 net/sf/cglib/proxy/MethodInterceptor
    ALOAD 0
    ALOAD 1
    INVOKESPECIAL org/yage/tx/ExecutionTimeReality.equals (Ljava/lang/Object;)Z
    IRETURN
    MAXSTACK = 7
    MAXLOCALS = 2

  // access flags 0x10
  final CGLIB$toString$3()Ljava/lang/String;
    ALOAD 0
    INVOKESPECIAL org/yage/tx/ExecutionTimeReality.toString ()Ljava/lang/String;
    ARETURN
    MAXSTACK = 1
    MAXLOCALS = 1

  // access flags 0x11
  public final toString()Ljava/lang/String;
    ALOAD 0
    GETFIELD org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
    DUP
    IFNONNULL L0
    POP
    ALOAD 0
    INVOKESTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$BIND_CALLBACKS (Ljava/lang/Object;)V
    ALOAD 0
    GETFIELD org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
   L0
   FRAME SAME1 net/sf/cglib/proxy/MethodInterceptor
    DUP
    IFNULL L1
    ALOAD 0
    GETSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$toString$3$Method : Ljava/lang/reflect/Method;
    GETSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$emptyArgs : [Ljava/lang/Object;
    GETSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$toString$3$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    INVOKEINTERFACE net/sf/cglib/proxy/MethodInterceptor.intercept (Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;Lnet/sf/cglib/proxy/MethodProxy;)Ljava/lang/Object; (itf)
    CHECKCAST java/lang/String
    ARETURN
   L1
   FRAME SAME1 net/sf/cglib/proxy/MethodInterceptor
    ALOAD 0
    INVOKESPECIAL org/yage/tx/ExecutionTimeReality.toString ()Ljava/lang/String;
    ARETURN
    MAXSTACK = 5
    MAXLOCALS = 1

  // access flags 0x10
  final CGLIB$hashCode$4()I
    ALOAD 0
    INVOKESPECIAL org/yage/tx/ExecutionTimeReality.hashCode ()I
    IRETURN
    MAXSTACK = 1
    MAXLOCALS = 1

  // access flags 0x11
  public final hashCode()I
    ALOAD 0
    GETFIELD org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
    DUP
    IFNONNULL L0
    POP
    ALOAD 0
    INVOKESTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$BIND_CALLBACKS (Ljava/lang/Object;)V
    ALOAD 0
    GETFIELD org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
   L0
   FRAME SAME1 net/sf/cglib/proxy/MethodInterceptor
    DUP
    IFNULL L1
    ALOAD 0
    GETSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$hashCode$4$Method : Ljava/lang/reflect/Method;
    GETSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$emptyArgs : [Ljava/lang/Object;
    GETSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$hashCode$4$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    INVOKEINTERFACE net/sf/cglib/proxy/MethodInterceptor.intercept (Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;Lnet/sf/cglib/proxy/MethodProxy;)Ljava/lang/Object; (itf)
    DUP
    IFNONNULL L2
    POP
    ICONST_0
    GOTO L3
   L2
   FRAME SAME1 java/lang/Object
    CHECKCAST java/lang/Number
    INVOKEVIRTUAL java/lang/Number.intValue ()I
   L3
   FRAME SAME1 I
    IRETURN
   L1
   FRAME SAME1 net/sf/cglib/proxy/MethodInterceptor
    ALOAD 0
    INVOKESPECIAL org/yage/tx/ExecutionTimeReality.hashCode ()I
    IRETURN
    MAXSTACK = 5
    MAXLOCALS = 1

  // access flags 0x10
  final CGLIB$clone$5()Ljava/lang/Object; throws java/lang/CloneNotSupportedException 
    ALOAD 0
    INVOKESPECIAL org/yage/tx/ExecutionTimeReality.clone ()Ljava/lang/Object;
    ARETURN
    MAXSTACK = 1
    MAXLOCALS = 1

  // access flags 0x14
  protected final clone()Ljava/lang/Object; throws java/lang/CloneNotSupportedException 
    ALOAD 0
    GETFIELD org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
    DUP
    IFNONNULL L0
    POP
    ALOAD 0
    INVOKESTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$BIND_CALLBACKS (Ljava/lang/Object;)V
    ALOAD 0
    GETFIELD org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
   L0
   FRAME SAME1 net/sf/cglib/proxy/MethodInterceptor
    DUP
    IFNULL L1
    ALOAD 0
    GETSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$clone$5$Method : Ljava/lang/reflect/Method;
    GETSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$emptyArgs : [Ljava/lang/Object;
    GETSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$clone$5$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    INVOKEINTERFACE net/sf/cglib/proxy/MethodInterceptor.intercept (Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;Lnet/sf/cglib/proxy/MethodProxy;)Ljava/lang/Object; (itf)
    ARETURN
   L1
   FRAME SAME1 net/sf/cglib/proxy/MethodInterceptor
    ALOAD 0
    INVOKESPECIAL org/yage/tx/ExecutionTimeReality.clone ()Ljava/lang/Object;
    ARETURN
    MAXSTACK = 5
    MAXLOCALS = 1

  // access flags 0x9
  public static CGLIB$findMethodProxy(Lnet/sf/cglib/core/Signature;)Lnet/sf/cglib/proxy/MethodProxy;
    ALOAD 0
    INVOKEVIRTUAL java/lang/Object.toString ()Ljava/lang/String;
    DUP
    INVOKEVIRTUAL java/lang/Object.hashCode ()I
    LOOKUPSWITCH
      -1165719922: L0
      -508378822: L1
      771401912: L2
      1826985398: L3
      1913648695: L4
      1984935277: L5
      default: L6
   L0
   FRAME SAME1 java/lang/String
    LDC "dealTask(Ljava/lang/String;)V"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L7
    GETSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$dealTask$1$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    ARETURN
   L1
   FRAME SAME1 java/lang/String
    LDC "clone()Ljava/lang/Object;"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L7
    GETSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$clone$5$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    ARETURN
   L2
   FRAME SAME1 java/lang/String
    LDC "sayHello(Ljava/lang/String;)V"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L7
    GETSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$sayHello$0$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    ARETURN
   L3
   FRAME SAME1 java/lang/String
    LDC "equals(Ljava/lang/Object;)Z"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L7
    GETSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$equals$2$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    ARETURN
   L4
   FRAME SAME1 java/lang/String
    LDC "toString()Ljava/lang/String;"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L7
    GETSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$toString$3$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    ARETURN
   L5
   FRAME SAME1 java/lang/String
    LDC "hashCode()I"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L7
    GETSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$hashCode$4$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    ARETURN
   L6
   FRAME SAME1 java/lang/String
    POP
   L7
   FRAME SAME
    ACONST_NULL
    ARETURN
    MAXSTACK = 2
    MAXLOCALS = 1

  // access flags 0x1
  public <init>()V
    ALOAD 0
    DUP
    INVOKESPECIAL org/yage/tx/ExecutionTimeReality.<init> ()V
    INVOKESTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$BIND_CALLBACKS (Ljava/lang/Object;)V
    RETURN
    MAXSTACK = 2
    MAXLOCALS = 1

  // access flags 0x9
  public static CGLIB$SET_THREAD_CALLBACKS([Lnet/sf/cglib/proxy/Callback;)V
    GETSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$THREAD_CALLBACKS : Ljava/lang/ThreadLocal;
    ALOAD 0
    INVOKEVIRTUAL java/lang/ThreadLocal.set (Ljava/lang/Object;)V
    RETURN
    MAXSTACK = 2
    MAXLOCALS = 1

  // access flags 0x9
  public static CGLIB$SET_STATIC_CALLBACKS([Lnet/sf/cglib/proxy/Callback;)V
    ALOAD 0
    PUTSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$STATIC_CALLBACKS : [Lnet/sf/cglib/proxy/Callback;
    RETURN
    MAXSTACK = 1
    MAXLOCALS = 1

  // access flags 0x1A
  private final static CGLIB$BIND_CALLBACKS(Ljava/lang/Object;)V
    ALOAD 0
    CHECKCAST org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141
    ASTORE 1
    ALOAD 1
    GETFIELD org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$BOUND : Z
    IFNE L0
    ALOAD 1
    ICONST_1
    PUTFIELD org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$BOUND : Z
    GETSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$THREAD_CALLBACKS : Ljava/lang/ThreadLocal;
    INVOKEVIRTUAL java/lang/ThreadLocal.get ()Ljava/lang/Object;
    DUP
    IFNONNULL L1
    POP
    GETSTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$STATIC_CALLBACKS : [Lnet/sf/cglib/proxy/Callback;
    DUP
    IFNONNULL L1
    POP
    GOTO L0
   L1
   FRAME FULL [java/lang/Object org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141] [java/lang/Object]
    CHECKCAST [Lnet/sf/cglib/proxy/Callback;
    ALOAD 1
    SWAP
    ICONST_0
    AALOAD
    CHECKCAST net/sf/cglib/proxy/MethodInterceptor
    PUTFIELD org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
   L0
   FRAME SAME
    RETURN
    MAXSTACK = 3
    MAXLOCALS = 2

  // access flags 0x1
  public newInstance([Lnet/sf/cglib/proxy/Callback;)Ljava/lang/Object;
    ALOAD 1
    INVOKESTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$SET_THREAD_CALLBACKS ([Lnet/sf/cglib/proxy/Callback;)V
    NEW org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141
    DUP
    INVOKESPECIAL org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.<init> ()V
    ACONST_NULL
    INVOKESTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$SET_THREAD_CALLBACKS ([Lnet/sf/cglib/proxy/Callback;)V
    ARETURN
    MAXSTACK = 2
    MAXLOCALS = 2

  // access flags 0x1
  public newInstance(Lnet/sf/cglib/proxy/Callback;)Ljava/lang/Object;
    ICONST_1
    ANEWARRAY net/sf/cglib/proxy/Callback
    DUP
    ICONST_0
    ALOAD 1
    AASTORE
    INVOKESTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$SET_THREAD_CALLBACKS ([Lnet/sf/cglib/proxy/Callback;)V
    NEW org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141
    DUP
    INVOKESPECIAL org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.<init> ()V
    ACONST_NULL
    INVOKESTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$SET_THREAD_CALLBACKS ([Lnet/sf/cglib/proxy/Callback;)V
    ARETURN
    MAXSTACK = 4
    MAXLOCALS = 2

  // access flags 0x1
  public newInstance([Ljava/lang/Class;[Ljava/lang/Object;[Lnet/sf/cglib/proxy/Callback;)Ljava/lang/Object;
    ALOAD 3
    INVOKESTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$SET_THREAD_CALLBACKS ([Lnet/sf/cglib/proxy/Callback;)V
   L0
    NEW org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141
    DUP
    ALOAD 1
    DUP
    ARRAYLENGTH
    TABLESWITCH
      0: L1
      default: L2
   L1
   FRAME FULL [org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141 [Ljava/lang/Class; [Ljava/lang/Object; [Lnet/sf/cglib/proxy/Callback;] [L0 L0 [Ljava/lang/Class;]
    POP
    INVOKESPECIAL org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.<init> ()V
    GOTO L3
   L2
   FRAME FULL [org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141 [Ljava/lang/Class; [Ljava/lang/Object; [Lnet/sf/cglib/proxy/Callback;] [L0 L0 [Ljava/lang/Class;]
    GOTO L4
   L4
   FRAME FULL [org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141 [Ljava/lang/Class; [Ljava/lang/Object; [Lnet/sf/cglib/proxy/Callback;] [L0 L0 [Ljava/lang/Class;]
    POP
    NEW java/lang/IllegalArgumentException
    DUP
    LDC "Constructor not found"
    INVOKESPECIAL java/lang/IllegalArgumentException.<init> (Ljava/lang/String;)V
    ATHROW
   L3
   FRAME SAME1 org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141
    ACONST_NULL
    INVOKESTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$SET_THREAD_CALLBACKS ([Lnet/sf/cglib/proxy/Callback;)V
    ARETURN
    MAXSTACK = 5
    MAXLOCALS = 4

  // access flags 0x1
  public getCallback(I)Lnet/sf/cglib/proxy/Callback;
    ALOAD 0
    INVOKESTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$BIND_CALLBACKS (Ljava/lang/Object;)V
    ALOAD 0
    ILOAD 1
    TABLESWITCH
      0: L0
      default: L1
   L0
   FRAME SAME1 org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141
    GETFIELD org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
    GOTO L2
   L1
   FRAME SAME1 org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141
    POP
    ACONST_NULL
   L2
   FRAME SAME1 net/sf/cglib/proxy/MethodInterceptor
    ARETURN
    MAXSTACK = 2
    MAXLOCALS = 2

  // access flags 0x1
  public setCallback(ILnet/sf/cglib/proxy/Callback;)V
    ILOAD 1
    TABLESWITCH
      0: L0
      default: L1
   L0
   FRAME SAME
    ALOAD 0
    ALOAD 2
    CHECKCAST net/sf/cglib/proxy/MethodInterceptor
    PUTFIELD org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
    GOTO L1
   L1
   FRAME SAME
    RETURN
    MAXSTACK = 2
    MAXLOCALS = 3

  // access flags 0x1
  public getCallbacks()[Lnet/sf/cglib/proxy/Callback;
    ALOAD 0
    INVOKESTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$BIND_CALLBACKS (Ljava/lang/Object;)V
    ALOAD 0
    ICONST_1
    ANEWARRAY net/sf/cglib/proxy/Callback
    DUP
    ICONST_0
    ALOAD 0
    GETFIELD org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
    AASTORE
    ARETURN
    MAXSTACK = 5
    MAXLOCALS = 1

  // access flags 0x1
  public setCallbacks([Lnet/sf/cglib/proxy/Callback;)V
    ALOAD 0
    ALOAD 1
    DUP2
    ICONST_0
    AALOAD
    CHECKCAST net/sf/cglib/proxy/MethodInterceptor
    PUTFIELD org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
    RETURN
    MAXSTACK = 5
    MAXLOCALS = 2

  // access flags 0x8
  static <clinit>()V
    INVOKESTATIC org/yage/tx/ExecutionTimeReality$$EnhancerByCGLIB$$20f53141.CGLIB$STATICHOOK1 ()V
    RETURN
    MAXSTACK = 0
    MAXLOCALS = 0
}
