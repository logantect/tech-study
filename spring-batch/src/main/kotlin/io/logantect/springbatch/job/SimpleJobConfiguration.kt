package io.logantect.springbatch.job

import org.slf4j.LoggerFactory
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SimpleJobConfiguration(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory,
) {
    private val log = LoggerFactory.getLogger(javaClass)
    @Bean
    fun simpleJob(): Job {
        return jobBuilderFactory.get("simpleJob")
            .start(simpleStep1())
            .build()
    }

    @Bean
    fun simpleStep1(): Step {
        return stepBuilderFactory["simpleStep1"]
            .tasklet { _: StepContribution, _: ChunkContext ->
                log.info(">>>>> This is Step1")
                RepeatStatus.FINISHED
            }
            .build()
    }
}