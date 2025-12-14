package dcc.etudiant_service.FeignClient;


import dcc.etudiant_service.DTO.Filiere;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "Filiere-Service",
        url = "http://localhost:8081/v1/filieres"
)
public interface FiliereClient {
    @CircuitBreaker(name = "filiere",fallbackMethod = "filiere_fallback")
    @Retry(
            name = "filiere",
            fallbackMethod = "filiere_fallback"

    )
    @RateLimiter(
            name = "filiere",
            fallbackMethod = "filiere_fallback"

    )
    @Bulkhead(
            name = "filiere",
            fallbackMethod = "filiere_fallback",
            type = Bulkhead.Type.SEMAPHORE
    )
    @Cacheable(
            value = "filiere-cache",
            key = "#id"

    )
    @GetMapping("/{id}")
    public Filiere getFiliereById(@PathVariable("id") Integer id);

default Filiere filiere_fallback(Integer id,Throwable  e) {

    return new Filiere(100,"not exsite","not exsite");
}

}
