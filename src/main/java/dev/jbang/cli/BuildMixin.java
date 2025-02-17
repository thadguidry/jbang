package dev.jbang.cli;

import java.util.List;

import picocli.CommandLine;

public class BuildMixin {
	public String javaVersion;

	@CommandLine.Option(names = { "-j",
			"--java" }, description = "JDK version to use for running the script.")
	void setJavaVersion(String javaVersion) {
		if (!javaVersion.matches("\\d+[+]?")) {
			throw new IllegalArgumentException(
					"Invalid version, should be a number optionally followed by a plus sign");
		}
		this.javaVersion = javaVersion;
	}

	@CommandLine.Option(names = { "-m",
			"--main" }, description = "Main class to use when running. Used primarily for running jar's.")
	String main;

	@CommandLine.Option(names = { "-C", "--compile-option" }, description = "Options to pass to the compiler")
	public List<String> compileOptions;

	@CommandLine.Option(names = { "-N", "--native-option" }, description = "Options to pass to the native image tool")
	public List<String> nativeOptions;
}
