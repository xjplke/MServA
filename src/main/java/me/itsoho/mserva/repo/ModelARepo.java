package me.itsoho.mserva.repo;

import me.itsoho.mserva.model.ModelA;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ModelARepo extends PagingAndSortingRepository<ModelA, Long> {

}
