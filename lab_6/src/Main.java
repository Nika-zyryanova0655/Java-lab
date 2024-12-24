public class Main {
    public static void main(String[] args) {
        Example example = new ExampleImpl(-8);
        Example cachedExample = CacheUtil.cache(example);

        // Проверка аннотации @ToString
        if (example.getClass().isAnnotationPresent(ToString.class)) {
            ToString toStringAnnotation = example.getClass().getAnnotation(ToString.class);
            System.out.println("ToString value: " + toStringAnnotation.value());
        }

        // Проверка аннотации @Two
        if (example.getClass().isAnnotationPresent(Two.class)) {
            Two twoAnnotation = example.getClass().getAnnotation(Two.class);
            System.out.println("First value: " + twoAnnotation.first());
            System.out.println("Second value: " + twoAnnotation.second());
        }

        // Проверка аннотации @Cache
        if (example.getClass().isAnnotationPresent(Cache.class)) {
            Cache cacheAnnotation = example.getClass().getAnnotation(Cache.class);
            System.out.println("Cache values: " + String.join(", ", cacheAnnotation.value()));


            // Первый вызов метода getValue
            System.out.println(cachedExample.getValue()); // Метод вызывается, результат кэшируется

            // Второй вызов метода getValue
            System.out.println(cachedExample.getValue()); // Возвращается кэшированный результат

            // Изменение состояния
            cachedExample.incrementValue();

            // Третий вызов метода getValue
            System.out.println(cachedExample.getValue()); // Метод вызывается снова, результат кэшируется

//        ExampleImpl exampleImpl = new ExampleImpl(10);
//        ExampleImpl exampleImpl2 = new ExampleImpl(20);
//
//        Object[] cachedObjects = CacheUtil.cache(exampleImpl, exampleImpl2);
//
//        Example cachedExample = (Example) cachedObjects[0];
//        Example cachedExample2 = (Example) cachedObjects[1];
//
//        System.out.println("Initial value: " + cachedExample.getValue());
//        cachedExample.incrementValue();
//        System.out.println("After increment: " + cachedExample.getValue());
//
//        System.out.println("Initial value: " + cachedExample2.getValue());
//        cachedExample2.incrementValue();
//        System.out.println("After increment: " + cachedExample2.getValue());
        }
    }
}