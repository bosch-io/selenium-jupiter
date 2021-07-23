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
package io.github.bonigarcia.seljup;

/**
 * Enumeration for browsers in Docker containers.
 *
 * @author Boni Garcia
 * @since 1.2.0
 */
public enum BrowserType {

    CHROME, FIREFOX, OPERA, EDGE, SAFARI, CHROME_MOBILE;

    public String toBrowserName() {
        switch (this) {
        case CHROME_MOBILE:
            return CHROME.name();
        default:
            return this.name();
        }
    }

}
