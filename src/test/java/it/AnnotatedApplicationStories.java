package it;

import static java.util.Arrays.*;
import static org.jbehave.core.io.CodeLocations.*;
import static org.jbehave.core.reporters.Format.*;
import static org.jbehave.web.selenium.WebDriverHtmlOutput.*;

import java.util.List;

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.spring.UsingSpring;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.spring.SpringAnnotatedEmbedderRunner;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.web.selenium.ContextView;
import org.jbehave.web.selenium.LocalFrameContextView;
import org.jbehave.web.selenium.SeleniumConfiguration;
import org.jbehave.web.selenium.SeleniumContext;
import org.jbehave.web.selenium.SeleniumContextOutput;
import org.jbehave.web.selenium.SeleniumStepMonitor;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringAnnotatedEmbedderRunner.class)
@Configure(using = SeleniumConfiguration.class, pendingStepStrategy = FailingUponPendingStep.class)
@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = true, ignoreFailureInView = false, storyTimeoutInSecs = 100, threads = 1, metaFilters = "-skip")
@UsingSpring(resources = { "jbehave-steps.xml" })
public class AnnotatedApplicationStories extends InjectableEmbedder {

	public AnnotatedApplicationStories() {
	}

	@Override
	@Test
	public void run() throws Throwable {
		final CrossReference crossReference = new CrossReference();
		crossReference.withJsonOnly();
		crossReference.withOutputAfterEachStory(true);
		crossReference.excludingStoriesWithNoExecutedScenarios(true);

		final ContextView contextView = new LocalFrameContextView().sized(640, 120);
		final SeleniumContext seleniumContext = new SeleniumContext();
		final SeleniumStepMonitor stepMonitor = new SeleniumStepMonitor(contextView, seleniumContext,
				crossReference.getStepMonitor());

		final Format[] formats = new Format[] { new SeleniumContextOutput(seleniumContext), CONSOLE, WEB_DRIVER_HTML };

		final StoryReporterBuilder reporterBuilder = new StoryReporterBuilder();
		reporterBuilder.withCodeLocation(codeLocationFromClass(getClass()));
		reporterBuilder.withFailureTrace(true);
		reporterBuilder.withFailureTraceCompression(false);
		reporterBuilder.withDefaultFormats();
		reporterBuilder.withFormats(formats);
		reporterBuilder.withCrossReference(crossReference);

		final StoryControls storyControls = new StoryControls();
		storyControls.doResetStateBeforeScenario(true);
		storyControls.doResetStateBeforeStory(true);
		final Configuration configuration = injectedEmbedder().configuration();
		configuration.useFailureStrategy(new FailingUponPendingStep());
		configuration.useStoryControls(storyControls);
		configuration.useStepMonitor(stepMonitor);
		configuration.useStoryLoader(new LoadFromClasspath(getClass()));
		configuration.useStoryReporterBuilder(reporterBuilder);
		if (configuration instanceof SeleniumConfiguration) {
			final SeleniumConfiguration seleniumConfiguration = (SeleniumConfiguration) configuration;
			seleniumConfiguration.useSeleniumContext(seleniumContext);
		}
		injectedEmbedder().runStoriesAsPaths(storyPaths());
	}

	protected List<String> storyPaths() {
		final List<String> asList = asList("**/*.story");
		final String file = codeLocationFromClass(this.getClass()).getFile();
		return new StoryFinder().findPaths(file, asList, null);
	}
}
