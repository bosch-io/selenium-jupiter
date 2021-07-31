/*
 * (C) Copyright 2017 Boni Garcia (http://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package io.github.bonigarcia.seljup.test.advance;

// tag::snippet-in-doc[]
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.grid.Main;

import io.github.bonigarcia.seljup.DriverCapabilities;
import io.github.bonigarcia.seljup.DriverUrl;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import io.github.bonigarcia.wdm.WebDriverManager;

@ExtendWith(SeleniumJupiter.class)
class RemoteWebDriverJupiterTest {

    @DriverUrl
    String url = "http://localhost:4444/wd/hub";

    @BeforeAll
    static void setup() throws Exception {
        // Resolve drivers
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();

        // Start Selenium Grid in standalone mode
        Main.main(new String[] { "standalone", "--port", "4444" });
    }

    @DriverCapabilities
    Capabilities capabilities = new FirefoxOptions();

    @Test
    void testWithRemoteFirefox(WebDriver driver) {
        exercise(driver);
    }

    @Test
    void testWithRemoteChrome(
            @DriverUrl("http://localhost:4444/wd/hub") @DriverCapabilities("browserName=chrome") WebDriver driver) {
        exercise(driver);
    }

    void exercise(WebDriver driver) {
        driver.get("https://bonigarcia.org/selenium-jupiter/");
        assertThat(driver.getTitle()).contains("Selenium-Jupiter");
    }

}
// end::snippet-in-doc[]
