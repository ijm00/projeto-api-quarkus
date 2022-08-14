package com.bblc;


import javax.inject.Inject;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Main {
    public static void main(String[] args) {
        Quarkus.run(ProjectApp.class, args);
    }

    public static class ProjectApp implements QuarkusApplication {
        @Override
        public int run(String... args) throws Exception {
            


            Quarkus.waitForExit();
            return 0;
        }
    }
}
