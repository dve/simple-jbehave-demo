package net.vergien.jbehave.demo.simple;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import net.vergien.jbehave.demo.simple.steps.StackSteps;

public class StackStories extends JUnitStories {
	// Here we specify the configuration, starting from default
	// MostUsefulConfiguration, and changing only what is needed

	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration()
				// where to find the stories
				.useStoryLoader(new LoadFromClasspath(StackStories.class))
				// CONSOLE and TXT reporting
				.useStoryReporterBuilder(
						new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE, Format.TXT));
	}

	// Here we specify the steps classes
	@Override
	public InjectableStepsFactory stepsFactory() {
		// varargs, can have more that one steps classes
		return new InstanceStepsFactory(configuration(), new StackSteps());
	}

	@Override
	protected List<String> storyPaths() {
		return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()).getFile(),
				asList("**/" + System.getProperty("storyFilter", "*") + ".story"), null);
	}
}
