package service;

import dependency.Dependency;

public class MyService {

    private final Dependency dependency;

    public MyService(final Dependency dependency) {
        this.dependency = dependency;
    }

    public int eins() {

        return dependency.bar() *dependency.bar()*dependency.bar();
        //return 20;
    }

    public void zwei() {
        dependency.foo(10);
        dependency.foo(47);
        dependency.foo(47);
    }

    public int drei() {
        return dependency.foobar("Hallo Bilbo") + 10;
    }
}
