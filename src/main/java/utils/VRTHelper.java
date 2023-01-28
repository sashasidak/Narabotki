package utils;

import io.visual_regression_tracker.sdk_java.TestRunOptions;
import io.visual_regression_tracker.sdk_java.VisualRegressionTracker;
import io.visual_regression_tracker.sdk_java.VisualRegressionTrackerConfig;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

import static General.TestBase.driver;


public class VRTHelper {
	private String CI_BUILD_ID = String.valueOf(System.currentTimeMillis());

	VisualRegressionTrackerConfig config = new VisualRegressionTrackerConfig(

			"http://127.0.0.1:4200",
			"Default project",
			"ZEGSCKENPFMD1FPDZ9CNHGN38JJ1",
			"master",
			false,
			CI_BUILD_ID,
			15
	);
	VisualRegressionTracker visualRegressionTracker = new VisualRegressionTracker(config);
	public void  start() throws IOException {
		visualRegressionTracker.start();
	}

	public void stop() throws IOException {
			visualRegressionTracker.stop();
	}


	public String screenShot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}


	public void track(String name) throws IOException, InterruptedException {
		//Добавляю задержку в связи с тем что у нас практически везде все ждет флаг с бека и нужно время на запрос/ответ, чтобы отобразилась 100% инфа
		Thread.sleep(1500);
		start();
		visualRegressionTracker.track(name,
				screenShot(),
				TestRunOptions.builder()
						.browser("a24")
						.os("Android")
						.viewport("1200x800")
						.diffTollerancePercent(1.0f)
						.build()
		);
		stop();
	}

}
