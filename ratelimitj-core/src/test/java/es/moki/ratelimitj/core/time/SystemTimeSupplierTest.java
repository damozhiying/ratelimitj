package es.moki.ratelimitj.core.time;


import es.moki.ratelimitj.core.time.time.SystemTimeSupplier;
import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SystemTimeSupplierTest {

    @Test
    public void shouldGetSystemCurrentTime() {
        Long time = new SystemTimeSupplier().get();
        assertThat(time).isCloseTo(System.currentTimeMillis() / 1000L, Offset.offset(2L));
    }

    @Test
    public void shouldGetAsyncSystemCurrentTime() throws Exception {
        Long time = new SystemTimeSupplier().getAsync().toCompletableFuture().get();
        assertThat(time).isCloseTo(System.currentTimeMillis() / 1000L, Offset.offset(2L));
    }
}