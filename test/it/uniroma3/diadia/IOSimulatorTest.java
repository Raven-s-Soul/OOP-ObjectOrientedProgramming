package it.uniroma3.diadia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class IOSimulatorTest {

	IOSimulator io;

    @BeforeEach
    void setUp() {
    	String Array[] = {"vai nord", "vai sud"};
        io = DiaDiaSetUpTest.Simulatore(Array, DiaDiaSetUpTest.exLabirinto());
    }

    @Test
    void testHasNextMsg() {
        assertTrue(io.hasNextMessaggio());
    }

    // TODO Fix IOSimulator

}