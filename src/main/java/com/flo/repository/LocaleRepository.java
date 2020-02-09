package com.flo.repository;

import com.flo.model.Locale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocaleRepository extends JpaRepository<Locale,Long> {
    boolean existsByLocaleName(String locale);
    Locale findByLocaleName(String locale);

}
