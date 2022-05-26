package coding.stream;

import java.util.stream.Stream;

public class Event<T> {

    T data;

    public Event(T data) {
        this.data = data;
    }

    static class EventData {
        Integer id;
        String msg;

        public EventData(Integer id, String msg) {
            this.id = id;
            this.msg = msg;
        }

        @Override
        public String toString() {
            return "EventData{" +
                    "id=" + id +
                    ", msg='" + msg + '\'' +
                    '}';
        }
    }

//    static class Transforms {
//        static EventData transform(Integer id) {
//            return switch (id) {
//                case 0 -> new EventData(id, "start");
//                case 1 -> new EventData(id, "running");
//                case 2 -> new EventData(id, "done");
//                default -> new EventData(id, "Error");
//            };
//        }
//    }

    @FunctionalInterface
    interface FN<A,B> {
        B apply(A a);
    }

    <B> Event<?> map(FN<T, B> f) {
        return new Event<>(f.apply(this.data));
    }

//    public static void main(String[] args) {
//        Stream<Event<Integer>> s = Stream.of(
//                new Event<>(1),
//                new Event<>(2),
//                new Event<>(0),
//                new Event<>(10)
//        );
//        s.map(event -> event.map(Transforms::transform))
//                .forEach(e -> System.out.println(e.data));
//    }
}
