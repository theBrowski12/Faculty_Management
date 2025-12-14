package dcc.filiere_service;

import dcc.filiere_service.Entites.Filiere;
import dcc.filiere_service.Repository.FiliereRepository;
import dcc.filiere_service.Service.FiliereService;
import dcc.filiere_service.configuration.RsaKeys;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeys.class)
public class FiliereServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FiliereServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(FiliereRepository filiereRepository) {
        return args -> {
            Filiere filiere= Filiere.builder()
                    .code("DCC")
                    .libelle("devops and cloud computing")

                    .build();
            filiereRepository.save(filiere);


        };



    }
}
