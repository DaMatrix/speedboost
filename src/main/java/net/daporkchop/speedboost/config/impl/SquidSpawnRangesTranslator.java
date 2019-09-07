/*
 * Adapted from the Wizardry License
 *
 * Copyright (c) 2018-2019 DaPorkchop_ and contributors
 *
 * Permission is hereby granted to any persons and/or organizations using this software to copy, modify, merge, publish, and distribute it.
 * Said persons and/or organizations are not allowed to use the software or any derivatives of the work for commercial use or any other means to generate income, nor are they allowed to claim this software as their own.
 *
 * The persons and/or organizations are also disallowed from sub-licensing and/or trademarking this software without explicit permission from DaPorkchop_.
 *
 * Any persons and/or organizations using this software must disclose their source code and have it publicly available, include this license, provide sufficient credit to the original authors of the project (IE: DaPorkchop_), as well as provide a link to the original project.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package net.daporkchop.speedboost.config.impl;

import com.google.gson.JsonObject;
import net.daporkchop.speedboost.config.Config;
import net.daporkchop.speedboost.config.IConfigTranslator;

public class SquidSpawnRangesTranslator implements IConfigTranslator {
    public static final SquidSpawnRangesTranslator INSTANCE = new SquidSpawnRangesTranslator();
    public boolean state;
    public double squidMinSpawnHeight = 49.0d;
    public double squidMaxSpawnHeight = 64.0d;

    private SquidSpawnRangesTranslator() {

    }

    public void encode(JsonObject json) {
        json.addProperty("state", this.state);
        json.addProperty("squidMinSpawnHeight", this.squidMinSpawnHeight);
        json.addProperty("squidMaxSpawnHeight", this.squidMaxSpawnHeight);
    }

    public void decode(String fieldName, JsonObject json) {
        this.state = this.getBoolean(json, "state", this.state);
        this.squidMinSpawnHeight = this.getDouble(json, "squidMinSpawnHeight", this.squidMinSpawnHeight);
        this.squidMaxSpawnHeight = this.getDouble(json, "squidMaxSpawnHeight", this.squidMaxSpawnHeight);
        if (this.state) {
            Config.LOGGER.info("Squids will spawn between Y: " + this.squidMinSpawnHeight + " and Y: " + this.squidMaxSpawnHeight);
        }
    }

    public String name() {
        return "squidSpawnRanges";
    }

    public boolean getState() {
        return this.state;
    }

    public String getPackageName() {
        return "squidspawnranges";
    }
}