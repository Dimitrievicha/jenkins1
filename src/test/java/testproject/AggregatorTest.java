package testproject;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class AggregatorTest {

    @Test
    public void testInitialState() {
        Aggregator agr = new Aggregator();
        assertThat(agr.getSum()).isZero();
    }

    @Test
    public void testSingleAddition() {
        Aggregator agr = new Aggregator();
        double val = 20;
        agr.addValue(val);
        assertThat(agr.getSum()).isEqualTo(val);
    }

    @Test
    public void testMultipleAdditions() {
        Aggregator agr = new Aggregator();
        double val = 15;
        agr.addValue(val);
        agr.addValue(val);
        assertThat(agr.getSum()).isEqualTo(val * 2);
    }

    @Test
    public void testReset() {
        Aggregator agr = new Aggregator();
        agr.addValue(10);
        agr.addValue(20);

        assertThat(agr.getSum()).isEqualTo(30);
        agr.reset();

        assertThat(agr.getSum()).isZero();

        agr.addValue(5);
        assertThat(agr.getSum()).isEqualTo(5);
    }

    @Test
    public void testAddNegativeValues() {
        Aggregator agr = new Aggregator();
        agr.addValue(10);
        agr.addValue(-3);
        assertThat(agr.getSum()).isEqualTo(7);
    }

    @Test
    public void testAddZero() {
        Aggregator agr = new Aggregator();
        agr.addValue(0);
        agr.addValue(5);
        assertThat(agr.getSum()).isEqualTo(5);
    }

    @Test
    public void testMultipleReset() {
        Aggregator agr = new Aggregator();
        agr.addValue(100);
        agr.reset();
        agr.reset();
        agr.addValue(1);
        assertThat(agr.getSum()).isEqualTo(1);
    }
}
