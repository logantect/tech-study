package io.logantect.springbatch

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalDateTime

@EnableBatchProcessing
@SpringBootApplication
class LearningSpringbatchApplication

fun main(args: Array<String>) {
    runApplication<LearningSpringbatchApplication>(*args)
}
