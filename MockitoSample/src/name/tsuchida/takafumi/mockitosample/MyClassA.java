package name.tsuchida.takafumi.mockitosample;

public class MyClassA {
    MyClassB mMyClassB;
    
    public MyClassA(MyClassB b) {
        mMyClassB = b;
    }
  
    public void hoge() {
        if (mMyClassB.getPriority() > 0) {
            handleHighPriority();
        }
        else {
            handleLowPriority();
        }
    }

    public void handleHighPriority() {
    }

    public void handleLowPriority() {
    }
}