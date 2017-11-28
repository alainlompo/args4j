package org.kohsuke.args4j.extensions;

import org.junit.*;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by alompo on 28.11.17.
 */
public class SampleTests {

    @Option(name = "-h", usage = "this is H", forbids={"-b", "-c"})
    boolean h;

    @Option(name = "-p", usage = "this is P")
    String p;

    private Locale oldDefault;

    @Before
    public void setUp() {
        oldDefault = Locale.getDefault();
        Locale.setDefault(Locale.ENGLISH);
    }

    @After
    public void tearDown() throws Exception {
        Locale.setDefault(oldDefault);
    }

    @Test
    public void whenH_isProvidedAndNotBAndNotC_thenOk() throws CmdLineException {
        CmdLineParser parser = new CmdLineParser(this);
        parser.parseArgument("-p", "125", "-h");
        assertThat(h).isTrue();

    }
}
