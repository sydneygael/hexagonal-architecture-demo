package com.sadjoumoumouni.demo.hexagon.springbootapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sadjoumoumouni.demo.hexagon.adapters.product.drivens.InMemoryPersistenceAdapter;
import com.sadjoumoumouni.demo.hexagon.adapters.product.drivens.JpaProductPersistenceAdapter;
import com.sadjoumoumouni.demo.hexagon.adapters.product.drivens.JpaUserPersistenceAdapter;
import com.sadjoumoumouni.demo.hexagon.adapters.product.drivens.jpa.repository.ProductJpaRepository;
import com.sadjoumoumouni.demo.hexagon.adapters.product.drivens.jpa.repository.UserJpaRepository;
import com.sadjoumoumouni.demo.hexagon.core.product.ProductFacade;
import com.sadjoumoumouni.demo.hexagon.core.user.UserFacade;
import com.sadjoumoumouni.demo.hexagon.springbootapp.controller.SpringProductController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ComponentScan(basePackageClasses = { SpringProductController.class })
@EnableJpaRepositories(basePackages = "com.sadjoumoumouni.demo.hexagon.adapters.product.drivens")
@Import(SpringDataRestConfiguration.class)
@EnableSwagger2
public class Config {

    private InMemoryPersistenceAdapter inMemoryPersistenceAdapter = new InMemoryPersistenceAdapter();

    /**
     *  By default we use in memory database if no configuration is founded
     * @return ProductService
     */
    @Bean
    @ConditionalOnMissingBean(DataSourceAutoConfiguration.class)
    ProductFacade memoryProductService() {
        return new ProductFacade(inMemoryPersistenceAdapter, memoryUserService());
    }

    @Bean
    @ConditionalOnMissingBean(DataSourceAutoConfiguration.class)
    UserFacade memoryUserService() {
        return new UserFacade(inMemoryPersistenceAdapter);
    }

    @Bean
    @ConditionalOnProperty(value = "database.module.use", havingValue = "h2")
    @Primary
    @Autowired
    UserFacade databaseUserFacade(UserJpaRepository userJpaRepository) {
        return new UserFacade(new JpaUserPersistenceAdapter(userJpaRepository));
    }

    @Bean
    @ConditionalOnProperty(value = "database.module.use", havingValue = "h2")
    @Primary
    @Autowired
    ProductFacade databaseProductService(ProductJpaRepository productJpaRepository, UserFacade userFacade) {
        return new ProductFacade(new JpaProductPersistenceAdapter(productJpaRepository),userFacade);
    }

    @Bean
    public Docket apiV2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.sadjoumoumouni.demo.hexagon.springbootapp.controller"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .apiInfo(createApiInfo());
    }

    private ApiInfo createApiInfo() {
        return new ApiInfoBuilder().title("HEXAGONAL ARCHITECTURE DEMO").version(SpringProductController.class.getPackage().getImplementationVersion()).build();
    }

}
