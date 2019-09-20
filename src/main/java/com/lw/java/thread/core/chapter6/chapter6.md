DCL 双检查锁机制实现单例模式

    public class MyObject {
        private volatile static MyObject myObject;
        private MyObject(){}
        //使用双检测机制来解决问题，既保证了不需要同步代码的异步执行性
        //又保证了单例的效果
        public static MyObject getInstance(){
            try{
                if(myObject != null){}
                else{
                    //模拟在创建对象之前做的一些准备性工作
                    Thread.sleep(3_000);
                    synchronized(MyObject.class){
                        if(myObject == null){
                            myObject = new MyObject();
                        }
                    }
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        return myObject;
        
        //Double-Check Locking
    }
 
使用静态内置类实现单例模式：
    
    public class MyObject {
        private static class MyObjectHandler {
            private static MyObject myObject = new MyObject();
        }
        
        public static MyObject getInstance(){
            return MyObjectHandler.myObject;
        }
    }
