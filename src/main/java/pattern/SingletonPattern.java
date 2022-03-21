package pattern;

/**
 * 单例模式
 */
public class SingletonPattern {
    private static final SingletonPattern singleton = new SingletonPattern();

    public SingletonPattern() {
    }

    public static SingletonPattern getSingleton() {
        return singleton;
    }

    // 类中其他方法，尽量是static
}
