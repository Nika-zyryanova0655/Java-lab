import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class CacheUtil {

    public static <T> T cache(T obj) {
        return (T) Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new CacheInvocationHandler(obj)
        );
    }

    private static class CacheInvocationHandler implements InvocationHandler {
        private final Object target;
        private final Map<Method, Object> cache = new HashMap<>();
        private String lastState;

        public CacheInvocationHandler(Object target) {
            this.target = target;
            this.lastState = serializeState(target);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.isAnnotationPresent(Invoke.class) && (args == null || args.length == 0)) {
                String currentState = serializeState(target);
                if (!cache.containsKey(method) || !currentState.equals(lastState)) {
                    Object result = method.invoke(target, args);
                    cache.put(method, result);
                    lastState = currentState;
                    return result;
                } else {
                    return cache.get(method);
                }
            } else {
                return method.invoke(target, args);
            }
        }

        private String serializeState(Object obj) {
            // Простая сериализация состояния объекта
            // Это можно улучшить в зависимости от требований
            return obj.toString();
        }
    }
}


// anotation cache

//public class CacheUtil {
//
//    public static Object[] cache(Object... objects) {
//        for (int i = 0; i < objects.length; i++) {
//            Object obj = objects[i];
//            if (obj.getClass().isAnnotationPresent(Cache.class)) {
//                Cache cacheAnnotation = obj.getClass().getAnnotation(Cache.class);
//                String[] cacheParams = cacheAnnotation.value();
//                if (cacheParams.length > 0) {
//                    // Handle cache parameters if needed
//                    System.out.println("Caching with parameters: " + Arrays.toString(cacheParams));
//                }
//                if (obj.getClass().isInterface()) {
//                    objects[i] = createInterfaceProxy(obj);
//                } else {
//                    objects[i] = createClassProxy(obj);
//                }
//            }
//        }
//        return objects;
//    }
//
//    private static <T> T createInterfaceProxy(T obj) {
//        return (T) Proxy.newProxyInstance(
//                obj.getClass().getClassLoader(),
//                obj.getClass().getInterfaces(),
//                new CacheInvocationHandler(obj)
//        );
//    }
//
//    private static <T> T createClassProxy(T obj) {
//        return (T) Proxy.newProxyInstance(
//                obj.getClass().getClassLoader(),
//                obj.getClass().getInterfaces(),
//                new CacheInvocationHandler(obj)
//        );
//    }
//
//    private static class CacheInvocationHandler implements InvocationHandler {
//        private final Object target;
//        private final Map<Method, Object> cache = new HashMap<>();
//        private String lastState;
//
//        public CacheInvocationHandler(Object target) {
//            this.target = target;
//            this.lastState = serializeState(target);
//        }
//
//        @Override
//        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//            if (method.isAnnotationPresent(Invoke.class) && (args == null || args.length == 0)) {
//                String currentState = serializeState(target);
//                if (!cache.containsKey(method) || !currentState.equals(lastState)) {
//                    Object result = method.invoke(target, args);
//                    cache.put(method, result);
//                    lastState = currentState;
//                    return result;
//                } else {
//                    return cache.get(method);
//                }
//            } else {
//                return method.invoke(target, args);
//            }
//        }
//
//        private String serializeState(Object obj) {
//            // Простая сериализация состояния объекта
//            // Это можно улучшить в зависимости от требований
//            return obj.toString();
//        }
//    }
//}



//     аннотация invoke
//public class CacheUtil {
//
//    public static <T> T cache(T obj) {
//        if (obj.getClass().isInterface()) {
//            return createInterfaceProxy(obj);
//        } else {
//            return createClassProxy(obj);
//        }
//    }
//
//    private static <T> T createInterfaceProxy(T obj) {
//        return (T) Proxy.newProxyInstance(
//                obj.getClass().getClassLoader(),
//                obj.getClass().getInterfaces(),
//                new CacheInvocationHandler(obj)
//        );
//    }
//
//    private static <T> T createClassProxy(T obj) {
//        return (T) Proxy.newProxyInstance(
//                obj.getClass().getClassLoader(),
//                obj.getClass().getInterfaces(),
//                new CacheInvocationHandler(obj)
//        );
//    }
//
//    private static class CacheInvocationHandler implements InvocationHandler {
//        private final Object target;
//        private final Map<Method, Object> cache = new HashMap<>();
//        private String lastState;
//
//        public CacheInvocationHandler(Object target) {
//            this.target = target;
//            this.lastState = serializeState(target);
//        }
//
//        @Override
//        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//            if (method.isAnnotationPresent(Invoke.class) && (args == null || args.length == 0)) {
//                String currentState = serializeState(target);
//                if (!cache.containsKey(method) || !currentState.equals(lastState)) {
//                    Object result = method.invoke(target, args);
//                    cache.put(method, result);
//                    lastState = currentState;
//                    return result;
//                } else {
//                    return cache.get(method);
//                }
//            } else {
//                return method.invoke(target, args);
//            }
//        }
//
//        private String serializeState(Object obj) {
//            // Простая сериализация состояния объекта
//            // Это можно улучшить в зависимости от требований
//            return obj.toString();
//        }
//    }
//}
