/*
 * (C) Copyright 2019 Boni Garcia (http://bonigarcia.github.io/)
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
package io.github.bonigarcia.seljup.test.selenide;

// tag::snippet-in-doc[]
import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.codeborne.selenide.Condition.visible;
import static org.openqa.selenium.By.linkText;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;

import io.github.bonigarcia.seljup.SelenideConfiguration;
import io.github.bonigarcia.seljup.SeleniumExtension;

@ExtendWith(SeleniumExtension.class)
public class SelenideGlobalConfigJupiterTest {

    @SelenideConfiguration
    SelenideConfig selenideConfig = new SelenideConfig().browser(FIREFOX)
            .startMaximized(true);

    @Test
    public void testSelenideConfig(SelenideDriver driver) {
        driver.open("https://bonigarcia.github.io/selenium-jupiter/");
        SelenideElement about = driver.$(linkText("About"));
        about.shouldBe(visible);
        about.click();
    }

}
// end::snippet-in-doc[]