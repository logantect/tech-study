package io.logantect.springbatch.job

import org.slf4j.LoggerFactory
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.item.ItemWriter
import org.springframework.batch.item.database.JdbcPagingItemReader
import org.springframework.batch.item.database.Order
import org.springframework.batch.item.database.PagingQueryProvider
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.BeanPropertyRowMapper
import javax.sql.DataSource

private const val CHUNK_SIZE = 10

@Configuration
class JdbcPagingItemReaderJobConfiguration(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory,
    private val dataSource: DataSource,
) {
    private val log = LoggerFactory.getLogger(javaClass)

    @Bean
    fun jdbcPagingItemReaderJob(): Job {
        return jobBuilderFactory["jdbcPagingItemReaderJob"]
            .start(jdbcPagingItemReaderStep())
            .build()
    }

    @Bean
    fun jdbcPagingItemReaderStep(): Step {
        return stepBuilderFactory["jdbcPagingItemReaderStep"]
            .chunk<Pay, Pay>(CHUNK_SIZE)
            .reader(jdbcPagingItemReader())
            .writer(jdbcPagingItemWriter())
            .build()
    }

    @Bean
    fun jdbcPagingItemReader(): JdbcPagingItemReader<Pay> {
        val parameterValues = mapOf("amount" to 2000)
        return JdbcPagingItemReaderBuilder<Pay>()
            .pageSize(CHUNK_SIZE)
            .fetchSize(CHUNK_SIZE)
            .dataSource(dataSource)
            .rowMapper(BeanPropertyRowMapper(Pay::class.java))
            .queryProvider(createQueryProvider())
            .parameterValues(parameterValues)
            .name("jdbcPagingItemReader")
            .build()
    }

    private fun jdbcPagingItemWriter(): ItemWriter<Pay> {
        return ItemWriter<Pay> { list: List<Pay> ->
            for (pay in list) {
                log.info("Current Pay={}", pay)
            }
        }
    }

    @Bean
    fun createQueryProvider(): PagingQueryProvider {
        val queryProvider = SqlPagingQueryProviderFactoryBean()
        queryProvider.setDataSource(dataSource)
        queryProvider.setSelectClause("id, amount, tx_name, tx_date_time")
        queryProvider.setFromClause("from pay")
        queryProvider.setWhereClause("where amount >= :amount")
        queryProvider.setSortKeys(mapOf("id" to Order.DESCENDING))
        return queryProvider.`object`
    }
}