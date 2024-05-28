package io.logantect.springbatch.job

import org.slf4j.LoggerFactory
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.ItemWriter
import org.springframework.batch.item.database.JpaPagingItemReader
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.retry.backoff.FixedBackOffPolicy
import javax.persistence.EntityManagerFactory
import org.springframework.batch.core.annotation.BeforeStep
import org.springframework.batch.core.configuration.annotation.StepScope

private const val CHUNK_SIZE = 10

@Configuration
class JpaPagingItemReaderJobConfiguration(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory,
    private val entityManagerFactory: EntityManagerFactory,
) {
    private val log = LoggerFactory.getLogger(javaClass)

    @Bean
    fun jpaPagingItemReaderJob(): Job {
        return jobBuilderFactory["jpaPagingItemReaderJob"]
            .start(jpaPagingItemReaderStep())
            .build()
    }

    @Bean
    fun jpaPagingItemReaderStep(): Step {
        val fixedBackOffPolicy = FixedBackOffPolicy()
        fixedBackOffPolicy.backOffPeriod = 500

        return stepBuilderFactory["jpaPagingItemReaderStep"]
            .chunk<Pay, Pay>(CHUNK_SIZE)
            .reader(jpaPagingItemReader())
            .processor(itemProcessor())
            .writer(jpaPagingItemWriter())
            .faultTolerant()
            .retry(IllegalStateException::class.java)
            .retryLimit(Int.MAX_VALUE)
            .backOffPolicy(fixedBackOffPolicy)
            .build()
    }

    @Bean
    fun jpaPagingItemReader(): JpaPagingItemReader<Pay> {
        return JpaPagingItemReaderBuilder<Pay>()
            .name("jpaPagingItemReader")
            .entityManagerFactory(entityManagerFactory)
            .pageSize(CHUNK_SIZE)
            .queryString("SELECT p FROM Pay p order by p.amount")
            .build()
    }

    private fun itemProcessor() : ItemProcessor<Pay, Pay> {
        return ItemProcessor<Pay, Pay> {
            println("itemProcessor: ${it.amount}")
            if (it.amount == 658000L) {
                throw IllegalStateException("658000")
            }
            it
        }
    }

    @StepScope
    @Bean
    fun jpaPagingItemWriter(): ItemWriter<Pay> {
        return ItemWriter<Pay> { list ->
            for (pay in list) {
                log.info("Current Pay={}", pay)
            }
        }
    }
}
