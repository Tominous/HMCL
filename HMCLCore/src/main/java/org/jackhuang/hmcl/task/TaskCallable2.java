/*
 * Hello Minecraft! Launcher.
 * Copyright (C) 2017  huangyuhui <huanghongxun2008@126.com>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see {http://www.gnu.org/licenses/}.
 */
package org.jackhuang.hmcl.task;

import java.util.function.Function;
import org.jackhuang.hmcl.util.AutoTypingMap;

/**
 *
 * @author huangyuhui
 */
class TaskCallable2<V> extends TaskResult<V> {

    private final String id;
    private final Function<AutoTypingMap<String>, V> callable;

    public TaskCallable2(String id, Function<AutoTypingMap<String>, V> callable) {
        this.id = id;
        this.callable = callable;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void execute() throws Exception {
        setResult(callable.apply(getVariables()));
    }
}