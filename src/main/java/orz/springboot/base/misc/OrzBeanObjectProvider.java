package orz.springboot.base.misc;

import jakarta.annotation.Nonnull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.ObjectProvider;

import java.util.List;
import java.util.stream.Stream;

@Slf4j
public class OrzBeanObjectProvider<T> implements ObjectProvider<T> {
    private final List<T> objects;

    private OrzBeanObjectProvider(List<T> objects) {
        this.objects = objects;
    }

    public static <T> OrzBeanObjectProvider<T> of(List<T> objects) {
        return new OrzBeanObjectProvider<>(objects);
    }

    public static <T> OrzBeanObjectProvider<T> of(T object) {
        return new OrzBeanObjectProvider<>(List.of(object));
    }

    public static <T> OrzBeanObjectProvider<T> empty() {
        return new OrzBeanObjectProvider<>(List.of());
    }

    @Nonnull
    @Override
    public T getObject() throws BeansException {
        if (objects.isEmpty()) {
            throw new FatalBeanException("No object available");
        }
        return objects.get(0);
    }

    @Nonnull
    @Override
    public T getObject(@Nonnull Object... args) throws BeansException {
        log.warn("getObject(Object... args) not implemented, returning first object");
        if (objects.isEmpty()) {
            throw new FatalBeanException("No object available");
        }
        return objects.get(0);
    }

    @Override
    public T getIfAvailable() throws BeansException {
        if (objects.isEmpty()) {
            return null;
        }
        return objects.get(0);
    }

    @Override
    public T getIfUnique() throws BeansException {
        if (objects.size() != 1) {
            return null;
        }
        return objects.get(0);
    }

    @Nonnull
    @Override
    public Stream<T> stream() {
        return objects.stream();
    }

    @Nonnull
    @Override
    public Stream<T> orderedStream() {
        return objects.stream();
    }
}
