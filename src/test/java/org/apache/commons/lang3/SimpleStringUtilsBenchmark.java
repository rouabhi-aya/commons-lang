/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.apache.commons.lang3;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;

public class SimpleStringUtilsBenchmark {

    private static final String[] DATA = {
            "Apache",
            "Commons",
            "Lang",
            "Benchmark"
    };

    private static final String TEXT =
            "Apache Commons Lang is a Java library providing helper utilities";

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 3)
    @Measurement(iterations = 5)
    @Fork(1)
    public String benchmarkStringJoin() {
        return StringUtils.join(DATA, ',');
    }


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 3)
    @Measurement(iterations = 5)
    @Fork(1)
    public String[] benchmarkStringSplit() {
        return StringUtils.split(TEXT);
    }


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 3)
    @Measurement(iterations = 5)
    @Fork(1)
    public String benchmarkStringReplace() {
        return StringUtils.replace(
                TEXT,
                "Java",
                "Kotlin"
        );
    }
}
