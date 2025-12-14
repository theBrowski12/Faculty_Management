package dcc.etudiant_service;

import dcc.etudiant_service.configuration.RsaKeys;
import dcc.etudiant_service.entity.Etudiant;
import dcc.etudiant_service.repository.EtudiantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeys.class)
@EnableFeignClients
@EnableCaching
public class EtudiantServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EtudiantServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(EtudiantRepository etudiantRepository) {
        return args -> {

            etudiantRepository.save(Etudiant.builder()

                    .cne("k15458845")
                    .idFiliere(1)
                    .nom("ouseffar")
                    .prenom("othman")


                    .build());


        };



    }
}
