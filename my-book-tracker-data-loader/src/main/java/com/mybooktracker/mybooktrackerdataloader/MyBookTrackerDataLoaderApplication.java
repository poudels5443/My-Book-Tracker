package com.mybooktracker.mybooktrackerdataloader;

import java.nio.file.Path;

import javax.annotation.PostConstruct;

import com.mybooktracker.mybooktrackerdataloader.author.Author;
import com.mybooktracker.mybooktrackerdataloader.author.AuthorRepository;
import com.mybooktracker.mybooktrackerdataloader.connection.DataStaxAstraProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@EnableConfigurationProperties(DataStaxAstraProperties.class)
@ComponentScan(basePackages = {"com.mybooktracker.mybooktrackerdataloader"})
public class MyBookTrackerDataLoaderApplication {

    @Autowired 
    AuthorRepository authorRepository;


    
	public static void main(String[] args) {
		SpringApplication.run(MyBookTrackerDataLoaderApplication.class, args);
	}


    


    @PostConstruct
    public void start(){
        System.out.println("Hey there this is Safal");
        Author author = new Author();
        author.setId("id");
        author.setName("name");
        author.setPersonalName("personalName");
        authorRepository.save(author);

    }


	@Bean
    public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties astraProperties) {
        Path bundle = astraProperties.getSecureConnectBundle().toPath();
        return builder -> builder.withCloudSecureConnectBundle(bundle);
    }

}
