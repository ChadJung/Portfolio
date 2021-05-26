package com.portfolio.website.common;

import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

public class CustomBanner implements Banner {

    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
        out.println("   __ ______               _     __         _  _         __   ");
        out.println("  / / | ___ \\             | |   / _|       | |(_)        \\ \\  ");
        out.println(" / /  | |_/ /  ___   _ __ | |_ | |_   ___  | | _   ___    \\ \\ ");
        out.println("< <   |  __/  / _ \\ | '__|| __||  _| / _ \\ | || | / _ \\    > >");
        out.println(" \\ \\  | |    | (_) || |   | |_ | |  | (_) || || || (_) |  / / ");
        out.println("  \\_\\ \\_|     \\___/ |_|    \\__||_|   \\___/ |_||_| \\___/  /_/  ");
        out.println(":: Project :: " + environment.getProperty("project.name"));
        out.println(":: Version :: " + environment.getProperty("project.version"));
        out.println(":: State   :: " + environment.getProperty("project.state"));
        out.println(" ");
    }
}
