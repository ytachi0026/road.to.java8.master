package java8.in.action.appd;

import java.util.function.Function;

public class Lambda {
    Function<Object, String> f = obj -> obj.toString();
}
